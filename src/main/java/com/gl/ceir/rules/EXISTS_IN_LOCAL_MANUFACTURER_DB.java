package com.gl.ceir.rules;

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
    public RuleEngineDto<ActiveUniqueImei, ExceptionList> validateActiveUniqueImei(RuleEngineDto<ActiveUniqueImei, ExceptionList> ruleEngineDto) {
        List<ActiveUniqueImei> accepted = new ArrayList<>();
        for (ActiveUniqueImei imei : ruleEngineDto.getNationalWhitelistAccepted()) {
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
    public RuleEngineDto<ActiveUniqueForeignImei, ForeignExceptionList> validateActiveUniqueForeignImei(RuleEngineDto<ActiveUniqueForeignImei, ForeignExceptionList> ruleEngineDto) {
        List<ActiveUniqueForeignImei> accepted = new ArrayList<>();
        for (ActiveUniqueForeignImei imei : ruleEngineDto.getNationalWhitelistAccepted()) {
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
    public RuleEngineDto<ActiveForeignImeiWithDifferentMsisdn, ForeignExceptionList> validateActiveForeignImeiWithDifferentMsisdn(RuleEngineDto<ActiveForeignImeiWithDifferentMsisdn, ForeignExceptionList> ruleEngineDto) {
        return null;
    }
}
