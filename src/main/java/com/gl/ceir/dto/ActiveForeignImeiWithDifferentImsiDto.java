package com.gl.ceir.dto;

import com.gl.ceir.model.app.ActiveForeignImeiWithDifferentImsi;
import com.gl.ceir.model.app.ActiveForeignImeiWithDifferentMsisdn;
import com.gl.ceir.model.app.ActiveImeiWithDifferentMsisdn;

import java.time.LocalDateTime;

public class ActiveForeignImeiWithDifferentImsiDto {

    private Integer id;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;
    private String tac;
    private String msisdn;
    private Integer failedRuleId;
    private String failedRuleName;
    private String imsi;
    private String mobileOperator;
    private String createFilename;
    private String updateFilename;
    private LocalDateTime updatedOn;
    private String protocol;
    private String action;
    private String period;
    private LocalDateTime failedRuleDate;
    private Integer mobileOperatorId;
    private Integer taxPaid;
    private String featureName;
    private LocalDateTime recordTime;
    private String actualImei;
    private LocalDateTime timestamp;
    private String imei;
    private String rawCdrFileName;
    private LocalDateTime imeiArrivalTime;
    private String source;
    private String updateRawCdrFileName;
    private LocalDateTime updateImeiArrivalTime;
    private String updateSource;
    private String serverOrigin;
    private String actualOperator;
    private String testImei;
    private String isUsed;
    private Boolean validityFlag;
    private String systemType;
    private String recordType;
    private String deviceType;

    // Getters and Setters for each field


    public ActiveForeignImeiWithDifferentImsiDto() {
    }

