package com.gl.ceir.rules;

import com.gl.ceir.builder.ExceptionListBuilder;
import com.gl.ceir.builder.ForeignExceptionBuilder;
import com.gl.ceir.dto.ActiveForeignImeiWithDifferentImsiDto;
import com.gl.ceir.dto.ActiveUniqueForeignImeiDto;
import com.gl.ceir.dto.ActiveUniqueImeiDto;
import com.gl.ceir.model.app.*;
import com.gl.ceir.model.output.ForeignExceptionList;
import com.gl.ceir.repository.sysParam.SystemConfigurationDbRepository;
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
    public RuleEngineDto<ActiveUniqueImeiDto, ExceptionList> validateActiveUniqueImei(RuleEngineDto<ActiveUniqueImeiDto, ExceptionList> ruleEngineDto) {
        List<ActiveUniqueImeiDto> accepted = new ArrayList<>();
        List<ExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        for(ActiveUniqueImeiDto activeUniqueImei: ruleEngineDto.getNationalWhitelistAccepted()) {
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
    public RuleEngineDto<ActiveUniqueForeignImeiDto, ForeignExceptionList> validateActiveUniqueForeignImei(RuleEngineDto<ActiveUniqueForeignImeiDto, ForeignExceptionList> ruleEngineDto) {
        List<ActiveUniqueForeignImeiDto> accepted = new ArrayList<>();
        List<ForeignExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        for(ActiveUniqueForeignImeiDto activeUniqueImei: ruleEngineDto.getNationalWhitelistAccepted()) {
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
    public RuleEngineDto<ActiveForeignImeiWithDifferentImsiDto, ForeignExceptionList> validateActiveForeignImeiWithDifferentMsisdn(RuleEngineDto<ActiveForeignImeiWithDifferentImsiDto, ForeignExceptionList> ruleEngineDto) {
        List<ActiveForeignImeiWithDifferentImsiDto> accepted = new ArrayList<>();
        List<ForeignExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        for(ActiveForeignImeiWithDifferentImsiDto activeUniqueImei: ruleEngineDto.getNationalWhitelistAccepted()) {
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
