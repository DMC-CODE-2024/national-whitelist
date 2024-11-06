package com.gl.ceir.model.app;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.time.LocalDateTime;

@Entity
@Table(name = "active_unique_foreign_imei", schema = "app")
public class ActiveUniqueForeignImei {
    @Id
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

    private String systemType;

    private String action;

    private String period;

    private String featureName;

    private LocalDateTime recordTime;

    private String actualImei;

    private String recordType;

    private String imei;

    private String rawCdrFileName;

    private LocalDateTime imeiArrivalTime;

    private String source;

    private String updateRawCdrFileName;

    private LocalDateTime updateImeiArrivalTime;

    private String updateSource;

    private String serverOrigin;

    private Boolean validityFlag;

    private Integer isTestImei;

    private String actualOperator;

    private String deviceType;

    private Integer isUsed;

    @Transient
    private String reason;

    @Transient
    private Integer gdceImeiStatus;

    @Transient
    private LocalDateTime gdceModifiedTime;

    @Transient
    private Integer trcImeiStatus;

    @Transient
    private LocalDateTime trcModifiedTime;

    @Transient
    private Integer customsStatus;

    @Transient
    private Integer localManufacturerStatus;

    public ActiveUniqueForeignImei() {}

    public ActiveUniqueForeignImei(Integer id, LocalDateTime createdOn, LocalDateTime modifiedOn, String tac, String msisdn, Integer failedRuleId, String failedRuleName, String imsi, String mobileOperator, String createFilename, String updateFilename, LocalDateTime updatedOn, String systemType, String action, String period, String featureName, LocalDateTime recordTime, String actualImei, String recordType, String imei, String rawCdrFileName, LocalDateTime imeiArrivalTime, String source, String updateRawCdrFileName, LocalDateTime updateImeiArrivalTime, String updateSource, String serverOrigin, Boolean validityFlag, Integer isTestImei, String actualOperator, String deviceType, Integer isUsed, String reason, Integer gdceImeiStatus, LocalDateTime gdceModifiedTime, Integer trcImeiStatus, LocalDateTime trcModifiedTime, Integer customsStatus, Integer localManufacturerStatus) {
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
        this.systemType = systemType;
        this.action = action;
        this.period = period;
        this.featureName = featureName;
        this.recordTime = recordTime;
        this.actualImei = actualImei;
        this.recordType = recordType;
        this.imei = imei;
        this.rawCdrFileName = rawCdrFileName;
        this.imeiArrivalTime = imeiArrivalTime;
        this.source = source;
        this.updateRawCdrFileName = updateRawCdrFileName;
        this.updateImeiArrivalTime = updateImeiArrivalTime;
        this.updateSource = updateSource;
        this.serverOrigin = serverOrigin;
        this.validityFlag = validityFlag;
        this.isTestImei = isTestImei;
        this.actualOperator = actualOperator;
        this.deviceType = deviceType;
        this.isUsed = isUsed;
        this.reason = reason;
        this.gdceImeiStatus = gdceImeiStatus;
        this.gdceModifiedTime = gdceModifiedTime;
        this.trcImeiStatus = trcImeiStatus;
        this.trcModifiedTime = trcModifiedTime;
        this.customsStatus = customsStatus;
        this.localManufacturerStatus = localManufacturerStatus;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getModifiedOn() {
        return this.modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getTac() {
        return this.tac;
    }

    public void setTac(String tac) {
        this.tac = tac;
    }

    public String getMsisdn() {
        return this.msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Integer getFailedRuleId() {
        return this.failedRuleId;
    }

    public void setFailedRuleId(Integer failedRuleId) {
        this.failedRuleId = failedRuleId;
    }

    public String getFailedRuleName() {
        return this.failedRuleName;
    }

    public void setFailedRuleName(String failedRuleName) {
        this.failedRuleName = failedRuleName;
    }

    public String getImsi() {
        return this.imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getMobileOperator() {
        return this.mobileOperator;
    }

    public void setMobileOperator(String mobileOperator) {
        this.mobileOperator = mobileOperator;
    }

    public String getCreateFilename() {
        return this.createFilename;
    }

    public void setCreateFilename(String createFilename) {
        this.createFilename = createFilename;
    }

    public String getUpdateFilename() {
        return this.updateFilename;
    }

    public void setUpdateFilename(String updateFilename) {
        this.updateFilename = updateFilename;
    }

    public LocalDateTime getUpdatedOn() {
        return this.updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getSystemType() {
        return this.systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPeriod() {
        return this.period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getFeatureName() {
        return this.featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public LocalDateTime getRecordTime() {
        return this.recordTime;
    }

    public void setRecordTime(LocalDateTime recordTime) {
        this.recordTime = recordTime;
    }

    public String getActualImei() {
        return this.actualImei;
    }

    public void setActualImei(String actualImei) {
        this.actualImei = actualImei;
    }

    public String getRecordType() {
        return this.recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getRawCdrFileName() {
        return this.rawCdrFileName;
    }

    public void setRawCdrFileName(String rawCdrFileName) {
        this.rawCdrFileName = rawCdrFileName;
    }

    public LocalDateTime getImeiArrivalTime() {
        return this.imeiArrivalTime;
    }

    public void setImeiArrivalTime(LocalDateTime imeiArrivalTime) {
        this.imeiArrivalTime = imeiArrivalTime;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUpdateRawCdrFileName() {
        return this.updateRawCdrFileName;
    }

    public void setUpdateRawCdrFileName(String updateRawCdrFileName) {
        this.updateRawCdrFileName = updateRawCdrFileName;
    }

    public LocalDateTime getUpdateImeiArrivalTime() {
        return this.updateImeiArrivalTime;
    }

    public void setUpdateImeiArrivalTime(LocalDateTime updateImeiArrivalTime) {
        this.updateImeiArrivalTime = updateImeiArrivalTime;
    }

    public String getUpdateSource() {
        return this.updateSource;
    }

    public void setUpdateSource(String updateSource) {
        this.updateSource = updateSource;
    }

    public String getServerOrigin() {
        return this.serverOrigin;
    }

    public void setServerOrigin(String serverOrigin) {
        this.serverOrigin = serverOrigin;
    }

    public Boolean getValidityFlag() {
        return this.validityFlag;
    }

    public void setValidityFlag(Boolean validityFlag) {
        this.validityFlag = validityFlag;
    }

    public Integer getIsTestImei() {
        return this.isTestImei;
    }

    public void setIsTestImei(Integer isTestImei) {
        this.isTestImei = isTestImei;
    }

    public String getActualOperator() {
        return this.actualOperator;
    }

    public void setActualOperator(String actualOperator) {
        this.actualOperator = actualOperator;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getIsUsed() {
        return this.isUsed;
    }

    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getGdceImeiStatus() {
        return this.gdceImeiStatus;
    }

    public void setGdceImeiStatus(Integer gdceImeiStatus) {
        this.gdceImeiStatus = gdceImeiStatus;
    }

    public LocalDateTime getGdceModifiedTime() {
        return this.gdceModifiedTime;
    }

    public void setGdceModifiedTime(LocalDateTime gdceModifiedTime) {
        this.gdceModifiedTime = gdceModifiedTime;
    }

    public Integer getTrcImeiStatus() {
        return this.trcImeiStatus;
    }

    public void setTrcImeiStatus(Integer trcImeiStatus) {
        this.trcImeiStatus = trcImeiStatus;
    }

    public LocalDateTime getTrcModifiedTime() {
        return this.trcModifiedTime;
    }

    public void setTrcModifiedTime(LocalDateTime trcModifiedTime) {
        this.trcModifiedTime = trcModifiedTime;
    }

    public Integer getCustomsStatus() {
        return this.customsStatus;
    }

    public void setCustomsStatus(Integer customsStatus) {
        this.customsStatus = customsStatus;
    }

    public Integer getLocalManufacturerStatus() {
        return this.localManufacturerStatus;
    }

    public void setLocalManufacturerStatus(Integer localManufacturerStatus) {
        this.localManufacturerStatus = localManufacturerStatus;
    }

    public String toString() {
        return "ActiveUniqueForeignImei{id=" + this.id + ", createdOn=" + String.valueOf(this.createdOn) + ", modifiedOn=" + String.valueOf(this.modifiedOn) + ", tac='" + this.tac + "', msisdn='" + this.msisdn + "', failedRuleId=" + this.failedRuleId + ", failedRuleName='" + this.failedRuleName + "', imsi='" + this.imsi + "', mobileOperator='" + this.mobileOperator + "', createFilename='" + this.createFilename + "', updateFilename='" + this.updateFilename + "', updatedOn=" + String.valueOf(this.updatedOn) + ", systemType='" + this.systemType + "', action='" + this.action + "', period='" + this.period + "', featureName='" + this.featureName + "', recordTime=" + String.valueOf(this.recordTime) + ", actualImei='" + this.actualImei + "', recordType='" + this.recordType + "', imei='" + this.imei + "', rawCdrFileName='" + this.rawCdrFileName + "', imeiArrivalTime=" + String.valueOf(this.imeiArrivalTime) + ", source='" + this.source + "', updateRawCdrFileName='" + this.updateRawCdrFileName + "', updateImeiArrivalTime=" + String.valueOf(this.updateImeiArrivalTime) + ", updateSource='" + this.updateSource + "', serverOrigin='" + this.serverOrigin + "', validityFlag=" + this.validityFlag + ", isTestImei=" + this.isTestImei + ", actualOperator='" + this.actualOperator + "', deviceType='" + this.deviceType + "', isUsed=" + this.isUsed + ", reason='" + this.reason + "', gdceImeiStatus=" + this.gdceImeiStatus + ", gdceModifiedTime=" + String.valueOf(this.gdceModifiedTime) + ", trcImeiStatus=" + this.trcImeiStatus + ", trcModifiedTime=" + String.valueOf(this.trcModifiedTime) + ", customsStatus=" + this.customsStatus + ", localManufacturerStatus=" + this.localManufacturerStatus + "}";
    }
}