    public ActiveForeignImeiWithDifferentImsiDto(Integer id, LocalDateTime createdOn, LocalDateTime modifiedOn, String tac, String msisdn, Integer failedRuleId, String failedRuleName, String imsi, String mobileOperator, String createFilename, String updateFilename, LocalDateTime updatedOn, String protocol, String action, String period, LocalDateTime failedRuleDate, Integer mobileOperatorId, Integer taxPaid, String featureName, LocalDateTime recordTime, String actualImei, LocalDateTime timestamp, String imei, String rawCdrFileName, LocalDateTime imeiArrivalTime, String source, String updateRawCdrFileName, LocalDateTime updateImeiArrivalTime, String updateSource, String serverOrigin, String actualOperator, String testImei, String isUsed, Boolean validityFlag, String systemType, String recordType, String deviceType) {
        this.id = id;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.tac = tac;
        this.msisdn = msisdn;
        this.failedRuleId = failedRuleId;
        this.failedRuleName = failedRuleName;
        this.imsi = imsi;
        this.mobileOperator = mobileOperator;
        this.createFilename = createFilename;
        this.updateFilename = updateFilename;
        this.updatedOn = updatedOn;
        this.protocol = protocol;
        this.action = action;
        this.period = period;
        this.failedRuleDate = failedRuleDate;
        this.mobileOperatorId = mobileOperatorId;
        this.taxPaid = taxPaid;
        this.featureName = featureName;
        this.recordTime = recordTime;
        this.actualImei = actualImei;
        this.timestamp = timestamp;
        this.imei = imei;
        this.rawCdrFileName = rawCdrFileName;
        this.imeiArrivalTime = imeiArrivalTime;
        this.source = source;
        this.updateRawCdrFileName = updateRawCdrFileName;
        this.updateImeiArrivalTime = updateImeiArrivalTime;
        this.updateSource = updateSource;
        this.serverOrigin = serverOrigin;
        this.actualOperator = actualOperator;
        this.testImei = testImei;
        this.isUsed = isUsed;
        this.validityFlag = validityFlag;
        this.systemType = systemType;
        this.recordType = recordType;
        this.deviceType = deviceType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getTac() {
        return tac;
    }

    public void setTac(String tac) {
        this.tac = tac;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Integer getFailedRuleId() {
        return failedRuleId;
    }

    public void setFailedRuleId(Integer failedRuleId) {
        this.failedRuleId = failedRuleId;
    }

    public String getFailedRuleName() {
        return failedRuleName;
    }

    public void setFailedRuleName(String failedRuleName) {
        this.failedRuleName = failedRuleName;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getMobileOperator() {
        return mobileOperator;
    }

    public void setMobileOperator(String mobileOperator) {
        this.mobileOperator = mobileOperator;
    }

    public String getCreateFilename() {
        return createFilename;
    }

    public void setCreateFilename(String createFilename) {
        this.createFilename = createFilename;
    }

    public String getUpdateFilename() {
        return updateFilename;
    }

    public void setUpdateFilename(String updateFilename) {
        this.updateFilename = updateFilename;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public LocalDateTime getFailedRuleDate() {
        return failedRuleDate;
    }

    public void setFailedRuleDate(LocalDateTime failedRuleDate) {
        this.failedRuleDate = failedRuleDate;
    }

    public Integer getMobileOperatorId() {
        return mobileOperatorId;
    }

    public void setMobileOperatorId(Integer mobileOperatorId) {
        this.mobileOperatorId = mobileOperatorId;
    }

    public Integer getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(Integer taxPaid) {
        this.taxPaid = taxPaid;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public LocalDateTime getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(LocalDateTime recordTime) {
        this.recordTime = recordTime;
    }

    public String getActualImei() {
        return actualImei;
    }

    public void setActualImei(String actualImei) {
        this.actualImei = actualImei;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getRawCdrFileName() {
        return rawCdrFileName;
    }

    public void setRawCdrFileName(String rawCdrFileName) {
        this.rawCdrFileName = rawCdrFileName;
    }

    public LocalDateTime getImeiArrivalTime() {
        return imeiArrivalTime;
    }

    public void setImeiArrivalTime(LocalDateTime imeiArrivalTime) {
        this.imeiArrivalTime = imeiArrivalTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUpdateRawCdrFileName() {
        return updateRawCdrFileName;
    }

    public void setUpdateRawCdrFileName(String updateRawCdrFileName) {
        this.updateRawCdrFileName = updateRawCdrFileName;
    }

    public LocalDateTime getUpdateImeiArrivalTime() {
        return updateImeiArrivalTime;
    }

    public void setUpdateImeiArrivalTime(LocalDateTime updateImeiArrivalTime) {
        this.updateImeiArrivalTime = updateImeiArrivalTime;
    }

    public String getUpdateSource() {
        return updateSource;
    }

    public void setUpdateSource(String updateSource) {
        this.updateSource = updateSource;
    }

    public String getServerOrigin() {
        return serverOrigin;
    }

    public void setServerOrigin(String serverOrigin) {
        this.serverOrigin = serverOrigin;
    }

    public String getActualOperator() {
        return actualOperator;
    }

    public void setActualOperator(String actualOperator) {
        this.actualOperator = actualOperator;
    }

    public String getTestImei() {
        return testImei;
    }

    public void setTestImei(String testImei) {
        this.testImei = testImei;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    public Boolean getValidityFlag() {
        return validityFlag;
    }

    public void setValidityFlag(Boolean validityFlag) {
        this.validityFlag = validityFlag;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public String toString() {
        return "ActiveForeignImeiWithDifferentImsiDto{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                ", tac='" + tac + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", failedRuleId=" + failedRuleId +
                ", failedRuleName='" + failedRuleName + '\'' +
                ", imsi='" + imsi + '\'' +
                ", mobileOperator='" + mobileOperator + '\'' +
                ", createFilename='" + createFilename + '\'' +
                ", updateFilename='" + updateFilename + '\'' +
                ", updatedOn=" + updatedOn +
                ", protocol='" + protocol + '\'' +
                ", action='" + action + '\'' +
                ", period='" + period + '\'' +
                ", failedRuleDate=" + failedRuleDate +
                ", mobileOperatorId=" + mobileOperatorId +
                ", taxPaid=" + taxPaid +
                ", featureName='" + featureName + '\'' +
                ", recordTime=" + recordTime +
                ", actualImei='" + actualImei + '\'' +
                ", timestamp=" + timestamp +
                ", imei='" + imei + '\'' +
                ", rawCdrFileName='" + rawCdrFileName + '\'' +
                ", imeiArrivalTime=" + imeiArrivalTime +
                ", source='" + source + '\'' +
                ", updateRawCdrFileName='" + updateRawCdrFileName + '\'' +
                ", updateImeiArrivalTime=" + updateImeiArrivalTime +
                ", updateSource='" + updateSource + '\'' +
                ", serverOrigin='" + serverOrigin + '\'' +
                ", actualOperator='" + actualOperator + '\'' +
                ", testImei='" + testImei + '\'' +
                ", isUsed='" + isUsed + '\'' +
                ", validityFlag=" + validityFlag +
                ", systemType='" + systemType + '\'' +
                ", recordType='" + recordType + '\'' +
                ", deviceType='" + deviceType + '\'' +
                '}';
    }

    // fromEntity method to convert from entity to DTO
    public static ActiveForeignImeiWithDifferentImsiDto fromEntityForEdr(ActiveForeignImeiWithDifferentImsi entity) {
        ActiveForeignImeiWithDifferentImsiDto dto = new ActiveForeignImeiWithDifferentImsiDto();
        dto.setId(entity.getId());
        dto.setCreatedOn(entity.getCreatedOn());
        dto.setModifiedOn(entity.getModifiedOn());
        dto.setTac(entity.getTac());
        dto.setMsisdn(entity.getMsisdn());
        dto.setFailedRuleId(entity.getFailedRuleId());
        dto.setFailedRuleName(entity.getFailedRuleName());
        dto.setImsi(entity.getImsi());
        dto.setMobileOperator(entity.getMobileOperator());
        dto.setCreateFilename(entity.getCreateFilename());
        dto.setUpdateFilename(entity.getUpdateFilename());
        dto.setUpdatedOn(entity.getUpdatedOn());
        dto.setProtocol(entity.getProtocol());
        dto.setAction(entity.getAction());
        dto.setPeriod(entity.getPeriod());
        dto.setFailedRuleDate(entity.getFailedRuleDate());
        dto.setMobileOperatorId(entity.getMobileOperatorId());
        dto.setTaxPaid(entity.getTaxPaid());
        dto.setFeatureName(entity.getFeatureName());
        dto.setRecordTime(entity.getRecordTime());
        dto.setActualImei(entity.getActualImei());
        dto.setTimestamp(entity.getTimestamp());
        dto.setImei(entity.getImei());
        dto.setRawCdrFileName(entity.getRawCdrFileName());
        dto.setImeiArrivalTime(entity.getImeiArrivalTime());
        dto.setSource(entity.getSource());
        dto.setUpdateRawCdrFileName(entity.getUpdateRawCdrFileName());
        dto.setUpdateImeiArrivalTime(entity.getUpdateImeiArrivalTime());
        dto.setUpdateSource(entity.getUpdateSource());
        dto.setServerOrigin(entity.getServerOrigin());
        dto.setActualOperator(entity.getActualOperator());
        dto.setTestImei(entity.getTestImei());
        dto.setIsUsed(entity.getIsUsed());
        dto.setValidityFlag(entity.getValidityFlag());
        dto.setDeviceType(entity.getDeviceType());
        return dto;
    }

    // toEntity method to convert from DTO to entity
    public static ActiveForeignImeiWithDifferentImsi toEntityForEdr(ActiveForeignImeiWithDifferentImsiDto dto) {
        ActiveForeignImeiWithDifferentImsi entity = new ActiveForeignImeiWithDifferentImsi();
        entity.setId(dto.getId());
        entity.setCreatedOn(dto.getCreatedOn());
        entity.setModifiedOn(dto.getModifiedOn());
        entity.setTac(dto.getTac());
        entity.setMsisdn(dto.getMsisdn());
        entity.setFailedRuleId(dto.getFailedRuleId());
        entity.setFailedRuleName(dto.getFailedRuleName());
        entity.setImsi(dto.getImsi());
        entity.setMobileOperator(dto.getMobileOperator());
        entity.setCreateFilename(dto.getCreateFilename());
        entity.setUpdateFilename(dto.getUpdateFilename());
        entity.setUpdatedOn(dto.getUpdatedOn());
        entity.setProtocol(dto.getProtocol());
        entity.setAction(dto.getAction());
        entity.setPeriod(dto.getPeriod());
        entity.setFailedRuleDate(dto.getFailedRuleDate());
        entity.setMobileOperatorId(dto.getMobileOperatorId());
        entity.setTaxPaid(dto.getTaxPaid());
        entity.setFeatureName(dto.getFeatureName());
        entity.setRecordTime(dto.getRecordTime());
        entity.setActualImei(dto.getActualImei());
        entity.setTimestamp(dto.getTimestamp());
        entity.setImei(dto.getImei());
        entity.setRawCdrFileName(dto.getRawCdrFileName());
        entity.setImeiArrivalTime(dto.getImeiArrivalTime());
        entity.setSource(dto.getSource());
        entity.setUpdateRawCdrFileName(dto.getUpdateRawCdrFileName());
        entity.setUpdateImeiArrivalTime(dto.getUpdateImeiArrivalTime());
        entity.setUpdateSource(dto.getUpdateSource());
        entity.setServerOrigin(dto.getServerOrigin());
        entity.setActualOperator(dto.getActualOperator());
        entity.setTestImei(dto.getTestImei());
        entity.setIsUsed(dto.getIsUsed());
        return entity;
    }

    public static ActiveForeignImeiWithDifferentImsiDto fromEntityForCdr(ActiveForeignImeiWithDifferentMsisdn entity) {
        ActiveForeignImeiWithDifferentImsiDto dto = new ActiveForeignImeiWithDifferentImsiDto();
        dto.setId(entity.getId());
        dto.setCreatedOn(entity.getCreatedOn());
        dto.setModifiedOn(entity.getModifiedOn());
        dto.setTac(entity.getTac());
        dto.setMsisdn(entity.getMsisdn());
        dto.setFailedRuleId(entity.getFailedRuleId());
        dto.setFailedRuleName(entity.getFailedRuleName());
        dto.setImsi(entity.getImsi());
        dto.setMobileOperator(entity.getMobileOperator());
        dto.setCreateFilename(entity.getCreateFilename());
        dto.setUpdateFilename(entity.getUpdateFilename());
        dto.setUpdatedOn(entity.getUpdatedOn());
        dto.setSystemType(entity.getSystemType());
        dto.setAction(entity.getAction());
        dto.setPeriod(entity.getPeriod());
        dto.setFailedRuleDate(entity.getFailedRuleDate());
        dto.setMobileOperatorId(entity.getMobileOperatorId());
        dto.setTaxPaid(entity.getTaxPaid());
        dto.setFeatureName(entity.getFeatureName());
        dto.setRecordTime(entity.getRecordTime());
        dto.setActualImei(entity.getActualImei());
        dto.setRecordType(entity.getRecordType());
        dto.setImei(entity.getImei());
        dto.setRawCdrFileName(entity.getRawCdrFileName());
        dto.setImeiArrivalTime(entity.getImeiArrivalTime());
        dto.setSource(entity.getSource());
        dto.setUpdateRawCdrFileName(entity.getUpdateRawCdrFileName());
        dto.setUpdateImeiArrivalTime(entity.getUpdateImeiArrivalTime());
        dto.setUpdateSource(entity.getUpdateSource());
        dto.setServerOrigin(entity.getServerOrigin());
        dto.setTestImei(entity.getTestImei());
        dto.setActualOperator(entity.getActualOperator());
        dto.setValidityFlag(entity.getValidityFlag());
        dto.setDeviceType(entity.getDeviceType());
        dto.setIsUsed(entity.getIsUsed());
        return dto;
    }

    public static ActiveImeiWithDifferentMsisdn toEntityForCdr(ActiveForeignImeiWithDifferentImsiDto dto) {
        ActiveImeiWithDifferentMsisdn entity = new ActiveImeiWithDifferentMsisdn();
        entity.setId(dto.getId());
        entity.setCreatedOn(dto.getCreatedOn());
        entity.setModifiedOn(dto.getModifiedOn());
        entity.setTac(dto.getTac());
        entity.setMsisdn(dto.getMsisdn());
        entity.setFailedRuleId(dto.getFailedRuleId());
        entity.setFailedRuleName(dto.getFailedRuleName());
        entity.setImsi(dto.getImsi());
        entity.setMobileOperator(dto.getMobileOperator());
        entity.setCreateFilename(dto.getCreateFilename());
        entity.setUpdateFilename(dto.getUpdateFilename());
        entity.setUpdatedOn(dto.getUpdatedOn());
        entity.setSystemType(dto.getSystemType());
        entity.setAction(dto.getAction());
        entity.setPeriod(dto.getPeriod());
        entity.setFailedRuleDate(dto.getFailedRuleDate());
        entity.setMobileOperatorId(dto.getMobileOperatorId());
        entity.setTaxPaid(dto.getTaxPaid());
        entity.setFeatureName(dto.getFeatureName());
        entity.setRecordTime(dto.getRecordTime());
        entity.setActualImei(dto.getActualImei());
        entity.setRecordType(dto.getRecordType());
        entity.setImei(dto.getImei());
        entity.setRawCdrFileName(dto.getRawCdrFileName());
        entity.setImeiArrivalTime(dto.getImeiArrivalTime());
        entity.setSource(dto.getSource());
        entity.setUpdateRawCdrFileName(dto.getUpdateRawCdrFileName());
        entity.setUpdateImeiArrivalTime(dto.getUpdateImeiArrivalTime());
        entity.setUpdateSource(dto.getUpdateSource());
        entity.setServerOrigin(dto.getServerOrigin());
        entity.setTestImei(dto.getTestImei());
        entity.setActualOperator(dto.getActualOperator());
        entity.setValidityFlag(dto.getValidityFlag());
        entity.setDeviceType(dto.getDeviceType());
        entity.setIsUsed(dto.getIsUsed());
        return entity;
    }

}

