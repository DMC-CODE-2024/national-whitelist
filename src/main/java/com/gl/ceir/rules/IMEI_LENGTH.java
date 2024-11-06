package com.gl.ceir.rules;

import com.gl.ceir.dto.ActiveForeignImeiWithDifferentImsiDto;
import com.gl.ceir.dto.ActiveUniqueForeignImeiDto;
import com.gl.ceir.dto.ActiveUniqueImeiDto;
import com.gl.ceir.dto.RuleEngineDto;
import com.gl.ceir.model.app.*;
import com.gl.ceir.model.output.ForeignExceptionList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IMEI_LENGTH implements RulesInterface{

    @Override
    public RuleEngineDto<ActiveUniqueImeiDto, ExceptionList> validateActiveUniqueImei(RuleEngineDto<ActiveUniqueImeiDto, ExceptionList> ruleEngineDto) {
        List<ActiveUniqueImeiDto> accepted = new ArrayList<>();
        List<ExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        for(ActiveUniqueImeiDto activeUniqueImei: ruleEngineDto.getNationalWhitelistAccepted()) {
            if(activeUniqueImei.getReason() == null) {
                if (activeUniqueImei.getActualImei().trim().length() == 14 || activeUniqueImei.getActualImei().trim().length() == 15 || activeUniqueImei.getActualImei().trim().length() == 16) {
                    accepted.add(activeUniqueImei);
                } else {
                    ExceptionList exceptionList = ExceptionListBuilder.fromActiveUniqueImei(activeUniqueImei);
                    if (!exceptionLists.contains(exceptionList)) {
                        exceptionList.setValidityFlag(false);
                        exceptionList.setReasonForInvalidImei("Invalid IMEI length");
                        exceptionLists.add(exceptionList);
                    }
                    activeUniqueImei.setReason("Invalid IMEI length");
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
            if (activeUniqueImei.getActualImei().trim().length() == 14 || activeUniqueImei.getActualImei().trim().length() == 15 || activeUniqueImei.getActualImei().trim().length() == 16) {
                accepted.add(activeUniqueImei);
            } else {
                ExceptionList exceptionList = ExceptionListBuilder.fromActiveImeiWithDifferentMsisdn(activeUniqueImei);
                if (!exceptionLists.contains(exceptionList)) {
                    exceptionList.setValidityFlag(false);
                    exceptionList.setReasonForInvalidImei("Invalid IMEI length");
                    exceptionLists.add(exceptionList);
                }
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
                if (activeUniqueImei.getActualImei().trim().length() == 14 || activeUniqueImei.getActualImei().trim().length() == 15 || activeUniqueImei.getActualImei().trim().length() == 16) {
                    accepted.add(activeUniqueImei);
                } else {
                    ForeignExceptionList exceptionList = ForeignExceptionBuilder.fromActiveUniqueImei(activeUniqueImei);
                    if (!exceptionLists.contains(exceptionList)) {
                        exceptionList.setValidityFlag(false);
                        exceptionList.setReasonForInvalidImei("Invalid IMEI length");
                        exceptionLists.add(exceptionList);
                    }
                    activeUniqueImei.setReason("Invalid IMEI length");
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
    public RuleEngineDto<ActiveForeignImeiWithDifferentImsiDto, ForeignExceptionList> validateActiveForeignImeiWithDifferentMsisdn(RuleEngineDto<ActiveForeignImeiWithDifferentImsiDto, ForeignExceptionList> ruleEngineDto) {
        List<ActiveForeignImeiWithDifferentImsiDto> accepted = new ArrayList<>();
        List<ForeignExceptionList> exceptionLists = ruleEngineDto.getExceptionList();
        for(ActiveForeignImeiWithDifferentImsiDto activeUniqueImei: ruleEngineDto.getNationalWhitelistAccepted()) {
            if (activeUniqueImei.getActualImei().trim().length() == 14 || activeUniqueImei.getActualImei().trim().length() == 15 || activeUniqueImei.getActualImei().trim().length() == 16) {
                accepted.add(activeUniqueImei);
            } else {
                ForeignExceptionList exceptionList = ForeignExceptionBuilder.fromActiveImeiWithDifferentMsisdn(activeUniqueImei);
                if (!exceptionLists.contains(exceptionList)) {
                    exceptionList.setValidityFlag(false);
                    exceptionList.setReasonForInvalidImei("Invalid IMEI length");
                    exceptionLists.add(exceptionList);
                }
            }
        }
        return new RuleEngineDto<>(accepted, exceptionLists);
    }
}
