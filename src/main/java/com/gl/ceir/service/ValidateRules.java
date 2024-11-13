package com.gl.ceir.service;

import com.gl.ceir.builder.*;
import com.gl.ceir.dto.ActiveForeignImeiWithDifferentImsiDto;
import com.gl.ceir.dto.ActiveUniqueForeignImeiDto;
import com.gl.ceir.dto.ActiveUniqueImeiDto;
import com.gl.ceir.dto.RuleEngineDto;
import com.gl.ceir.enums.Rules;
import com.gl.ceir.model.app.*;
import com.gl.ceir.model.output.ForeignExceptionList;
import com.gl.ceir.model.output.ForeignWhitelist;
import com.gl.ceir.model.output.NationalWhitelist;
import com.gl.ceir.model.audit.ModulesAuditTrail;
import com.gl.ceir.repository.sysParam.GenericRepository;
import com.gl.ceir.model.sysParam.CfgFeatureAlert;
import com.gl.ceir.model.sysParam.RuleEngineMapping;
import com.gl.ceir.model.sysParam.SystemConfigurationDb;
import com.gl.ceir.repository.app.*;
import com.gl.ceir.repository.audit.ModulesAuditTrailRepository;
import com.gl.ceir.repository.sysParam.CfgFeatureAlertRepository;
import com.gl.ceir.repository.sysParam.RuleEngineMappingRepository;
import com.gl.ceir.repository.sysParam.SystemConfigurationDbRepository;
import com.gl.ceir.rules.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ValidateRules implements Runnable{
    private final Logger log = LogManager.getLogger(getClass());
    private volatile long lastProgressTime = System.currentTimeMillis();
    @Value("${whitelist.batch.size}")
    private Integer batchSize;
    @Autowired
    RuleEngineMappingRepository ruleEngineMappingRepository;
    @Autowired
    ActiveUniqueImeiRepository activeUniqueImeiRepository;
    @Autowired
    NationalWhitelistService nationalWhitelistService;
    @Autowired
    ExceptionListService exceptionListService;
    @Autowired
    ActiveImeiWithDifferentMsisdnRepository activeImeiWithDifferentMsisdnRepository;
    @Autowired
    SystemConfigurationDbRepository systemConfigurationDbRepository;
    @Autowired
    ActiveForeignImeiWithDifferentMsisdnRepository activeForeignImeiWithDifferentMsisdnRepository;
    @Autowired
    ActiveUniqueForeignImeiRepository activeUniqueForeignImeiRepository;
    @Autowired
    ActiveUniqueImeiEdrRepository activeUniqueImeiEdrRepository;
    @Autowired
    ActiveUniqueForeignImeiEdrRepository activeUniqueForeignImeiEdrRepository;
    @Autowired
    ActiveForeignImeiWithDifferentMsisdnEdrRepository activeForeignImeiWithDifferentMsisdnEdrRepository;
    @Autowired
    GenericRepository genericRepository;
    @Autowired
    CfgFeatureAlertRepository cfgFeatureAlertRepository;
    @Autowired
    ModulesAuditTrailRepository modulesAuditTrailRepository;
    @Autowired
    ForeignExceptionListService foreignExceptionListService;
    @Autowired
    ForeignWhitelistService foreignWhitelistService;
    @Autowired
    Environment env;
    @Autowired
    VALID_TAC validTac;
    @Autowired
    IMEI_NULL imeiNull;
    @Autowired
    IMEI_TEST imeiTest;
    @Autowired
    IMEI_LENGTH imeiLength;
    @Autowired
    IMEI_ALPHANUMERIC imeiAlphanumeric;
    @Autowired
    CUSTOM_CHK customChk;
    @Autowired
    TYPE_APPROVED typeApproved;
    @Autowired
    EXISTS_IN_LOCAL_MANUFACTURER_DB existsInLocalManufacturerDb;
    @Autowired
    CommonService commonService;
    @Autowired
    AlertService alertService;

    @Override
    public void run() {
        int executionStartTime = Math.toIntExact(System.currentTimeMillis() / 1000);
        String profile = env.getProperty("nwl.input.schema");
        Boolean usage = Boolean.valueOf(env.getProperty("mdr_separate_usage"));
        String MODULE_NAME = profile + ":";
        log.info("Starting national whitelist process. Profile: "+profile);
        int moduleAudiTrailId = 0;
        int foreignModuleTrailId = 0;
        int nwlCount = 0;
        int foreignWhitelistCount = 0;
        int foreignExceptionListCount = 0;
        boolean amnestyPeriodFlag = false;
        boolean skip = false;
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//        TimeZone serverTimeZone = TimeZone.getDefault();
//        System.out.println("Server Time Zone ID: " + serverTimeZone.getID());
//        System.out.println("Server Time Zone Display Name: " + serverTimeZone.getDisplayName());
        if(batchSize == null) {
            batchSize = 1000000;
        }
        LocalDateTime startTime = LocalDateTime.now();
        try {
            ModulesAuditTrail startAudit = ModulesAuditTrailBuilder.forInsert(201, "created", "NA", "National Whitelist", "INSERT", 0,"Started National Process", MODULE_NAME+"national_whitelist", startTime, executionStartTime);
            startAudit = modulesAuditTrailRepository.save(startAudit);
            moduleAudiTrailId = startAudit.getId();
            Optional<SystemConfigurationDb> activeUniqueImeiDate = Optional.ofNullable(systemConfigurationDbRepository.getByTag(profile+"_nw_unique_imei_last_run_time"));
            Optional<SystemConfigurationDb> amnestyPeriodDate = Optional.ofNullable(systemConfigurationDbRepository.getByTag("GRACE_PERIOD_END_DATE"));
            Optional<SystemConfigurationDb> allowedDeviceTypes = Optional.ofNullable(systemConfigurationDbRepository.getByTag("allowed_device_type"));// dongle,watch,smartwatch
            if (amnestyPeriodDate.isPresent()){
                amnestyPeriodFlag = isBeforeOrEqualAmnestyPeriod(amnestyPeriodDate.get().getValue());
            }
            String cdrProcessingTimestamp = Optional.ofNullable(genericRepository.getCdrProcessingTimestamp()).orElseThrow(() -> new Exception("CDR Not Processed Yet"));
            String activeUniqueImeisLastRunDate = "";
            String activeUniqueImeisLastRunEndDate = "";
            boolean newLastRunTimeIsUpdate = false;

            if(activeUniqueImeiDate.isPresent()) {
                activeUniqueImeisLastRunDate = formatDateString(activeUniqueImeiDate.get().getValue());
                int compareDate = compareDates(activeUniqueImeisLastRunDate, cdrProcessingTimestamp);
                if (compareDate > 0) {
                    if (compareDates(addOneDayToDate(activeUniqueImeisLastRunDate), cdrProcessingTimestamp) > 0) {
                        newLastRunTimeIsUpdate = true;

//                            SystemConfigurationDb activeUniqueImeiLatestDate = activeUniqueImeiDate.get();
//                            activeUniqueImeiLatestDate.setValue(addOneDayToDate(activeUniqueImeisLastRunDate));
//                            systemConfigurationDbRepository.save(activeUniqueImeiLatestDate);
                        activeUniqueImeisLastRunEndDate = addOneDayToDate(activeUniqueImeisLastRunDate);
                    } else {
                        newLastRunTimeIsUpdate = true;

//                            SystemConfigurationDb activeUniqueImeiLatestDate = activeUniqueImeiDate.get();
//                            activeUniqueImeiLatestDate.setValue(cdrProcessingTimestamp);
//                            systemConfigurationDbRepository.save(activeUniqueImeiLatestDate);
                        activeUniqueImeisLastRunEndDate = cdrProcessingTimestamp;
                    }
                }
            } else {
                String inputDateString = "";
                if ("app".equals(profile)) {
                    inputDateString = activeUniqueImeiRepository.getEarliestActiveTimestamp();
                } else if ("app_edr".equals(profile)) {
                    inputDateString = activeUniqueImeiEdrRepository.getEarliestActiveTimestamp();
                }
                if (inputDateString != null){
                    activeUniqueImeisLastRunDate = formatDateString(inputDateString);
                    if (compareDates(addOneDayToDate(activeUniqueImeisLastRunDate), cdrProcessingTimestamp) > 0) {
                        activeUniqueImeisLastRunEndDate = addOneDayToDate(activeUniqueImeisLastRunDate);
                    } else {
                        activeUniqueImeisLastRunEndDate = cdrProcessingTimestamp;
                    }
                    newLastRunTimeIsUpdate = false;

//                    systemConfigurationDbRepository.save(new SystemConfigurationDb(profile+"_nw_unique_imei_last_run_time", activeUniqueImeisLastRunEndDate, "latest date when national whitelist process for unique imei ran", "National Whitelist"));
                }
            }
            List<RuleEngineMapping> rules = ruleEngineMappingRepository.getByFeatureAndUserTypeOrderByRuleOrder("national_whitelist", "default", "Enabled");

            List<String> ruleNames = rules.stream()
                    .map(RuleEngineMapping::getName)
                    .collect(Collectors.toList());
            if(!ruleNames.contains(Rules.CUSTOM_CHK.getRuleName()) && !amnestyPeriodFlag) {
                skip = true;
            }
            if(!skip) {
                if (!activeUniqueImeisLastRunEndDate.isEmpty()) {
                    int compareDatesActiveUniqueImei = compareDates(activeUniqueImeisLastRunDate, cdrProcessingTimestamp);
                    if (compareDatesActiveUniqueImei > 0) {
                        Pageable pageable = PageRequest.of(0, batchSize);
                        while (true) {
                            List<ActiveUniqueImeiDto> dtos = new ArrayList<>();
                            int totalPages = 0;
                            if ("app".equals(profile)) {
                                Page<ActiveUniqueImei> activeUniqueImeis = activeUniqueImeiRepository.findAllLatestUniqueImeiInLastXDays(convertStringToDateTime(activeUniqueImeisLastRunDate), convertStringToDateTime(activeUniqueImeisLastRunEndDate), pageable);
                                if (activeUniqueImeis.isEmpty()) {
                                    break;
                                }
                                dtos = activeUniqueImeis.getContent().stream()
                                        .map(ActiveUniqueImeiDto::fromEntityForApp)
                                        .collect(Collectors.toList());
                                totalPages = activeUniqueImeis.getTotalPages();
                            } else if ("app_edr".equals(profile)) {
                                Page<ActiveUniqueEdr> activeUniqueImeis = null;
                                if (usage) {
                                    activeUniqueImeis = commonService.findAllLatestUniqueImeiInLastXDaysWithDeviceInfo(convertStringToDateTime(activeUniqueImeisLastRunDate), convertStringToDateTime(activeUniqueImeisLastRunEndDate), pageable);
                                } else {
                                    activeUniqueImeis = activeUniqueImeiEdrRepository.findAllLatestUniqueImeiInLastXDays(convertStringToDateTime(activeUniqueImeisLastRunDate), convertStringToDateTime(activeUniqueImeisLastRunEndDate), pageable);
                                }
                                if (activeUniqueImeis.isEmpty()) {
                                    break;
                                }
                                dtos = activeUniqueImeis.getContent().stream()
                                        .map(ActiveUniqueImeiDto::fromEntityForAppEdr)
                                        .collect(Collectors.toList());
                                totalPages = activeUniqueImeis.getTotalPages();
                            } else {
                                throw new Exception("Unsupported spring profile: "+profile);
                            }
                            RuleEngineDto<ActiveUniqueImeiDto, ExceptionList> activeUniqueImeiDto = new RuleEngineDto(dtos, new ArrayList<>());
                            if (!rules.isEmpty()) {
                                if (!dtos.isEmpty()) {
                                    log.info("Starting validation for " + dtos.size() + " active unique imei between startDate: {}, endDate: {}, pageNo: {}, totalPages: {}", activeUniqueImeisLastRunDate, activeUniqueImeisLastRunEndDate, pageable.getPageNumber(), totalPages);
                                    for (RuleEngineMapping rule : rules) {
                                        switch (Rules.valueOf(rule.getName().trim())) {
                                            case TYPE_APPROVED:
                                                ModulesAuditTrail typeApprovedAudit = ModulesAuditTrailBuilder.forUpdate(moduleAudiTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking trc data", MODULE_NAME+"national_whitelist", executionStartTime, startTime);
                                                modulesAuditTrailRepository.save(typeApprovedAudit);
                                                activeUniqueImeiDto = typeApproved.validateActiveUniqueImei(activeUniqueImeiDto);
                                                break;
                                            case CUSTOM_CHK:
                                                ModulesAuditTrail customCheckAudit = ModulesAuditTrailBuilder.forUpdate(moduleAudiTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking customs data", MODULE_NAME+"national_whitelist", executionStartTime, startTime);
                                                modulesAuditTrailRepository.save(customCheckAudit);
                                                activeUniqueImeiDto = customChk.validateActiveUniqueImei(activeUniqueImeiDto);
                                                break;
                                            case EXISTS_IN_LOCAL_MANUFACTURER_DB:
                                                ModulesAuditTrail manufacturersAudit = ModulesAuditTrailBuilder.forUpdate(moduleAudiTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking manufacturers data", MODULE_NAME+"national_whitelist", executionStartTime, startTime);
                                                modulesAuditTrailRepository.save(manufacturersAudit);
                                                activeUniqueImeiDto = existsInLocalManufacturerDb.validateActiveUniqueImei(activeUniqueImeiDto);
                                                break;
                                            case VALID_TAC:
                                                ModulesAuditTrail tacAudit = ModulesAuditTrailBuilder.forUpdate(moduleAudiTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking invalid tac for unique imei", MODULE_NAME+"national_whitelist", executionStartTime, startTime);
                                                modulesAuditTrailRepository.save(tacAudit);
                                                activeUniqueImeiDto = validTac.validateActiveUniqueImei(activeUniqueImeiDto);
                                                break;
                                            case IMEI_NULL:
                                                ModulesAuditTrail imeiAudit = ModulesAuditTrailBuilder.forUpdate(moduleAudiTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking if imei is null for unique imei", MODULE_NAME+"national_whitelist", executionStartTime, startTime);
                                                modulesAuditTrailRepository.save(imeiAudit);
                                                activeUniqueImeiDto = imeiNull.validateActiveUniqueImei(activeUniqueImeiDto);
                                                break;
                                            case IMEI_TEST:
                                                ModulesAuditTrail testAudit = ModulesAuditTrailBuilder.forUpdate(moduleAudiTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking if test imei for unique imei", MODULE_NAME+"national_whitelist", executionStartTime, startTime);
                                                modulesAuditTrailRepository.save(testAudit);
                                                activeUniqueImeiDto = imeiTest.validateActiveUniqueImei(activeUniqueImeiDto);
                                                break;
                                            case IMEI_ALPHANUMERIC:
                                                ModulesAuditTrail alphanumericAudit = ModulesAuditTrailBuilder.forUpdate(moduleAudiTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking if imei alphanumeric for unique imei", MODULE_NAME+"national_whitelist", executionStartTime, startTime);
                                                modulesAuditTrailRepository.save(alphanumericAudit);
                                                activeUniqueImeiDto = imeiAlphanumeric.validateActiveUniqueImei(activeUniqueImeiDto);
                                                break;
                                            case IMEI_LENGTH_NATIONAL_WHITELIST:
                                                ModulesAuditTrail lengthAudit = ModulesAuditTrailBuilder.forUpdate(moduleAudiTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking imei length for unique imei", MODULE_NAME+"national_whitelist", executionStartTime, startTime);
                                                modulesAuditTrailRepository.save(lengthAudit);
                                                activeUniqueImeiDto = imeiLength.validateActiveUniqueImei(activeUniqueImeiDto);
                                                break;
                                        }
                                    }
                                    lastProgressTime = System.currentTimeMillis();
                                    log.info("ActiveUniqueImeis: Count National Whitelist=> "+activeUniqueImeiDto.getNationalWhitelistAccepted().size()+ ", Exception List=> "+activeUniqueImeiDto.getExceptionList().size());
                                    if (!activeUniqueImeiDto.getNationalWhitelistAccepted().isEmpty()) {
                                        List<NationalWhitelist> nationalWhitelists = NationalWhitelistBuilder.fromActiveUniqueImei(activeUniqueImeiDto.getNationalWhitelistAccepted(), ruleNames, amnestyPeriodFlag);
                                        nwlCount = nationalWhitelistService.saveNationalWhitelists(nationalWhitelists, amnestyPeriodFlag, allowedDeviceTypes);
                                    }
//                            lastProgressTime = System.currentTimeMillis();
//                            if (!activeUniqueImeiDto.getExceptionList().isEmpty()) {
//                                exceptionListService.saveExceptionLists(activeUniqueImeiDto.getExceptionList());
//                                exceptionListCount = exceptionListCount + activeUniqueImeiDto.getExceptionList().size();
//                            }
                                    lastProgressTime = System.currentTimeMillis();
                                } else {
                                    log.info("No active unique imei found for " + activeUniqueImeisLastRunDate);
                                    break;
                                }
                                pageable = pageable.next();
                            } else {
                                throw new Exception("No rules enabled for national whitelist");
                            }
                        }
                        if (newLastRunTimeIsUpdate) {
                            SystemConfigurationDb activeUniqueImeiLatestDate = activeUniqueImeiDate.get();
                            activeUniqueImeiLatestDate.setValue(activeUniqueImeisLastRunEndDate);
                            systemConfigurationDbRepository.save(activeUniqueImeiLatestDate);
                        } else {
                            systemConfigurationDbRepository.save(new SystemConfigurationDb(profile+"_nw_unique_imei_last_run_time", activeUniqueImeisLastRunEndDate, "latest date when national whitelist process for unique imei ran", "National Whitelist"));
                        }
                    }
                }
                ModulesAuditTrail completedAudit = ModulesAuditTrailBuilder.forUpdate(moduleAudiTrailId, 200, "completed", "NA", "National Whitelist", "UPDATE", "Process completed for National Whitelist", MODULE_NAME+"national_whitelist", nwlCount, executionStartTime, startTime);
                modulesAuditTrailRepository.save(completedAudit);
            } else {
                /*log.error("checking alert config for alert017");
                System.out.println("checking alert config for alert017");
                Optional<CfgFeatureAlert> alert = cfgFeatureAlertRepository.findByAlertId("alert017");
                if (alert.isPresent()) {
                    log.error("raising alert017");
                    System.out.println("raising alert017");
                    raiseAnAlert(alert.get().getAlertId(), alert.get().getDescription(), MODULE_NAME+"national_whitelist", 0);
//                RunningAlertDb alertDb = new RunningAlertDb(alert.get().getAlertId(), alert.get().getDescription().replace("<ERROR>", msg), 0);
//                runningAlertDbRepo.save(alertDb);
                }*/
                this.log.error("raising alert017");
                System.out.println("raising alert017");
                this.alertService.raiseAlert("alert017", "", Integer.valueOf(0));
                ModulesAuditTrail completedAudit = ModulesAuditTrailBuilder.forUpdate(moduleAudiTrailId, 501, "failed", "raised alert017", "National Whitelist", "UPDATE", "Exception during national whitelist process", MODULE_NAME+"national_whitelist", executionStartTime, startTime);
                modulesAuditTrailRepository.save(completedAudit);
            }

            // For foreign tables
            ModulesAuditTrail foreignModuleTrail = ModulesAuditTrailBuilder.forInsert(201, "created", "NA", "National Whitelist", "INSERT", 0,"Started Foreign Whitelist Process", MODULE_NAME+"foreign_whitelist", startTime, executionStartTime);
            foreignModuleTrail = modulesAuditTrailRepository.save(foreignModuleTrail);
            foreignModuleTrailId = foreignModuleTrail.getId();

            Optional<SystemConfigurationDb> acitveUniqueForeignImeiDate =Optional.ofNullable(systemConfigurationDbRepository.getByTag(profile+"_nw_unique_foreign_imei_last_run_time"));
            String activeUniqueForeignImeisLastRunDate = "";
            String activeUniqueForeignImeisLastRunEndDate = "";
            boolean newForeignLastRunTimeIsUpdate = false;

            if(acitveUniqueForeignImeiDate.isPresent()) {
                activeUniqueForeignImeisLastRunDate = formatDateString(acitveUniqueForeignImeiDate.get().getValue());
                int compareDates = compareDates(activeUniqueForeignImeisLastRunDate, cdrProcessingTimestamp);
                if (compareDates > 0) {
                    if (compareDates(addOneDayToDate(activeUniqueForeignImeisLastRunDate), cdrProcessingTimestamp) > 0) {
                        newForeignLastRunTimeIsUpdate = true;
                        activeUniqueForeignImeisLastRunEndDate = addOneDayToDate(activeUniqueForeignImeisLastRunDate);

                    } else {
                        newForeignLastRunTimeIsUpdate = true;
                        activeUniqueForeignImeisLastRunEndDate = cdrProcessingTimestamp;
                    }
                }
            } else {
                String inputDateString = "";
                if ("app".equals(profile)) {
                    inputDateString = activeUniqueForeignImeiRepository.getEarliestActiveTimestamp();
                } else if ("app_edr".equals(profile)) {
                    inputDateString = activeUniqueForeignImeiEdrRepository.getEarliestActiveTimestamp();
                }
                activeUniqueForeignImeisLastRunDate = formatDateString(inputDateString);
                if (compareDates(addOneDayToDate(activeUniqueForeignImeisLastRunDate), cdrProcessingTimestamp) > 0) {
                    activeUniqueForeignImeisLastRunEndDate = addOneDayToDate(activeUniqueForeignImeisLastRunDate);
                } else {
                    activeUniqueForeignImeisLastRunEndDate = cdrProcessingTimestamp;
                }
                newForeignLastRunTimeIsUpdate = false;
//                systemConfigurationDbRepository.save(new SystemConfigurationDb(profile+"_nw_unique_foreign_imei_last_run_time", activeUniqueForeignImeisLastRunEndDate, "latest date when foreign whitelist process for unique imei ran", "National Whitelist"));
            }
            List<RuleEngineMapping> foreignRules = ruleEngineMappingRepository.
                    getByFeatureAndUserTypeOrderByRuleOrder("foreign_whitelist", "default", "Enabled");
            List<String> foreignRuleNames = foreignRules.stream()
                    .map(RuleEngineMapping::getName)
                    .collect(Collectors.toList());
            if (!activeUniqueForeignImeisLastRunDate.isEmpty()) {
                int compareDatesActiveUniqueForeignImeis = compareDates(activeUniqueForeignImeisLastRunDate, cdrProcessingTimestamp);
                if (compareDatesActiveUniqueForeignImeis > 0) {
                    Pageable pageable = PageRequest.of(0, batchSize);
                    while (true) {
                        List<ActiveUniqueForeignImeiDto> foreignDtos = new ArrayList<>();
                        int totalPages = 0;
                        if ("app".equals(profile)) {
                            Page<ActiveUniqueForeignImei> activeUniqueForeignImeis = activeUniqueForeignImeiRepository.findAllLatestUniqueImeiInLastXDays(convertStringToDateTime(activeUniqueForeignImeisLastRunDate), convertStringToDateTime(activeUniqueForeignImeisLastRunEndDate), pageable);
                            if (activeUniqueForeignImeis.isEmpty()) {
                                break;
                            }
                            foreignDtos = activeUniqueForeignImeis.getContent().stream()
                                    .map(ActiveUniqueForeignImeiDto::fromEntityForApp)
                                    .collect(Collectors.toList());
                            totalPages = activeUniqueForeignImeis.getTotalPages();
                        } else if ("app_edr".equals(profile)) {
                            Page<ActiveUniqueForeignImeiEdr> activeUniqueForeignImeis = null;
                            if (usage) {
                                activeUniqueForeignImeis = commonService.findAllLatestForeignImeiInLastXDaysWithDeviceInfo(convertStringToDateTime(activeUniqueForeignImeisLastRunDate), convertStringToDateTime(activeUniqueForeignImeisLastRunEndDate), pageable);
                            } else {
                                activeUniqueForeignImeis = activeUniqueForeignImeiEdrRepository.findAllLatestUniqueImeiInLastXDays(convertStringToDateTime(activeUniqueForeignImeisLastRunDate), convertStringToDateTime(activeUniqueForeignImeisLastRunEndDate), pageable);
                            }
                            if (activeUniqueForeignImeis.isEmpty()) {
                                break;
                            }
                            foreignDtos = activeUniqueForeignImeis.getContent().stream()
                                    .map(ActiveUniqueForeignImeiDto::fromEntityForAppEdr)
                                    .collect(Collectors.toList());
                            totalPages = activeUniqueForeignImeis.getTotalPages();
                        } else {
                            throw new Exception("Unsupported spring profile: " + profile);
                        }
                        RuleEngineDto<ActiveUniqueForeignImeiDto, ForeignExceptionList> activeUniqueForeignImeiDto = new RuleEngineDto(foreignDtos, new ArrayList<>());
                        if (!foreignRules.isEmpty()) {
                            if (!foreignDtos.isEmpty()) {
                                log.info("Starting validation for " + foreignDtos.size() + " active unique foreign imei between startDate: {}, endDate: {}, pageNo: {}, totalPages: {}", activeUniqueForeignImeisLastRunDate, activeUniqueForeignImeisLastRunEndDate, pageable.getPageNumber(), totalPages);
                                for (RuleEngineMapping rule : foreignRules) {
                                    switch (Rules.valueOf(rule.getName().trim())) {
                                        case VALID_TAC:
                                            ModulesAuditTrail foreignTacAudit = ModulesAuditTrailBuilder.forUpdate(foreignModuleTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking invalid tac for foreign unique imei", MODULE_NAME+"foreign_whitelist", executionStartTime, startTime);
                                            modulesAuditTrailRepository.save(foreignTacAudit);
                                            activeUniqueForeignImeiDto = validTac.validateActiveUniqueForeignImei(activeUniqueForeignImeiDto);
                                            break;
                                        case IMEI_NULL:
                                            ModulesAuditTrail foreignNullAudit = ModulesAuditTrailBuilder.forUpdate(foreignModuleTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking if imei is null for foreign unique imei", MODULE_NAME+"foreign_whitelist", executionStartTime, startTime);
                                            modulesAuditTrailRepository.save(foreignNullAudit);
                                            activeUniqueForeignImeiDto = imeiNull.validateActiveUniqueForeignImei(activeUniqueForeignImeiDto);
                                            break;
                                        case IMEI_TEST:
                                            ModulesAuditTrail foreignTestAudit = ModulesAuditTrailBuilder.forUpdate(foreignModuleTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking if test imei for foreign unique imei", MODULE_NAME+"foreign_whitelist", executionStartTime, startTime);
                                            modulesAuditTrailRepository.save(foreignTestAudit);
                                            activeUniqueForeignImeiDto = imeiTest.validateActiveUniqueForeignImei(activeUniqueForeignImeiDto);
                                            break;
                                        case IMEI_LENGTH_NATIONAL_WHITELIST:
                                            ModulesAuditTrail foreignLengthAudit = ModulesAuditTrailBuilder.forUpdate(foreignModuleTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking imei length for foreign unique imei", MODULE_NAME+"foreign_whitelist", executionStartTime, startTime);
                                            modulesAuditTrailRepository.save(foreignLengthAudit);
                                            activeUniqueForeignImeiDto = imeiLength.validateActiveUniqueForeignImei(activeUniqueForeignImeiDto);
                                            break;
                                        case IMEI_ALPHANUMERIC:
                                            ModulesAuditTrail foreignAlphanumericAudit = ModulesAuditTrailBuilder.forUpdate(foreignModuleTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking if imei alphanumeric for foreign unique imei", MODULE_NAME+"foreign_whitelist", executionStartTime, startTime);
                                            modulesAuditTrailRepository.save(foreignAlphanumericAudit);
                                            activeUniqueForeignImeiDto = imeiAlphanumeric.validateActiveUniqueForeignImei(activeUniqueForeignImeiDto);
                                            break;
                                    }
                                }
                                lastProgressTime = System.currentTimeMillis();
                                log.info("ActiveUniqueForeignImeis: Count National Whitelist=> " + activeUniqueForeignImeiDto.getNationalWhitelistAccepted().size() + ", Exception List=> " + activeUniqueForeignImeiDto.getExceptionList().size());
                                if (!activeUniqueForeignImeiDto.getNationalWhitelistAccepted().isEmpty()) {
                                    List<ForeignWhitelist> nationalWhitelists = ForeignWhitelistBuilder.fromActiveUniqueImei(activeUniqueForeignImeiDto.getNationalWhitelistAccepted(), foreignRuleNames);
                                    foreignWhitelistCount = foreignWhitelistService.saveNationalWhitelists(nationalWhitelists, amnestyPeriodFlag);
                                }
                                lastProgressTime = System.currentTimeMillis();
                                if (!activeUniqueForeignImeiDto.getExceptionList().isEmpty()) {
                                    foreignExceptionListCount = foreignExceptionListService.saveExceptionLists(activeUniqueForeignImeiDto.getExceptionList());
                                }
                                lastProgressTime = System.currentTimeMillis();
                                lastProgressTime = System.currentTimeMillis();
                            } else {
                                log.info("No active unique foreign imei found for " + activeUniqueForeignImeisLastRunDate);
                                break;
                            }
                            pageable = pageable.next();
                        } else {
                            throw new Exception("No rules enabled for foreign whitelist");
                        }
                    }
                    if (newForeignLastRunTimeIsUpdate) {
                        SystemConfigurationDb activeUniqueForeignImeiLatestDate = acitveUniqueForeignImeiDate.get();
                        activeUniqueForeignImeiLatestDate.setValue(activeUniqueForeignImeisLastRunEndDate);
                        systemConfigurationDbRepository.save(activeUniqueForeignImeiLatestDate);
                    } else {
                        systemConfigurationDbRepository.save(new SystemConfigurationDb(profile+"_nw_unique_foreign_imei_last_run_time", activeUniqueForeignImeisLastRunEndDate, "latest date when national whitelist process for unique imei ran", "National Whitelist"));
                    }
                }
            }
            //
            Optional<SystemConfigurationDb> activeForeignImeisDifferentMsisdnDate = Optional.ofNullable(systemConfigurationDbRepository.getByTag(profile+"_nw_foreign_unique_imei_diff_msisdn_last_run_time"));
            String activeForeignImeisDifferentMsisdnLastRunDate = "";
            String activeForeignImeisDifferentMsisdnLastRunEndDate = "";
            boolean newForeignDifferentMsisdnLastRunTimeIsUpdate = false;

            if (activeForeignImeisDifferentMsisdnDate.isPresent()) {
                activeForeignImeisDifferentMsisdnLastRunDate = formatDateString(activeForeignImeisDifferentMsisdnDate.get().getValue());
                int compareDates = compareDates(activeForeignImeisDifferentMsisdnLastRunDate, cdrProcessingTimestamp);
                if (compareDates > 0) {
                    if (compareDates(addOneDayToDate(activeForeignImeisDifferentMsisdnLastRunDate), cdrProcessingTimestamp) > 0) {
                        newForeignDifferentMsisdnLastRunTimeIsUpdate = true;
                        activeForeignImeisDifferentMsisdnLastRunEndDate = addOneDayToDate(activeForeignImeisDifferentMsisdnLastRunDate);
                    } else {
                        newForeignDifferentMsisdnLastRunTimeIsUpdate = true;
                        activeForeignImeisDifferentMsisdnLastRunEndDate = cdrProcessingTimestamp;
                    }
                }
            } else {
                String inputDateString = "";
                if ("app".equals(profile)) {
                    inputDateString = activeForeignImeiWithDifferentMsisdnRepository.getEarliestActiveTimestamp();
                } else if ("app_edr".equals(profile)) {
                    inputDateString = activeForeignImeiWithDifferentMsisdnEdrRepository.getEarliestActiveTimestamp();
                }
                activeForeignImeisDifferentMsisdnLastRunDate = formatDateString(inputDateString);
                if (compareDates(addOneDayToDate(activeForeignImeisDifferentMsisdnLastRunDate), cdrProcessingTimestamp) > 0) {
                    activeForeignImeisDifferentMsisdnLastRunEndDate = addOneDayToDate(activeForeignImeisDifferentMsisdnLastRunDate);
                } else {
                    activeForeignImeisDifferentMsisdnLastRunEndDate = cdrProcessingTimestamp;
                }
                newForeignDifferentMsisdnLastRunTimeIsUpdate = false;
//                systemConfigurationDbRepository.save(new SystemConfigurationDb(profile+"_nw_foreign_unique_imei_diff_msisdn_last_run_time", activeForeignImeisDifferentMsisdnLastRunEndDate, "latest date when foreign whitelist process for imei with different msisdn ran", "National Whitelist"));
            }
            int compareDatesActiveForeignImeisDifferentMsisdn = compareDates(activeForeignImeisDifferentMsisdnLastRunDate, cdrProcessingTimestamp);
            if (compareDatesActiveForeignImeisDifferentMsisdn > 0) {
                Pageable pageable = PageRequest.of(0, batchSize);
                while (true) {
                    List<ActiveForeignImeiWithDifferentImsiDto> foreignDtos = new ArrayList<>();
                    int totalPages = 0;
                    if ("app".equals(profile)) {
                        Page<ActiveForeignImeiWithDifferentMsisdn> activeForeignImeiWithDifferentMsisdns = activeForeignImeiWithDifferentMsisdnRepository.findAllLatestDifferentImeiInLastXDays(convertStringToDateTime(activeForeignImeisDifferentMsisdnLastRunDate), convertStringToDateTime(activeForeignImeisDifferentMsisdnLastRunEndDate), pageable);
                        if (activeForeignImeiWithDifferentMsisdns.isEmpty()) {
                            break;
                        }
                        foreignDtos = activeForeignImeiWithDifferentMsisdns.getContent().stream()
                                .map(ActiveForeignImeiWithDifferentImsiDto::fromEntityForCdr)
                                .collect(Collectors.toList());
                        totalPages = activeForeignImeiWithDifferentMsisdns.getTotalPages();
                    } else if ("app_edr".equals(profile)) {
                        Page<ActiveForeignImeiWithDifferentImsi> activeForeignImeiWithDifferentMsisdns = null;
                        if (usage) {
                            activeForeignImeiWithDifferentMsisdns = commonService.findAllLatestDifferentImeiInLastXDaysWithDeviceInfo(convertStringToDateTime(activeForeignImeisDifferentMsisdnLastRunDate), convertStringToDateTime(activeForeignImeisDifferentMsisdnLastRunEndDate), pageable);
                        } else {
                            activeForeignImeiWithDifferentMsisdns = activeForeignImeiWithDifferentMsisdnEdrRepository.findAllLatestDifferentImeiInLastXDays(convertStringToDateTime(activeForeignImeisDifferentMsisdnLastRunDate), convertStringToDateTime(activeForeignImeisDifferentMsisdnLastRunEndDate), pageable);
                        }
                        if (activeForeignImeiWithDifferentMsisdns.isEmpty()) {
                            break;
                        }
                        foreignDtos = activeForeignImeiWithDifferentMsisdns.getContent().stream()
                                .map(ActiveForeignImeiWithDifferentImsiDto::fromEntityForEdr)
                                .collect(Collectors.toList());
                        totalPages = activeForeignImeiWithDifferentMsisdns.getTotalPages();
                    } else {
                        throw new Exception("Unsupported spring profile: " + profile);
                    }

                    RuleEngineDto<ActiveForeignImeiWithDifferentImsiDto, ForeignExceptionList> activeForeignUniqueImeiWithDifferentMsisdnDto = new RuleEngineDto(foreignDtos, new ArrayList<>());
                    if (!foreignRules.isEmpty()) {
                        if (!foreignDtos.isEmpty()) {
                            log.info("Starting validation for " + foreignDtos.size() + " active foreign imei with different msisdn between startDate: {}, endDate: {}, pageNo: {}, totalPages", activeForeignImeisDifferentMsisdnLastRunDate, activeForeignImeisDifferentMsisdnLastRunEndDate, pageable.getPageNumber(), totalPages);
                            for (RuleEngineMapping rule : foreignRules) {
                                switch (Rules.valueOf(rule.getName().trim())) {
                                    case VALID_TAC:
                                        ModulesAuditTrail diffMsisdnForeignTacAudit = ModulesAuditTrailBuilder.forUpdate(foreignModuleTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking invalid tac for foreign imei with different msisdn", MODULE_NAME+"foreign_whitelist", executionStartTime, startTime);
                                        modulesAuditTrailRepository.save(diffMsisdnForeignTacAudit);
                                        activeForeignUniqueImeiWithDifferentMsisdnDto = validTac.validateActiveForeignImeiWithDifferentMsisdn(activeForeignUniqueImeiWithDifferentMsisdnDto);
                                        break;
                                    case IMEI_NULL:
                                        ModulesAuditTrail diffMsisdnForeignNullAudit = ModulesAuditTrailBuilder.forUpdate(foreignModuleTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking if imei is null for foreign imei with different msisdn", MODULE_NAME+"foreign_whitelist", executionStartTime, startTime);
                                        modulesAuditTrailRepository.save(diffMsisdnForeignNullAudit);
                                        activeForeignUniqueImeiWithDifferentMsisdnDto = imeiNull.validateActiveForeignImeiWithDifferentMsisdn(activeForeignUniqueImeiWithDifferentMsisdnDto);
                                        break;
                                    case IMEI_TEST:
                                        ModulesAuditTrail diffMsisdnForeignTestAudit = ModulesAuditTrailBuilder.forUpdate(foreignModuleTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking if test imei for foreign imei with different msisdn", MODULE_NAME+"foreign_whitelist", executionStartTime, startTime);
                                        modulesAuditTrailRepository.save(diffMsisdnForeignTestAudit);
                                        activeForeignUniqueImeiWithDifferentMsisdnDto = imeiTest.validateActiveForeignImeiWithDifferentMsisdn(activeForeignUniqueImeiWithDifferentMsisdnDto);
                                        break;
                                    case IMEI_LENGTH_NATIONAL_WHITELIST:
                                        ModulesAuditTrail diffMsisdnForeignLengthAudit = ModulesAuditTrailBuilder.forUpdate(foreignModuleTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking imei length for foreign imei with different msisdn", MODULE_NAME+"foreign_whitelist", executionStartTime, startTime);
                                        modulesAuditTrailRepository.save(diffMsisdnForeignLengthAudit);
                                        activeForeignUniqueImeiWithDifferentMsisdnDto = imeiLength.validateActiveForeignImeiWithDifferentMsisdn(activeForeignUniqueImeiWithDifferentMsisdnDto);
                                        break;
                                    case IMEI_ALPHANUMERIC:
                                        ModulesAuditTrail diffMsisdnForeignAlphanumericAudit = ModulesAuditTrailBuilder.forUpdate(foreignModuleTrailId, 201, "rule-" + rule.getRuleOrder(), "NA", "National Whitelist", "UPDATE", "Checking if imei alphanumeric for foreign imei with different msisdn", MODULE_NAME+"foreign_whitelist", executionStartTime, startTime);
                                        modulesAuditTrailRepository.save(diffMsisdnForeignAlphanumericAudit);
                                        activeForeignUniqueImeiWithDifferentMsisdnDto = imeiAlphanumeric.validateActiveForeignImeiWithDifferentMsisdn(activeForeignUniqueImeiWithDifferentMsisdnDto);
                                        break;
                                }
                            }
                            lastProgressTime = System.currentTimeMillis();
                            log.info("ActiveForeignImeiWithDifferentMsisdns: Count National Whitelist=> "+activeForeignUniqueImeiWithDifferentMsisdnDto.getNationalWhitelistAccepted().size()+ ", Exception List=> "+activeForeignUniqueImeiWithDifferentMsisdnDto.getExceptionList().size());
                            if (!activeForeignUniqueImeiWithDifferentMsisdnDto.getExceptionList().isEmpty()) {
                                int count = foreignExceptionListService.saveExceptionLists(activeForeignUniqueImeiWithDifferentMsisdnDto.getExceptionList());
                                foreignExceptionListCount = foreignExceptionListCount + count;
                            }
                            lastProgressTime = System.currentTimeMillis();
                        } else {
                            log.info("No active foreign imei with different msisdn found for " + activeForeignImeisDifferentMsisdnLastRunDate);
                            break;
                        }
                        pageable = pageable.next();
                    } else {
                        throw new Exception("No rules enabled for foreign whitelist");
                    }
                }
                if (newForeignDifferentMsisdnLastRunTimeIsUpdate) {
                    SystemConfigurationDb activeUniqueForeignImeiLatestDate = activeForeignImeisDifferentMsisdnDate.get();
                    activeUniqueForeignImeiLatestDate.setValue(activeForeignImeisDifferentMsisdnLastRunEndDate);
                    systemConfigurationDbRepository.save(activeUniqueForeignImeiLatestDate);
                } else {
                    systemConfigurationDbRepository.save(new SystemConfigurationDb(profile+"_nw_foreign_unique_imei_diff_msisdn_last_run_time", activeUniqueForeignImeisLastRunEndDate, "latest date when national whitelist process for unique imei ran", "National Whitelist"));
                }
            }
            ModulesAuditTrail diffMsisdnForeignCompletedAudit = ModulesAuditTrailBuilder.forUpdate(foreignModuleTrailId, 200, "completed", "NA", "National Whitelist", "UPDATE", "Process completed for foreign whitelist", MODULE_NAME+"foreign_whitelist", foreignWhitelistCount, executionStartTime, startTime);
            modulesAuditTrailRepository.save(diffMsisdnForeignCompletedAudit);
            ModulesAuditTrail foreignExceptionModuleTrail = ModulesAuditTrailBuilder.forInsert(200, "completed", "NA", "National Whitelist", "INSERT", foreignExceptionListCount,"Process completed for foreign exception list", MODULE_NAME+"foreign_whitelist", startTime, executionStartTime);
            modulesAuditTrailRepository.save(foreignExceptionModuleTrail);
        } catch (DataAccessException e) {
            log.error("DB Exception: Raising alert016 "+e);
            String msg = e.getMessage().length() <= 200?e.getMessage(): e.getMessage().substring(0, 200);
            e.printStackTrace();
            /*Optional<CfgFeatureAlert> alert = cfgFeatureAlertRepository.findByAlertId("alert016");
            log.error("raising alert016");
            System.out.println("raising alert016");
            if (alert.isPresent()) {
                raiseAnAlert(alert.get().getAlertId(), msg, MODULE_NAME+"national_whitelist", 0);
//                RunningAlertDb alertDb = new RunningAlertDb(alert.get().getAlertId(), alert.get().getDescription().replace("<ERROR>", msg), 0);
//                runningAlertDbRepo.save(alertDb);
            }*/
            this.log.error("raising alert016");
            System.out.println("raising alert016");
            this.alertService.raiseAlert("alert016", msg, Integer.valueOf(0));
            if (moduleAudiTrailId == 0) {
                ModulesAuditTrail audit = ModulesAuditTrailBuilder.forInsert(501, "failed", msg, "National Whitelist", "INSERT", 0,"Exception during national whitelist process", MODULE_NAME+"national_whitelist", startTime, executionStartTime);
                modulesAuditTrailRepository.save(audit);
            } else {
                ModulesAuditTrail audit = ModulesAuditTrailBuilder.forUpdate(moduleAudiTrailId, 501, "failed", msg, "National Whitelist", "UPDATE", "Exception during national whitelist process", MODULE_NAME+"national_whitelist", executionStartTime, startTime);
                modulesAuditTrailRepository.save(audit);
            }
            if (foreignModuleTrailId == 0) {
                ModulesAuditTrail audit = ModulesAuditTrailBuilder.forInsert(501, "failed", msg, "National Whitelist", "INSERT", 0,"Exception during exception whitelist process", MODULE_NAME+"foreign_whitelist", startTime, executionStartTime);
                modulesAuditTrailRepository.save(audit);
            } else {
                ModulesAuditTrail audit = ModulesAuditTrailBuilder.forUpdate(foreignModuleTrailId, 501, "failed", msg, "National Whitelist", "UPDATE", "Exception during exception whitelist process", MODULE_NAME+"foreign_whitelist", executionStartTime, startTime);
                modulesAuditTrailRepository.save(audit);
            }
        } catch (Exception ex) {
            log.error("Exception: Raising alert1209 "+ ex);
            String msg = ex.getMessage().length() <= 200?ex.getMessage(): ex.getMessage().substring(0, 200);
            ex.printStackTrace();
            if (moduleAudiTrailId == 0) {
                ModulesAuditTrail audit = ModulesAuditTrailBuilder.forInsert(501, "failed", msg, "National Whitelist", "INSERT", 0,"Exception during national whitelist process", MODULE_NAME+"national_whitelist", startTime, executionStartTime);
                modulesAuditTrailRepository.save(audit);
            } else {
                ModulesAuditTrail audit = ModulesAuditTrailBuilder.forUpdate(moduleAudiTrailId, 501, "failed", msg, "National Whitelist", "UPDATE", "Exception during national whitelist process", MODULE_NAME+"national_whitelist", executionStartTime, startTime);
                modulesAuditTrailRepository.save(audit);
            }
            if (foreignModuleTrailId == 0) {
                ModulesAuditTrail audit = ModulesAuditTrailBuilder.forInsert(501, "failed", msg, "National Whitelist", "INSERT", 0,"Exception during exception whitelist process", MODULE_NAME+"foreign_whitelist", startTime, executionStartTime);
                modulesAuditTrailRepository.save(audit);
            } else {
                ModulesAuditTrail audit = ModulesAuditTrailBuilder.forUpdate(foreignModuleTrailId, 501, "failed", msg, "National Whitelist", "UPDATE", "Exception during exception whitelist process", MODULE_NAME+"foreign_whitelist", executionStartTime, startTime);
                modulesAuditTrailRepository.save(audit);
            }
            /*Optional<CfgFeatureAlert> alert = cfgFeatureAlertRepository.findByAlertId("alert1209");
            log.error("raising alert1209");
            System.out.println("raising alert1209");*/
            this.log.error("raising alert1209");
            System.out.println("raising alert1209");
            this.alertService.raiseAlert("alert1209", msg, Integer.valueOf(0));
        } finally {
            log.info("Process Completed");
            System.out.println("Process Completed");
        }
    }

//    private RuleEngineDto<ActiveUniqueImei, ExceptionList> checkRulesForGdceTrc(RuleEngineDto<ActiveUniqueImei, ExceptionList> activeUniqueImeiDto) {
//
//    }

    public String getDateTimeNow() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentDateTime.format(formatter);
    }

    public int compareDates(String timestamp1, String timestamp2) {
        DateTimeFormatter formatterWithoutMilliseconds = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime dateTime1 = LocalDateTime.parse(timestamp1, formatterWithoutMilliseconds);
        LocalDateTime dateTime2 = LocalDateTime.parse(timestamp2, formatterWithoutMilliseconds);

        OffsetDateTime offsetDateTime1 = dateTime1.atOffset(ZoneOffset.UTC);
        OffsetDateTime offsetDateTime2 = dateTime2.atOffset(ZoneOffset.UTC);

        return offsetDateTime2.compareTo(offsetDateTime1);
    }

    public static String addOneDayToDate(String timestamp) {
        DateTimeFormatter formatterWithoutMilliseconds = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime dateTime = LocalDateTime.parse(timestamp, formatterWithoutMilliseconds);
        LocalDateTime modifiedDateTime = dateTime.plusDays(1);

//        OffsetDateTime offsetModifiedDateTime = modifiedDateTime.atOffset(ZoneOffset.UTC);

        return modifiedDateTime.format(formatterWithoutMilliseconds);
    }

    public static String formatDateString(String inputDateString) {
        DateTimeFormatter formatterWithMilliseconds = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        DateTimeFormatter formatterWithoutMilliseconds = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            LocalDateTime localDateTime = LocalDateTime.parse(inputDateString, formatterWithMilliseconds);
//            OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.UTC);
            return localDateTime.format(formatterWithoutMilliseconds);
        } catch (Exception e) {
            LocalDateTime localDateTime = LocalDateTime.parse(inputDateString, formatterWithoutMilliseconds);
//            OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.UTC);
            return localDateTime.format(formatterWithoutMilliseconds);
        }
    }

    public void raiseAnAlert(String alertCode, String alertMessage, String alertProcess, int userId) {
        try {   // <e>  alertMessage    //      <process_name> alertProcess
            String path = System.getenv("APP_HOME") + "alert/start.sh";
            ProcessBuilder pb = new ProcessBuilder(path, alertCode, alertMessage, alertProcess, String.valueOf(userId));
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            String response = null;
            while ((line = reader.readLine()) != null) {
                response += line;
            }
            log.info("Alert is generated :response " + response);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("Not able to execute Alert mgnt jar "+ ex.getLocalizedMessage() + " ::: " + ex.getMessage());
        }
    }

    public boolean madeProgressSince(long timestamp) {
        return lastProgressTime >= timestamp;
    }

    public LocalDateTime convertStringToDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, formatter);
    }

    public static boolean isBeforeOrEqualAmnestyPeriod(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate amnestyDate = LocalDate.parse(dateStr, formatter);
        LocalDate today = LocalDate.now();
        return !today.isAfter(amnestyDate);  // today is before or equal to amnestyDate
    }

}
