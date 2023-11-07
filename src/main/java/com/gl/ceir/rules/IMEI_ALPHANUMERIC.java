package com.gl.ceir.rules;

import com.gl.ceir.builder.ExceptionListBuilder;
import com.gl.ceir.builder.ForeignExceptionBuilder;
import com.gl.ceir.dto.RuleEngineDto;
import com.gl.ceir.model.app.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IMEI_ALPHANUMERIC implements RulesInterface {
    @Override
    public RuleEngineDto<ActiveUniqueImei, ExceptionList> validateActiveUniqueImei(RuleEngineDto<ActiveUniqueImei, ExceptionList> ruleEngineDto) {
        List<ActiveUniqueImei> accepted = new ArrayList<>();
        List<ExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        for(ActiveUniqueImei activeUniqueImei: ruleEngineDto.getNationalWhitelistAccepted()) {
            if(activeUniqueImei.getReason() == null) {
                if (activeUniqueImei.getActualImei().matches("\\d+")) {
                    accepted.add(activeUniqueImei);
                } else {
                    ExceptionList exceptionList = ExceptionListBuilder.fromActiveUniqueImei(activeUniqueImei);
                    if (!exceptionLists.contains(exceptionList)) {
                        exceptionList.setValidityFlag(false);
                        exceptionList.setReasonForInvalidImei("IMEI Alphanumeric");
                        exceptionLists.add(exceptionList);
                    }
                    activeUniqueImei.setReason("IMEI Alphanumeric");
                    activeUniqueImei.setValidityFlag(false);
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
            if (activeUniqueImei.getActualImei().matches("\\d+")) {
                accepted.add(activeUniqueImei);
            } else {
                ExceptionList exceptionList = ExceptionListBuilder.fromActiveImeiWithDifferentMsisdn(activeUniqueImei);
                if (!exceptionLists.contains(exceptionList)) {
                    exceptionList.setValidityFlag(false);
                    exceptionList.setReasonForInvalidImei("IMEI Alphanumeric");
                    exceptionLists.add(exceptionList);
                }
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
                if (activeUniqueImei.getActualImei().matches("\\d+")) {
                    accepted.add(activeUniqueImei);
                } else {
                    ForeignExceptionList exceptionList = ForeignExceptionBuilder.fromActiveUniqueImei(activeUniqueImei);
                    if (!exceptionLists.contains(exceptionList)) {
                        exceptionList.setValidityFlag(false);
                        exceptionList.setReasonForInvalidImei("IMEI Alphanumeric");
                        exceptionLists.add(exceptionList);
                    }
                    activeUniqueImei.setReason("IMEI Alphanumeric");
                    activeUniqueImei.setValidityFlag(false);
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
            if (activeUniqueImei.getActualImei().matches("\\d+")) {
                accepted.add(activeUniqueImei);
            } else {
                ForeignExceptionList exceptionList = ForeignExceptionBuilder.fromActiveImeiWithDifferentMsisdn(activeUniqueImei);
                if (!exceptionLists.contains(exceptionList)) {
                    exceptionList.setValidityFlag(false);
                    exceptionList.setReasonForInvalidImei("IMEI Alphanumeric");
                    exceptionLists.add(exceptionList);
                }
            }
        }
        return new RuleEngineDto<>(accepted, exceptionLists);
    }
}
