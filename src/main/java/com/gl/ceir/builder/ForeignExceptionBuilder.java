package com.gl.ceir.builder;

import com.gl.ceir.model.app.ActiveForeignImeiWithDifferentMsisdn;
import com.gl.ceir.model.app.ActiveUniqueForeignImei;
import com.gl.ceir.model.app.ForeignExceptionList;

import java.time.LocalDateTime;

public class ForeignExceptionBuilder {

    public static ForeignExceptionList fromActiveUniqueImei(ActiveUniqueForeignImei activeUniqueImei) {
        ForeignExceptionList exceptionList = new ForeignExceptionList();

        exceptionList.setCreatedOn(activeUniqueImei.getCreatedOn());
        exceptionList.setModifiedOn(activeUniqueImei.getModifiedOn());
        exceptionList.setTac(activeUniqueImei.getTac());
        exceptionList.setMsisdn(activeUniqueImei.getMsisdn());
        exceptionList.setFailedRuleId(activeUniqueImei.getFailedRuleId());
        exceptionList.setFailedRuleName(activeUniqueImei.getFailedRuleName());
        exceptionList.setImsi(activeUniqueImei.getImsi());
        exceptionList.setMobileOperator(activeUniqueImei.getMobileOperator());
        exceptionList.setCreatedFilename(activeUniqueImei.getCreateFilename());
        exceptionList.setUpdatedFilename(activeUniqueImei.getUpdateFilename());
        exceptionList.setSystemType(activeUniqueImei.getSystemType());
        exceptionList.setAction(activeUniqueImei.getAction());
        exceptionList.setPeriod(activeUniqueImei.getPeriod());
        exceptionList.setFailedRuleDate(activeUniqueImei.getFailedRuleDate());
        exceptionList.setTaxPaid(activeUniqueImei.getTaxPaid());
        exceptionList.setFeatureName(activeUniqueImei.getFeatureName());
        exceptionList.setRecordTime(activeUniqueImei.getRecordTime());
        exceptionList.setActualImei(activeUniqueImei.getActualImei());
        exceptionList.setRecordType(activeUniqueImei.getRecordType());
        exceptionList.setImei(activeUniqueImei.getImei());
        exceptionList.setRawCdrFileName(activeUniqueImei.getRawCdrFileName());
        exceptionList.setImeiArrivalTime(activeUniqueImei.getImeiArrivalTime());
        exceptionList.setSource(activeUniqueImei.getSource());
        exceptionList.setUpdateRawCdrFileName(activeUniqueImei.getUpdateRawCdrFileName());
        exceptionList.setUpdateImeiArrivalTime(activeUniqueImei.getUpdateImeiArrivalTime());
        exceptionList.setUpdateSource(activeUniqueImei.getUpdateSource());
        exceptionList.setServerOrigin(activeUniqueImei.getServerOrigin());
        exceptionList.setValidityFlag(activeUniqueImei.getValidityFlag());
        exceptionList.setExceptionListCreatedDate(LocalDateTime.now());
        exceptionList.setActualOperator(activeUniqueImei.getActualOperator());
        exceptionList.setIsTestImei(activeUniqueImei.getTestImei());
        exceptionList.setExceptionListCreatedDate(LocalDateTime.now());
        exceptionList.setListType("active_unique_foreign_imei");
        exceptionList.setForeignRule(activeUniqueImei.getForeginRule());
        exceptionList.setIsUsedDeviceImei(activeUniqueImei.getIsUsed());

        return exceptionList;
    }

    public static ForeignExceptionList fromActiveImeiWithDifferentMsisdn(ActiveForeignImeiWithDifferentMsisdn activeImeiWithDifferentMsisdn) {
        ForeignExceptionList exceptionList = new ForeignExceptionList();

        exceptionList.setCreatedOn(activeImeiWithDifferentMsisdn.getCreatedOn());
        exceptionList.setModifiedOn(activeImeiWithDifferentMsisdn.getModifiedOn());
        exceptionList.setTac(activeImeiWithDifferentMsisdn.getTac());
        exceptionList.setMsisdn(activeImeiWithDifferentMsisdn.getMsisdn());
        exceptionList.setFailedRuleId(activeImeiWithDifferentMsisdn.getFailedRuleId());
        exceptionList.setFailedRuleName(activeImeiWithDifferentMsisdn.getFailedRuleName());
        exceptionList.setImsi(activeImeiWithDifferentMsisdn.getImsi());
        exceptionList.setMobileOperator(activeImeiWithDifferentMsisdn.getMobileOperator());
        exceptionList.setCreatedFilename(activeImeiWithDifferentMsisdn.getCreateFilename());
        exceptionList.setUpdatedFilename(activeImeiWithDifferentMsisdn.getUpdateFilename());
        exceptionList.setSystemType(activeImeiWithDifferentMsisdn.getSystemType());
        exceptionList.setAction(activeImeiWithDifferentMsisdn.getAction());
        exceptionList.setPeriod(activeImeiWithDifferentMsisdn.getPeriod());
        exceptionList.setFailedRuleDate(activeImeiWithDifferentMsisdn.getFailedRuleDate());
        exceptionList.setTaxPaid(activeImeiWithDifferentMsisdn.getTaxPaid());
        exceptionList.setFeatureName(activeImeiWithDifferentMsisdn.getFeatureName());
        exceptionList.setRecordTime(activeImeiWithDifferentMsisdn.getRecordTime());
        exceptionList.setActualImei(activeImeiWithDifferentMsisdn.getActualImei());
        exceptionList.setRecordType(activeImeiWithDifferentMsisdn.getRecordType());
        exceptionList.setImei(activeImeiWithDifferentMsisdn.getImei());
        exceptionList.setRawCdrFileName(activeImeiWithDifferentMsisdn.getUpdateRawCdrFileName());
        exceptionList.setImeiArrivalTime(activeImeiWithDifferentMsisdn.getImeiArrivalTime());
        exceptionList.setSource(activeImeiWithDifferentMsisdn.getSource());
        exceptionList.setUpdateRawCdrFileName(activeImeiWithDifferentMsisdn.getUpdateRawCdrFileName());
        exceptionList.setUpdateImeiArrivalTime(activeImeiWithDifferentMsisdn.getUpdateImeiArrivalTime());
        exceptionList.setUpdateSource(activeImeiWithDifferentMsisdn.getUpdateSource());
        exceptionList.setServerOrigin(activeImeiWithDifferentMsisdn.getServerOrigin());
        exceptionList.setValidityFlag(activeImeiWithDifferentMsisdn.getValidityFlag());
        exceptionList.setExceptionListCreatedDate(LocalDateTime.now());
        exceptionList.setActualOperator(activeImeiWithDifferentMsisdn.getActualOperator());
        exceptionList.setIsTestImei(activeImeiWithDifferentMsisdn.getTestImei());
        exceptionList.setExceptionListCreatedDate(LocalDateTime.now());
        exceptionList.setListType("active_foreign_imei_with_different_msisdn");
        exceptionList.setIsUsedDeviceImei(activeImeiWithDifferentMsisdn.getIsUsed());

        return exceptionList;
    }
}
