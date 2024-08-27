package com.gl.ceir.rules;

import com.gl.ceir.dto.ActiveForeignImeiWithDifferentImsiDto;
import com.gl.ceir.dto.ActiveUniqueForeignImeiDto;
import com.gl.ceir.dto.ActiveUniqueImeiDto;
import com.gl.ceir.dto.RuleEngineDto;
import com.gl.ceir.model.app.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TYPE_APPROVED implements RulesInterface {
    @Override
    public RuleEngineDto<ActiveUniqueImeiDto, ExceptionList> validateActiveUniqueImei(RuleEngineDto<ActiveUniqueImeiDto, ExceptionList> ruleEngineDto) {
        List<ActiveUniqueImeiDto> accepted = new ArrayList<>();
        List<ExceptionList> exceptionLists = ruleEngineDto.getExceptionList();

        for (ActiveUniqueImeiDto activeUniqueImei : ruleEngineDto.getNationalWhitelistAccepted()) {
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
    public RuleEngineDto<ActiveUniqueForeignImeiDto, ForeignExceptionList> validateActiveUniqueForeignImei(RuleEngineDto<ActiveUniqueForeignImeiDto, ForeignExceptionList> ruleEngineDto) {
        List<ActiveUniqueForeignImeiDto> accepted = new ArrayList<>();
        List<ForeignExceptionList> exceptionLists = ruleEngineDto.getExceptionList();

        for (ActiveUniqueForeignImeiDto activeUniqueImei : ruleEngineDto.getNationalWhitelistAccepted()) {
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
    public RuleEngineDto<ActiveForeignImeiWithDifferentImsiDto, ForeignExceptionList> validateActiveForeignImeiWithDifferentMsisdn(RuleEngineDto<ActiveForeignImeiWithDifferentImsiDto, ForeignExceptionList> ruleEngineDto) {
        return null;
    }

}
