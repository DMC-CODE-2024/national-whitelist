package com.gl.ceir.rules;

import com.gl.ceir.builder.ExceptionListBuilder;
import com.gl.ceir.builder.ForeignExceptionBuilder;
import com.gl.ceir.model.app.*;
import com.gl.ceir.repository.app.SystemConfigurationDbRepository;
import org.apache.commons.lang3.StringUtils;
import com.gl.ceir.dto.RuleEngineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IMEI_NULL implements RulesInterface {
    @Autowired
    SystemConfigurationDbRepository systemConfigurationDbRepository;
    private String NULL_IMEI_VALUE;

    @PostConstruct
    public void init() {
        try {
            NULL_IMEI_VALUE = Optional.ofNullable(systemConfigurationDbRepository.getByTag("CDR_NULL_IMEI_REPLACE_PATTERN").getValue()).orElse("999999999999999");
        } catch (Exception e) {
            handleDbConnectionError();
        }
    }

    private void handleDbConnectionError() {
        // Set a default value in case of DB connection error
        NULL_IMEI_VALUE = "999999999999999";
    }

    @Override
    public RuleEngineDto<ActiveUniqueImei, ExceptionList> validateActiveUniqueImei(RuleEngineDto<ActiveUniqueImei, ExceptionList> ruleEngineDto) {
        List<ActiveUniqueImei> accepted = new ArrayList<>();
        List<ExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        for(ActiveUniqueImei activeUniqueImei: ruleEngineDto.getNationalWhitelistAccepted()) {
            if(activeUniqueImei.getReason() == null) {
                if (StringUtils.isEmpty(activeUniqueImei.getActualImei()) || activeUniqueImei.getActualImei().equals(NULL_IMEI_VALUE) || activeUniqueImei.getActualImei().matches("^0+$")) {
                    ExceptionList exceptionList = ExceptionListBuilder.fromActiveUniqueImei(activeUniqueImei);
                    if (!exceptionLists.contains(exceptionList)) {
                        exceptionList.setValidityFlag(false);
                        exceptionList.setReasonForInvalidImei("NULL IMEI");
                        exceptionLists.add(exceptionList);
                    }
                    activeUniqueImei.setReason("NULL IMEI");
                    activeUniqueImei.setValidityFlag(false);
                    accepted.add(activeUniqueImei);
                } else {
                    accepted.add(activeUniqueImei);
                }
            } else {
                accepted.add(activeUniqueImei);
            }
        }
        return new RuleEngineDto<>(accepted, exceptionLists);
    }

    @Override
    public RuleEngineDto<ActiveImeiWithDifferentMsisdn, ExceptionList> validateActiveImeiWithDifferentMsisdn(RuleEngineDto<ActiveImeiWithDifferentMsisdn, ExceptionList> ruleEngineDto) {
        List<ActiveImeiWithDifferentMsisdn> accepted = new ArrayList<>();
        List<ExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        for(ActiveImeiWithDifferentMsisdn activeUniqueImei: ruleEngineDto.getNationalWhitelistAccepted()) {
            if (StringUtils.isEmpty(activeUniqueImei.getActualImei()) || activeUniqueImei.getActualImei().equals(NULL_IMEI_VALUE) || activeUniqueImei.getActualImei().matches("^0+$")) {
                ExceptionList exceptionList = ExceptionListBuilder.fromActiveImeiWithDifferentMsisdn(activeUniqueImei);
                if (!exceptionLists.contains(exceptionList)) {
                    exceptionList.setValidityFlag(false);
                    exceptionList.setReasonForInvalidImei("NULL IMEI");
                    exceptionLists.add(exceptionList);
                }
            } else {
                accepted.add(activeUniqueImei);
            }
        }
        return new RuleEngineDto<>(accepted, exceptionLists);
    }

    @Override
    public RuleEngineDto<ActiveUniqueForeignImei, ForeignExceptionList> validateActiveUniqueForeignImei(RuleEngineDto<ActiveUniqueForeignImei, ForeignExceptionList> ruleEngineDto) {
        List<ActiveUniqueForeignImei> accepted = new ArrayList<>();
        List<ForeignExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        for(ActiveUniqueForeignImei activeUniqueImei: ruleEngineDto.getNationalWhitelistAccepted()) {
            if(activeUniqueImei.getReason() == null) {
                if (StringUtils.isEmpty(activeUniqueImei.getActualImei()) || activeUniqueImei.getActualImei().equals(NULL_IMEI_VALUE) || activeUniqueImei.getActualImei().matches("^0+$")) {
                    ForeignExceptionList exceptionList = ForeignExceptionBuilder.fromActiveUniqueImei(activeUniqueImei);
                    if (!exceptionLists.contains(exceptionList)) {
                        exceptionList.setValidityFlag(false);
                        exceptionList.setReasonForInvalidImei("NULL IMEI");
                        exceptionLists.add(exceptionList);
                    }
                    activeUniqueImei.setReason("NULL IMEI");
                    activeUniqueImei.setValidityFlag(false);
                    accepted.add(activeUniqueImei);
                } else {
                    accepted.add(activeUniqueImei);
                }
            } else {
                accepted.add(activeUniqueImei);
            }
        }
        return new RuleEngineDto<>(accepted, exceptionLists);
    }

    @Override
    public RuleEngineDto<ActiveForeignImeiWithDifferentMsisdn, ForeignExceptionList> validateActiveForeignImeiWithDifferentMsisdn(RuleEngineDto<ActiveForeignImeiWithDifferentMsisdn, ForeignExceptionList> ruleEngineDto) {
        List<ActiveForeignImeiWithDifferentMsisdn> accepted = new ArrayList<>();
        List<ForeignExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        for(ActiveForeignImeiWithDifferentMsisdn activeUniqueImei: ruleEngineDto.getNationalWhitelistAccepted()) {
            if (StringUtils.isEmpty(activeUniqueImei.getActualImei()) || activeUniqueImei.getActualImei().equals(NULL_IMEI_VALUE) || activeUniqueImei.getActualImei().matches("^0+$")) {
                ForeignExceptionList exceptionList = ForeignExceptionBuilder.fromActiveImeiWithDifferentMsisdn(activeUniqueImei);
                if (!exceptionLists.contains(exceptionList)) {
                    exceptionList.setValidityFlag(false);
                    exceptionList.setReasonForInvalidImei("NULL IMEI");
                    exceptionLists.add(exceptionList);
                }
            } else {
                accepted.add(activeUniqueImei);
            }
        }
        return new RuleEngineDto<>(accepted, exceptionLists);
    }
}
