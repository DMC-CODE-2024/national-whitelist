package com.gl.ceir.rules;

import com.gl.ceir.builder.ExceptionListBuilder;
import com.gl.ceir.builder.ForeignExceptionBuilder;
import com.gl.ceir.dto.RuleEngineDto;
import com.gl.ceir.model.app.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IMEI_TEST implements RulesInterface {

    @Value("${imei.prefixes:0044,001}")
    private String prefixes;

    @Override
    public RuleEngineDto<ActiveUniqueImei, ExceptionList> validateActiveUniqueImei(RuleEngineDto<ActiveUniqueImei, ExceptionList> ruleEngineDto) {
        List<ActiveUniqueImei> accepted = new ArrayList<>();
        List<ExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        String[] prefixArray = prefixes.split(",");

        for (ActiveUniqueImei activeUniqueImei : ruleEngineDto.getNationalWhitelistAccepted()) {
            if (activeUniqueImei.getReason() == null) {
                if (startsWithAnyPrefix(activeUniqueImei.getActualImei(), prefixArray)) {
                    ExceptionList exceptionList = ExceptionListBuilder.fromActiveUniqueImei(activeUniqueImei);
                    if (!exceptionLists.contains(exceptionList)) {
                        exceptionList.setValidityFlag(false);
                        exceptionList.setReasonForInvalidImei("Test IMEI");
                        exceptionLists.add(exceptionList);
                    }
                    activeUniqueImei.setReason("Test IMEI");
                    activeUniqueImei.setValidityFlag(false);
                }
            }
            accepted.add(activeUniqueImei);
        }
        return new RuleEngineDto<>(accepted, exceptionLists);
    }

    @Override
    public RuleEngineDto<ActiveImeiWithDifferentMsisdn, ExceptionList> validateActiveImeiWithDifferentMsisdn(
            RuleEngineDto<ActiveImeiWithDifferentMsisdn, ExceptionList> ruleEngineDto) {
        List<ActiveImeiWithDifferentMsisdn> accepted = new ArrayList<>();
        List<ExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        String[] prefixArray = prefixes.split(","); // Assuming 'prefixes' is available from properties

        for (ActiveImeiWithDifferentMsisdn activeUniqueImei : ruleEngineDto.getNationalWhitelistAccepted()) {
            if (startsWithAnyPrefix(activeUniqueImei.getActualImei(), prefixArray)) {
                ExceptionList exceptionList = ExceptionListBuilder.fromActiveImeiWithDifferentMsisdn(activeUniqueImei);
                if (!exceptionLists.contains(exceptionList)) {
                    exceptionList.setValidityFlag(false);
                    exceptionList.setReasonForInvalidImei("Test IMEI");
                    exceptionLists.add(exceptionList);
                }
            } else {
                accepted.add(activeUniqueImei);
            }
        }
        return new RuleEngineDto<>(accepted, exceptionLists);
    }

    @Override
    public RuleEngineDto<ActiveUniqueForeignImei, ForeignExceptionList> validateActiveUniqueForeignImei(
            RuleEngineDto<ActiveUniqueForeignImei, ForeignExceptionList> ruleEngineDto) {
        List<ActiveUniqueForeignImei> accepted = new ArrayList<>();
        List<ForeignExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        String[] prefixArray = prefixes.split(","); // Assuming 'prefixes' is available from properties

        for (ActiveUniqueForeignImei activeUniqueImei : ruleEngineDto.getNationalWhitelistAccepted()) {
            if (activeUniqueImei.getReason() == null) {
                if (startsWithAnyPrefix(activeUniqueImei.getActualImei(), prefixArray)) {
                    ForeignExceptionList exceptionList = ForeignExceptionBuilder.fromActiveUniqueImei(activeUniqueImei);
                    if (!exceptionLists.contains(exceptionList)) {
                        exceptionList.setValidityFlag(false);
                        exceptionList.setReasonForInvalidImei("Test IMEI");
                        exceptionLists.add(exceptionList);
                    }
                    activeUniqueImei.setReason("Test IMEI");
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
    public RuleEngineDto<ActiveForeignImeiWithDifferentMsisdn, ForeignExceptionList> validateActiveForeignImeiWithDifferentMsisdn(
            RuleEngineDto<ActiveForeignImeiWithDifferentMsisdn, ForeignExceptionList> ruleEngineDto) {
        List<ActiveForeignImeiWithDifferentMsisdn> accepted = new ArrayList<>();
        List<ForeignExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        String[] prefixArray = prefixes.split(",");

        for (ActiveForeignImeiWithDifferentMsisdn activeUniqueImei : ruleEngineDto.getNationalWhitelistAccepted()) {
            if (startsWithAnyPrefix(activeUniqueImei.getActualImei(), prefixArray)) {
                ForeignExceptionList exceptionList = ForeignExceptionBuilder.fromActiveImeiWithDifferentMsisdn(activeUniqueImei);
                if (!exceptionLists.contains(exceptionList)) {
                    exceptionList.setValidityFlag(false);
                    exceptionList.setReasonForInvalidImei("Test IMEI");
                    exceptionLists.add(exceptionList);
                }
            } else {
                accepted.add(activeUniqueImei);
            }
        }
        return new RuleEngineDto<>(accepted, exceptionLists);
    }

    private boolean startsWithAnyPrefix(String imei, String[] prefixes) {
        for (String prefix : prefixes) {
            if (imei.startsWith(prefix.trim())) {
                return true;
            }
        }
        return false;
    }
}
