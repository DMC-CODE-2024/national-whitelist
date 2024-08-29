package com.gl.ceir.rules;

import com.gl.ceir.dto.ActiveForeignImeiWithDifferentImsiDto;
import com.gl.ceir.dto.ActiveUniqueForeignImeiDto;
import com.gl.ceir.dto.ActiveUniqueImeiDto;
import com.gl.ceir.dto.RuleEngineDto;
import com.gl.ceir.model.app.*;
import com.gl.ceir.model.output.ForeignExceptionList;
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
    public RuleEngineDto<ActiveUniqueImeiDto, ExceptionList> validateActiveUniqueImei(RuleEngineDto<ActiveUniqueImeiDto, ExceptionList> ruleEngineDto) {
        List<ActiveUniqueImeiDto> accepted = new ArrayList<>();
        try (Connection connection = appDataSource.getConnection()) {
            for (ActiveUniqueImeiDto imei : ruleEngineDto.getNationalWhitelistAccepted()) {
                try {
                    Optional<GdceData> gdceDataOpt = gdceDataRepository.findByImei(imei.getImei());
                    if (gdceDataOpt.isPresent()) {
                        imei.setCustomsStatus(1);
                    } else {
                        boolean res = CustomCheck.identifyCustomComplianceStatus(connection, imei.getImei(), "NWL");
                        if(res){
                            imei.setCustomsStatus(1);
                        } else {
                            imei.setCustomsStatus(0);
                        }
                    }
                    accepted.add(imei);
                } catch (Exception e) {
                    e.printStackTrace();
                    imei.setCustomsStatus(0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
    public RuleEngineDto<ActiveForeignImeiWithDifferentImsiDto, ForeignExceptionList> validateActiveForeignImeiWithDifferentMsisdn(RuleEngineDto<ActiveForeignImeiWithDifferentImsiDto, ForeignExceptionList> ruleEngineDto) {
        return null;
    }

}
