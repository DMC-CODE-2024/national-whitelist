package com.gl.ceir.builder;

import com.gl.ceir.dto.ActiveForeignImeiWithDifferentImsiDto;
import com.gl.ceir.dto.ActiveUniqueForeignImeiDto;
import com.gl.ceir.model.output.ForeignExceptionList;

import java.time.LocalDateTime;

public class ForeignExceptionBuilder {
    public static ForeignExceptionList fromActiveUniqueImei(ActiveUniqueForeignImeiDto activeUniqueImei) {
        ForeignExceptionList exceptionList = new ForeignExceptionList();
        exceptionList.setCreatedOn(activeUniqueImei.getCreatedOn());
        exceptionList.setModifiedOn(activeUniqueImei.getModifiedOn());
        exceptionList.setTac(activeUniqueImei.getTac());
        exceptionList.setMsisdn(activeUniqueImei.getMsisdn());
        exceptionList.setFailedRuleId(activeUniqueImei.getFailedRuleId());
        exceptionList.setImsi(activeUniqueImei.getImsi());
        exceptionList.setMobileOperator(activeUniqueImei.getMobileOperator());
        exceptionList.setCreatedFilename(activeUniqueImei.getCreateFilename());
        exceptionList.setUpdatedFilename(activeUniqueImei.getUpdateFilename());
        exceptionList.setSystemType(activeUniqueImei.getSystemType());
        exceptionList.setAction(activeUniqueImei.getAction());
        exceptionList.setPeriod(activeUniqueImei.getPeriod());
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
        exceptionList.setIsTestImei(activeUniqueImei.getIsTestImei());
        exceptionList.setExceptionListCreatedDate(LocalDateTime.now());
        exceptionList.setListType("active_unique_foreign_imei");
        exceptionList.setIsUsedDeviceImei(activeUniqueImei.getIsUsed());
        exceptionList.setDeviceType(activeUniqueImei.getDeviceType());
        return exceptionList;
    }

    public static ForeignExceptionList fromActiveImeiWithDifferentMsisdn(ActiveForeignImeiWithDifferentImsiDto activeImeiWithDifferentMsisdn) {
        ForeignExceptionList exceptionList = new ForeignExceptionList();
        exceptionList.setCreatedOn(activeImeiWithDifferentMsisdn.getCreatedOn());
        exceptionList.setModifiedOn(activeImeiWithDifferentMsisdn.getModifiedOn());
        exceptionList.setTac(activeImeiWithDifferentMsisdn.getTac());
        exceptionList.setMsisdn(activeImeiWithDifferentMsisdn.getMsisdn());
        exceptionList.setFailedRuleId(activeImeiWithDifferentMsisdn.getFailedRuleId());
        exceptionList.setImsi(activeImeiWithDifferentMsisdn.getImsi());
        exceptionList.setMobileOperator(activeImeiWithDifferentMsisdn.getMobileOperator());
        exceptionList.setCreatedFilename(activeImeiWithDifferentMsisdn.getCreateFilename());
        exceptionList.setUpdatedFilename(activeImeiWithDifferentMsisdn.getUpdateFilename());
        exceptionList.setSystemType(activeImeiWithDifferentMsisdn.getSystemType());
        exceptionList.setAction(activeImeiWithDifferentMsisdn.getAction());
        exceptionList.setPeriod(activeImeiWithDifferentMsisdn.getPeriod());
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
        exceptionList.setIsTestImei(activeImeiWithDifferentMsisdn.getIsTestImei());
        exceptionList.setExceptionListCreatedDate(LocalDateTime.now());
        exceptionList.setListType("active_foreign_imei_with_different_msisdn");
        exceptionList.setIsUsedDeviceImei(activeImeiWithDifferentMsisdn.getIsUsed());
        return exceptionList;
    }
}
