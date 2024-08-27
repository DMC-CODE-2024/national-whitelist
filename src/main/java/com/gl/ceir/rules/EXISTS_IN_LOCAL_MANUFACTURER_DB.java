package com.gl.ceir.rules;

import com.gl.ceir.dto.ActiveForeignImeiWithDifferentImsiDto;
import com.gl.ceir.dto.ActiveUniqueForeignImeiDto;
import com.gl.ceir.dto.ActiveUniqueImeiDto;
import com.gl.ceir.dto.RuleEngineDto;
import com.gl.ceir.model.app.*;
import com.gl.ceir.repository.app.LocalManufacturedDeviceDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EXISTS_IN_LOCAL_MANUFACTURER_DB implements RulesInterface {
    @Autowired
    private LocalManufacturedDeviceDataRepository localManufacturedDeviceDataRepository;
    @Override
    public RuleEngineDto<ActiveUniqueImeiDto, ExceptionList> validateActiveUniqueImei(RuleEngineDto<ActiveUniqueImeiDto, ExceptionList> ruleEngineDto) {
        List<ActiveUniqueImeiDto> accepted = new ArrayList<>();
        for (ActiveUniqueImeiDto imei : ruleEngineDto.getNationalWhitelistAccepted()) {
            Optional<LocalManufacturedDeviceData> localDataOpt = localManufacturedDeviceDataRepository.findByImei(imei.getImei());
            if (localDataOpt.isPresent()) {
                imei.setLocalManufacturerStatus(1);
            } else {
                imei.setLocalManufacturerStatus(0);
            }
            accepted.add(imei);
        }
        return new RuleEngineDto<>(accepted, ruleEngineDto.getExceptionList());
    }

    @Override
    public RuleEngineDto<ActiveImeiWithDifferentMsisdn, ExceptionList> validateActiveImeiWithDifferentMsisdn(RuleEngineDto<ActiveImeiWithDifferentMsisdn, ExceptionList> ruleEngineDto) {
        return null;
    }

    @Override
    public RuleEngineDto<ActiveUniqueForeignImeiDto, ForeignExceptionList> validateActiveUniqueForeignImei(RuleEngineDto<ActiveUniqueForeignImeiDto, ForeignExceptionList> ruleEngineDto) {
        List<ActiveUniqueForeignImeiDto> accepted = new ArrayList<>();
        for (ActiveUniqueForeignImeiDto imei : ruleEngineDto.getNationalWhitelistAccepted()) {
            Optional<LocalManufacturedDeviceData> localDataOpt = localManufacturedDeviceDataRepository.findByImei(imei.getImei());
            if (localDataOpt.isPresent()) {
                imei.setLocalManufacturerStatus(1);
            } else {
                imei.setLocalManufacturerStatus(0);
            }
            accepted.add(imei);
        }
        return new RuleEngineDto<>(accepted, ruleEngineDto.getExceptionList());
    }

    @Override
    public RuleEngineDto<ActiveForeignImeiWithDifferentImsiDto, ForeignExceptionList> validateActiveForeignImeiWithDifferentMsisdn(RuleEngineDto<ActiveForeignImeiWithDifferentImsiDto, ForeignExceptionList> ruleEngineDto) {
        return null;
    }

}
