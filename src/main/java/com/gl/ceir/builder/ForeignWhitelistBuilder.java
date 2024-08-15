package com.gl.ceir.builder;

import com.gl.ceir.model.app.ActiveUniqueForeignImei;
import com.gl.ceir.model.app.ForeignWhitelist;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ForeignWhitelistBuilder {
    public static List<ForeignWhitelist> fromActiveUniqueImei(List<ActiveUniqueForeignImei> activeUniqueImeiList, List<String> rules) {
        List<ForeignWhitelist> nationalWhitelistList = new ArrayList<>();

        for (ActiveUniqueForeignImei activeUniqueImei : activeUniqueImeiList) {
            ForeignWhitelist nationalWhitelist = new ForeignWhitelist();

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
            nationalWhitelist.setListType("active_unique_foreign_imei");
            nationalWhitelist.setReasonForInvalidImei(activeUniqueImei.getReason());
            nationalWhitelist.setForeignWhiteListCreatedDate(LocalDateTime.now());
            nationalWhitelist.setIsUsedDeviceImei(activeUniqueImei.getIsUsed());
            nationalWhitelist.setForeignRule(activeUniqueImei.getForeginRule());

            nationalWhitelistList.add(nationalWhitelist);
        }

        return nationalWhitelistList;
    }

    public static ForeignWhitelist fromActiveUniqueImei(ActiveUniqueForeignImei activeUniqueImei) {

            ForeignWhitelist nationalWhitelist = new ForeignWhitelist();
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
            nationalWhitelist.setListType("active_unique_foreign_imei");
            nationalWhitelist.setReasonForInvalidImei(activeUniqueImei.getReason());
            nationalWhitelist.setForeignWhiteListCreatedDate(LocalDateTime.now());
            nationalWhitelist.setIsUsedDeviceImei(activeUniqueImei.getIsUsed());
            nationalWhitelist.setForeignRule(activeUniqueImei.getForeginRule());

        return nationalWhitelist;
    }

    public static LocalDate convertLocalDate(LocalDateTime inputDate) {
        return LocalDate.of(inputDate.getYear(), inputDate.getMonth(), inputDate.getDayOfMonth());
    }

    public static int evaluateFinalValue(Integer customsStatus, Integer manufacturerStatus, List<String> activeRules) {
        boolean isCustomsActive = activeRules.contains("CUSTOM_CHK");
        boolean isManufacturerActive = activeRules.contains("EXISTS_IN_LOCAL_MANUFACTURER_DB");

        int customs = (isCustomsActive && customsStatus != null && customsStatus == 1) ? 1 : 0;
        int manufacturer = (isManufacturerActive && manufacturerStatus != null && manufacturerStatus == 1) ? 1 : 0;

        if (customs == 0 && manufacturer == 0) {
            if (!isCustomsActive && !isManufacturerActive) {
                return 3;
            } else if (!isCustomsActive && isManufacturerActive) {
                return 0;
            } else if (isCustomsActive && !isManufacturerActive) {
                return 0;
            }
        } else if (customs == 0 && manufacturer == 1) {
            return 2;
        } else if (customs == 1 && manufacturer == 0) {
            return 1;
        } else if (customs == 1 && manufacturer == 1) {
            return 0;
        }
        return 3;
    }

    public static int evaluateTrcFinalValue(Integer trcStatus, List<String> activeRules) {
        boolean isTrcActive = activeRules.contains("TYPE_APPROVED");
        int trc = (isTrcActive && trcStatus != null )? trcStatus: 3;
        return trc;
    }
}
