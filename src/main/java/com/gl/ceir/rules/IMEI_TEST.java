package com.gl.ceir.rules;

import com.gl.ceir.builder.ExceptionListBuilder;
import com.gl.ceir.builder.ForeignExceptionBuilder;
import com.gl.ceir.dto.ActiveForeignImeiWithDifferentImsiDto;
import com.gl.ceir.dto.ActiveUniqueForeignImeiDto;
import com.gl.ceir.dto.ActiveUniqueImeiDto;
import com.gl.ceir.dto.RuleEngineDto;
import com.gl.ceir.model.app.*;
import com.gl.ceir.model.output.ForeignExceptionList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IMEI_TEST implements RulesInterface {

    @Value("${imei.prefixes:0044,001}")
    private String prefixes;

    @Override
    public RuleEngineDto<ActiveUniqueImeiDto, ExceptionList> validateActiveUniqueImei(RuleEngineDto<ActiveUniqueImeiDto, ExceptionList> ruleEngineDto) {
        List<ActiveUniqueImeiDto> accepted = new ArrayList<>();
        List<ExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        String[] prefixArray = prefixes.split(",");

        for (ActiveUniqueImeiDto activeUniqueImei : ruleEngineDto.getNationalWhitelistAccepted()) {
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
    public RuleEngineDto<ActiveUniqueForeignImeiDto, ForeignExceptionList> validateActiveUniqueForeignImei(
            RuleEngineDto<ActiveUniqueForeignImeiDto, ForeignExceptionList> ruleEngineDto) {
        List<ActiveUniqueForeignImeiDto> accepted = new ArrayList<>();
        List<ForeignExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        String[] prefixArray = prefixes.split(","); // Assuming 'prefixes' is available from properties

        for (ActiveUniqueForeignImeiDto activeUniqueImei : ruleEngineDto.getNationalWhitelistAccepted()) {
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
    public RuleEngineDto<ActiveForeignImeiWithDifferentImsiDto, ForeignExceptionList> validateActiveForeignImeiWithDifferentMsisdn(
            RuleEngineDto<ActiveForeignImeiWithDifferentImsiDto, ForeignExceptionList> ruleEngineDto) {
        List<ActiveForeignImeiWithDifferentImsiDto> accepted = new ArrayList<>();
        List<ForeignExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        String[] prefixArray = prefixes.split(",");

        for (ActiveForeignImeiWithDifferentImsiDto activeUniqueImei : ruleEngineDto.getNationalWhitelistAccepted()) {
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
