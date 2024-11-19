package com.gl.ceir.builder;

import com.gl.ceir.dto.ActiveUniqueImeiDto;
import com.gl.ceir.model.app.ActiveUniqueImei;
import com.gl.ceir.model.output.NationalWhitelist;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NationalWhitelistBuilder {
    @Autowired
    private DataSource appDataSource;

    public static List<NationalWhitelist> fromActiveUniqueImei(List<ActiveUniqueImeiDto> activeUniqueImeiList, List<String> rules, boolean amnestyPeriodFlag) {
        List<NationalWhitelist> nationalWhitelistList = new ArrayList<>();
        for (ActiveUniqueImeiDto activeUniqueImei : activeUniqueImeiList) {
            NationalWhitelist nationalWhitelist = new NationalWhitelist();
            nationalWhitelist.setCreatedOn(activeUniqueImei.getCreatedOn());
            nationalWhitelist.setModifiedOn(activeUniqueImei.getModifiedOn());
            nationalWhitelist.setTac(activeUniqueImei.getTac());
            nationalWhitelist.setMobileOperator(activeUniqueImei.getMobileOperator());
            nationalWhitelist.setCreatedFilename(activeUniqueImei.getCreateFilename());
            nationalWhitelist.setUpdatedFilename(activeUniqueImei.getUpdateFilename());
            nationalWhitelist.setUpdatedOn(activeUniqueImei.getUpdatedOn());
            nationalWhitelist.setSystemType(activeUniqueImei.getSystemType());
            nationalWhitelist.setAction(activeUniqueImei.getAction());
            nationalWhitelist.setPeriod(activeUniqueImei.getPeriod());
            nationalWhitelist.setFailedRuleId(activeUniqueImei.getFailedRuleId());
            nationalWhitelist.setFailedRuleName(activeUniqueImei.getFailedRuleName());
            nationalWhitelist.setFeatureName(activeUniqueImei.getFeatureName());
            nationalWhitelist.setRecordTime(activeUniqueImei.getRecordTime());
            nationalWhitelist.setActualImei(activeUniqueImei.getActualImei());
            nationalWhitelist.setRecordType(activeUniqueImei.getRecordType());
            nationalWhitelist.setImei(activeUniqueImei.getImei());
            nationalWhitelist.setRawCdrFileName(activeUniqueImei.getRawCdrFileName());
            nationalWhitelist.setImeiArrivalTime(activeUniqueImei.getImeiArrivalTime());
            nationalWhitelist.setSource(activeUniqueImei.getSource());
            nationalWhitelist.setUpdateRawCdrFileName(activeUniqueImei.getUpdateRawCdrFileName());
            nationalWhitelist.setUpdateImeiArrivalTime(activeUniqueImei.getUpdateImeiArrivalTime());
            nationalWhitelist.setUpdateSource(activeUniqueImei.getUpdateSource());
            nationalWhitelist.setServerOrigin(activeUniqueImei.getServerOrigin());
            nationalWhitelist.setMsisdn(activeUniqueImei.getMsisdn());
            nationalWhitelist.setImsi(activeUniqueImei.getImsi());
            nationalWhitelist.setCreatedOnDate(convertLocalDate(activeUniqueImei.getCreatedOn()));
            nationalWhitelist.setActualOperator(activeUniqueImei.getActualOperator());
            nationalWhitelist.setIsTestImei(activeUniqueImei.getIsTestImei());
            nationalWhitelist.setValidityFlag(activeUniqueImei.getValidityFlag());
            nationalWhitelist.setListType("active_unique_imei");
            nationalWhitelist.setNationalWhiteListCreatedDate(LocalDateTime.now());
            nationalWhitelist.setReasonForInvalidImei(activeUniqueImei.getReason());
            nationalWhitelist.setIsUsedDeviceImei(activeUniqueImei.getIsUsed());
            nationalWhitelist.setTrcImeiStatus(Integer.valueOf(evaluateTrcFinalValue(activeUniqueImei.getTrcImeiStatus(), rules, activeUniqueImei.getValidityFlag().booleanValue())));
            nationalWhitelist.setTrcModifiedTime(activeUniqueImei.getTrcModifiedTime());
            nationalWhitelist.setGdceImeiStatus(Integer.valueOf(evaluateGdceFinalValue(activeUniqueImei.getCustomsStatus(), activeUniqueImei.getLocalManufacturerStatus(), rules, amnestyPeriodFlag)));
            nationalWhitelist.setGdceModifiedTime(LocalDateTime.now());
            nationalWhitelist.setTimestamp(activeUniqueImei.getTimestamp());
            nationalWhitelist.setProtocol(activeUniqueImei.getProtocol());
            nationalWhitelist.setDeviceType(activeUniqueImei.getDeviceType());
            nationalWhitelistList.add(nationalWhitelist);
        }
        return nationalWhitelistList;
    }

    public static NationalWhitelist fromActiveUniqueImei(ActiveUniqueImei activeUniqueImei) {
        NationalWhitelist nationalWhitelist = new NationalWhitelist();
        nationalWhitelist.setCreatedOn(activeUniqueImei.getCreatedOn());
        nationalWhitelist.setModifiedOn(activeUniqueImei.getModifiedOn());
        nationalWhitelist.setTac(activeUniqueImei.getTac());
        nationalWhitelist.setMobileOperator(activeUniqueImei.getMobileOperator());
        nationalWhitelist.setCreatedFilename(activeUniqueImei.getCreateFilename());
        nationalWhitelist.setUpdatedFilename(activeUniqueImei.getUpdateFilename());
        nationalWhitelist.setUpdatedOn(activeUniqueImei.getUpdatedOn());
        nationalWhitelist.setSystemType(activeUniqueImei.getSystemType());
        nationalWhitelist.setAction(activeUniqueImei.getAction());
        nationalWhitelist.setPeriod(activeUniqueImei.getPeriod());
        nationalWhitelist.setFailedRuleId(activeUniqueImei.getFailedRuleId());
        nationalWhitelist.setFailedRuleName(activeUniqueImei.getFailedRuleName());
        nationalWhitelist.setFeatureName(activeUniqueImei.getFeatureName());
        nationalWhitelist.setRecordTime(activeUniqueImei.getRecordTime());
        nationalWhitelist.setActualImei(activeUniqueImei.getActualImei());
        nationalWhitelist.setRecordType(activeUniqueImei.getRecordType());
        nationalWhitelist.setImei(activeUniqueImei.getImei());
        nationalWhitelist.setRawCdrFileName(activeUniqueImei.getRawCdrFileName());
        nationalWhitelist.setImeiArrivalTime(activeUniqueImei.getImeiArrivalTime());
        nationalWhitelist.setSource(activeUniqueImei.getSource());
        nationalWhitelist.setUpdateRawCdrFileName(activeUniqueImei.getUpdateRawCdrFileName());
        nationalWhitelist.setUpdateImeiArrivalTime(activeUniqueImei.getUpdateImeiArrivalTime());
        nationalWhitelist.setUpdateSource(activeUniqueImei.getUpdateSource());
        nationalWhitelist.setServerOrigin(activeUniqueImei.getServerOrigin());
        nationalWhitelist.setMsisdn(activeUniqueImei.getMsisdn());
        nationalWhitelist.setImsi(activeUniqueImei.getImsi());
        nationalWhitelist.setCreatedOnDate(convertLocalDate(activeUniqueImei.getCreatedOn()));
        nationalWhitelist.setActualOperator(activeUniqueImei.getActualOperator());
        nationalWhitelist.setIsTestImei(activeUniqueImei.getIsTestImei());
        nationalWhitelist.setValidityFlag(activeUniqueImei.getValidityFlag());
        nationalWhitelist.setListType("active_unique_imei");
        nationalWhitelist.setReasonForInvalidImei(activeUniqueImei.getReason());
        nationalWhitelist.setNationalWhiteListCreatedDate(LocalDateTime.now());
        nationalWhitelist.setIsUsedDeviceImei(activeUniqueImei.getIsUsed());
        return nationalWhitelist;
    }

    public static LocalDate convertLocalDate(LocalDateTime inputDate) {
        return LocalDate.of(inputDate.getYear(), inputDate.getMonth(), inputDate.getDayOfMonth());
    }

    public static int evaluateGdceFinalValue(Integer customsStatus, Integer manufacturerStatus, List<String> activeRules, boolean amnestyPeriodFlag) {
        boolean isCustomsActive = activeRules.contains("CUSTOM_GDCE");
        boolean isManufacturerActive = activeRules.contains("LOCAL_MANUFACTURER");
        int customs = (isCustomsActive && customsStatus != null) ? 1 : 0;
        int manufacturer = (isManufacturerActive && manufacturerStatus != null) ? 1 : 0;
        if (customs == 0 && manufacturer == 0)
            return 3;
        if (customs == 0 && manufacturer == 1) {
            if (manufacturerStatus.intValue() == 1)
                return 2;
            if (manufacturerStatus.intValue() == 0)
                return amnestyPeriodFlag ? 3 : 0;
        }
        if (customs == 1 && manufacturer == 0) {
            if (customsStatus.intValue() == 1)
                return 1;
            if (customsStatus.intValue() == 0)
                return amnestyPeriodFlag ? 3 : 0;
        }
        if (customs == 1 && manufacturer == 1) {
            if (customsStatus.intValue() == 1 && manufacturerStatus != null)
                return 1;
            if (customsStatus.intValue() == 0) {
                if (manufacturerStatus.intValue() == 0)
                    return amnestyPeriodFlag ? 3 : 0;
                if (manufacturerStatus.intValue() == 1)
                    return 2;
            }
        }
        return -1;
    }

    public static int evaluateTrcFinalValue(Integer trcStatus, List<String> activeRules, boolean validityFlag) {
        int trc;
        boolean isTrcActive = activeRules.contains("TYPE_APPROVED");
        if (isTrcActive) {
            if (validityFlag) {
                trc = trcStatus.intValue();
            } else {
                trc = 2;
            }
        } else if (validityFlag) {
            trc = 3;
        } else {
            trc = 2;
        }
        return trc;
    }
}
