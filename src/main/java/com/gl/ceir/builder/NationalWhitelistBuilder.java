package com.gl.ceir.builder;

import com.gl.ceir.config.AppDbConfig;
import com.gl.ceir.model.app.ActiveUniqueImei;
import com.gl.ceir.model.app.NationalWhitelist;
import com.gl.custom.CustomCheck;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NationalWhitelistBuilder {

    @Autowired
    private DataSource appDataSource;

    public static List<NationalWhitelist> fromActiveUniqueImei(List<ActiveUniqueImei> activeUniqueImeiList, List<String> rules, boolean amnestyPeriodFlag) {
        List<NationalWhitelist> nationalWhitelistList = new ArrayList<>();

        for (ActiveUniqueImei activeUniqueImei : activeUniqueImeiList) {
            NationalWhitelist nationalWhitelist = new NationalWhitelist();
            nationalWhitelist.setCreatedOn(activeUniqueImei.getCreatedOn());
            nationalWhitelist.setModifiedOn(activeUniqueImei.getModifiedOn());
            nationalWhitelist.setForeignRule(activeUniqueImei.getForeginRule());
            nationalWhitelist.setTac(activeUniqueImei.getTac());
            nationalWhitelist.setMobileOperator(activeUniqueImei.getMobileOperator());
            nationalWhitelist.setCreatedFilename(activeUniqueImei.getCreateFilename());
            nationalWhitelist.setUpdatedFilename(activeUniqueImei.getUpdateFilename());
            nationalWhitelist.setUpdatedOn(activeUniqueImei.getUpdatedOn());
            nationalWhitelist.setSystemType(activeUniqueImei.getSystemType());
            nationalWhitelist.setAction(activeUniqueImei.getAction());
            nationalWhitelist.setPeriod(activeUniqueImei.getPeriod());
            nationalWhitelist.setFailedRuleDate(activeUniqueImei.getFailedRuleDate());
            nationalWhitelist.setFailedRuleId(activeUniqueImei.getFailedRuleId());
            nationalWhitelist.setFailedRuleName(activeUniqueImei.getFailedRuleName());
            nationalWhitelist.setTaxPaid(Integer.toString(Optional.ofNullable(activeUniqueImei.getTaxPaid()).orElse(0)));
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
            nationalWhitelist.setIsTestImei(activeUniqueImei.getTestImei());
            nationalWhitelist.setValidityFlag(activeUniqueImei.getValidityFlag());
            nationalWhitelist.setListType("active_unique_imei");
            nationalWhitelist.setNationalWhiteListCreatedDate(LocalDateTime.now());
            nationalWhitelist.setReasonForInvalidImei(activeUniqueImei.getReason());
            nationalWhitelist.setIsUsedDeviceImei(activeUniqueImei.getIsUsed());
            nationalWhitelist.setForeignRule(activeUniqueImei.getForeginRule());
            nationalWhitelist.setTrcImeiStatus(evaluateTrcFinalValue(activeUniqueImei.getTrcImeiStatus(), rules, activeUniqueImei.getValidityFlag()));
            nationalWhitelist.setTrcModifiedTime(activeUniqueImei.getTrcModifiedTime());
            nationalWhitelist.setGdceImeiStatus(evaluateGdceFinalValue(activeUniqueImei.getCustomsStatus(), activeUniqueImei.getLocalManufacturerStatus(), rules, amnestyPeriodFlag));
            nationalWhitelist.setGdceModifiedTime(LocalDateTime.now());

            nationalWhitelistList.add(nationalWhitelist);
        }

        return nationalWhitelistList;
    }

    public static NationalWhitelist fromActiveUniqueImei(ActiveUniqueImei activeUniqueImei) {
        NationalWhitelist nationalWhitelist = new NationalWhitelist();

            nationalWhitelist.setCreatedOn(activeUniqueImei.getCreatedOn());
            nationalWhitelist.setModifiedOn(activeUniqueImei.getModifiedOn());
            nationalWhitelist.setForeignRule(activeUniqueImei.getForeginRule());
            nationalWhitelist.setTac(activeUniqueImei.getTac());
            nationalWhitelist.setMobileOperator(activeUniqueImei.getMobileOperator());
            nationalWhitelist.setCreatedFilename(activeUniqueImei.getCreateFilename());
            nationalWhitelist.setUpdatedFilename(activeUniqueImei.getUpdateFilename());
            nationalWhitelist.setUpdatedOn(activeUniqueImei.getUpdatedOn());
            nationalWhitelist.setSystemType(activeUniqueImei.getSystemType());
            nationalWhitelist.setAction(activeUniqueImei.getAction());
            nationalWhitelist.setPeriod(activeUniqueImei.getPeriod());
            nationalWhitelist.setFailedRuleDate(activeUniqueImei.getFailedRuleDate());
            nationalWhitelist.setFailedRuleId(activeUniqueImei.getFailedRuleId());
            nationalWhitelist.setFailedRuleName(activeUniqueImei.getFailedRuleName());
            nationalWhitelist.setTaxPaid(Integer.toString(Optional.ofNullable(activeUniqueImei.getTaxPaid()).orElse(0)));
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
            nationalWhitelist.setIsTestImei(activeUniqueImei.getTestImei());
            nationalWhitelist.setValidityFlag(activeUniqueImei.getValidityFlag());
            nationalWhitelist.setListType("active_unique_imei");
            nationalWhitelist.setReasonForInvalidImei(activeUniqueImei.getReason());
            nationalWhitelist.setNationalWhiteListCreatedDate(LocalDateTime.now());
            nationalWhitelist.setIsUsedDeviceImei(activeUniqueImei.getIsUsed());
            nationalWhitelist.setForeignRule(activeUniqueImei.getForeginRule());

        return nationalWhitelist;
    }

    public static LocalDate convertLocalDate(LocalDateTime inputDate) {
        return LocalDate.of(inputDate.getYear(), inputDate.getMonth(), inputDate.getDayOfMonth());
    }

    public static int evaluateGdceFinalValue(Integer customsStatus, Integer manufacturerStatus, List<String> activeRules, boolean amnestyPeriodFlag) {
        boolean isCustomsActive = activeRules.contains("CUSTOM_CHK");
        boolean isManufacturerActive = activeRules.contains("EXISTS_IN_LOCAL_MANUFACTURER_DB");

        int customs = (isCustomsActive && customsStatus != null) ? 1 : 0;
        int manufacturer = (isManufacturerActive && manufacturerStatus != null) ? 1 : 0;

        if (customs == 0 && manufacturer == 0) {
            return 3;
        }

        if (customs == 0 && manufacturer == 1) {
            if (manufacturerStatus == 1) {
                return 2;
            } else if (manufacturerStatus == 0) {
                return amnestyPeriodFlag ? 3 : 0;
            }
        }

        if (customs == 1 && manufacturer == 0) {
            if (customsStatus == 1) {
                return 1;
            } else if (customsStatus == 0) {
                return amnestyPeriodFlag ? 3 : 0;
            }
        }

        if (customs == 1 && manufacturer == 1) {
            if (customsStatus == 1 && manufacturerStatus != null) {
                return 1;
            } else if (customsStatus == 0) {
                if (manufacturerStatus == 0) {
                    return amnestyPeriodFlag ? 3 : 0;
                } else if (manufacturerStatus == 1) {
                    return 2;
                }
            }
        }

        return -1;
    }

    public static int evaluateTrcFinalValue(Integer trcStatus, List<String> activeRules, boolean validityFlag) {
        boolean isTrcActive = activeRules.contains("TYPE_APPROVED");
        int trc;
        if (isTrcActive) {
            if (validityFlag) {
                trc = trcStatus;
            } else {
                trc = 2;
            }
        } else {
            if (validityFlag) {
                trc = 3;
            } else {
                trc = 2;
            }
        }
        return trc;
    }

}

