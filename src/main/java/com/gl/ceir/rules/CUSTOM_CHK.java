package com.gl.ceir.rules;

import com.gl.ceir.dto.RuleEngineDto;
import com.gl.ceir.model.app.*;
import com.gl.ceir.repository.app.GdceDataRepository;
import com.gl.custom.CustomCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CUSTOM_CHK implements RulesInterface {
    @Autowired
    private GdceDataRepository gdceDataRepository;

    @Autowired
    private DataSource appDataSource;

    @Override
    public RuleEngineDto<ActiveUniqueImei, ExceptionList> validateActiveUniqueImei(RuleEngineDto<ActiveUniqueImei, ExceptionList> ruleEngineDto) {
        List<ActiveUniqueImei> accepted = new ArrayList<>();
        for (ActiveUniqueImei imei : ruleEngineDto.getNationalWhitelistAccepted()) {
            Optional<GdceData> gdceDataOpt = gdceDataRepository.findByImei(imei.getImei());
            if (gdceDataOpt.isPresent()) {
                imei.setCustomsStatus(1);
            } else {
                try (Connection connection = appDataSource.getConnection()) {
                    boolean res = CustomCheck.identifyCustomComplianceStatus(connection, imei.getImei(), "NWL");
                    if(res){
                        imei.setCustomsStatus(1);
                    } else {
                        imei.setCustomsStatus(0);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    imei.setCustomsStatus(0);
                }
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
            Optional<GdceData> gdceDataOpt = gdceDataRepository.findByImei(imei.getImei());
            if (gdceDataOpt.isPresent()) {
                imei.setCustomsStatus(1);
            } else {
                imei.setCustomsStatus(0);
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
