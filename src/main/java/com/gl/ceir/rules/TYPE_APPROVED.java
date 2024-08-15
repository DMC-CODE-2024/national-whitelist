package com.gl.ceir.rules;

import com.gl.ceir.dto.RuleEngineDto;
import com.gl.ceir.model.app.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TYPE_APPROVED implements RulesInterface {
    @Override
    public RuleEngineDto<ActiveUniqueImei, ExceptionList> validateActiveUniqueImei(RuleEngineDto<ActiveUniqueImei, ExceptionList> ruleEngineDto) {
        List<ActiveUniqueImei> accepted = new ArrayList<>();
        List<ExceptionList> exceptionLists = ruleEngineDto.getExceptionList();

        for (ActiveUniqueImei activeUniqueImei : ruleEngineDto.getNationalWhitelistAccepted()) {
            if (activeUniqueImei.getIsTypeApproved() != null) {
                if (activeUniqueImei.getIsTypeApproved() == 1) {
                    activeUniqueImei.setTrcImeiStatus(1);
                } else {
                    activeUniqueImei.setTrcImeiStatus(0);
                }
                activeUniqueImei.setTrcModifiedTime(LocalDateTime.now());
            }

            accepted.add(activeUniqueImei);
        }

        return new RuleEngineDto<>(accepted, exceptionLists);
    }

    @Override
    public RuleEngineDto<ActiveImeiWithDifferentMsisdn, ExceptionList> validateActiveImeiWithDifferentMsisdn(RuleEngineDto<ActiveImeiWithDifferentMsisdn, ExceptionList> ruleEngineDto) {
        return null;
    }

    @Override
    public RuleEngineDto<ActiveUniqueForeignImei, ForeignExceptionList> validateActiveUniqueForeignImei(RuleEngineDto<ActiveUniqueForeignImei, ForeignExceptionList> ruleEngineDto) {
        List<ActiveUniqueForeignImei> accepted = new ArrayList<>();
        List<ForeignExceptionList> exceptionLists = ruleEngineDto.getExceptionList();

        for (ActiveUniqueForeignImei activeUniqueImei : ruleEngineDto.getNationalWhitelistAccepted()) {
            if (activeUniqueImei.getIsTypeApproved() != null) {
                if (activeUniqueImei.getIsTypeApproved() == 1) {
                    activeUniqueImei.setTrcImeiStatus(1);
                } else {
                    activeUniqueImei.setTrcImeiStatus(0);
                }
                activeUniqueImei.setTrcModifiedTime(LocalDateTime.now());
            }

            accepted.add(activeUniqueImei);
        }

        return new RuleEngineDto<>(accepted, exceptionLists);
    }

    @Override
    public RuleEngineDto<ActiveForeignImeiWithDifferentMsisdn, ForeignExceptionList> validateActiveForeignImeiWithDifferentMsisdn(RuleEngineDto<ActiveForeignImeiWithDifferentMsisdn, ForeignExceptionList> ruleEngineDto) {
        return null;
    }

}
