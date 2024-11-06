package com.gl.ceir.model.output;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "national_whitelist")
public class NationalWhitelist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nationalWhitelistId;

    private LocalDateTime createdOn;

    private LocalDateTime modifiedOn;

    private String mobileOperator;

    private String period;

    private String createdFilename;

    private String updatedFilename;

    private LocalDateTime updatedOn;

    private String systemType;

    private Integer failedRuleId;

    private String failedRuleName;

    private Boolean validityFlag;

    private String tac;

    private String action;

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

    private String listType;

    private String reasonForInvalidImei;

    private String imsi;

    private String msisdn;

    private LocalDate createdOnDate;

    private String deviceType;

    private String actualOperator;

    private Integer isTestImei;

    private Integer isUsedDeviceImei;

    private LocalDateTime nationalWhiteListCreatedDate;

    private Integer gdceImeiStatus;

    private LocalDateTime gdceModifiedTime;

    private Integer trcImeiStatus;

    private LocalDateTime trcModifiedTime;

    private LocalDateTime timestamp;

    private String protocol;

    public NationalWhitelist() {}

    public NationalWhitelist(Integer nationalWhitelistId, LocalDateTime createdOn, LocalDateTime modifiedOn, String mobileOperator, String period, String createdFilename, String updatedFilename, LocalDateTime updatedOn, String systemType, Integer failedRuleId, String failedRuleName, Boolean validityFlag, String tac, String action, String featureName, LocalDateTime recordTime, String actualImei, String recordType, String imei, String rawCdrFileName, LocalDateTime imeiArrivalTime, String source, String updateRawCdrFileName, LocalDateTime updateImeiArrivalTime, String updateSource, String serverOrigin, String listType, String reasonForInvalidImei, String imsi, String msisdn, LocalDate createdOnDate, String deviceType, String actualOperator, Integer isTestImei, Integer isUsedDeviceImei, LocalDateTime nationalWhiteListCreatedDate, Integer gdceImeiStatus, LocalDateTime gdceModifiedTime, Integer trcImeiStatus, LocalDateTime trcModifiedTime, LocalDateTime timestamp, String protocol) {
        this.nationalWhitelistId = nationalWhitelistId;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.mobileOperator = mobileOperator;
        this.period = period;
        this.createdFilename = createdFilename;
        this.updatedFilename = updatedFilename;
        this.updatedOn = updatedOn;
        this.systemType = systemType;
        this.failedRuleId = failedRuleId;
        this.failedRuleName = failedRuleName;
        this.validityFlag = validityFlag;
        this.tac = tac;
        this.action = action;
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
        this.listType = listType;
        this.reasonForInvalidImei = reasonForInvalidImei;
        this.imsi = imsi;
        this.msisdn = msisdn;
        this.createdOnDate = createdOnDate;
        this.deviceType = deviceType;
        this.actualOperator = actualOperator;
        this.isTestImei = isTestImei;
        this.isUsedDeviceImei = isUsedDeviceImei;
        this.nationalWhiteListCreatedDate = nationalWhiteListCreatedDate;
        this.gdceImeiStatus = gdceImeiStatus;
        this.gdceModifiedTime = gdceModifiedTime;
        this.trcImeiStatus = trcImeiStatus;
        this.trcModifiedTime = trcModifiedTime;
        this.timestamp = timestamp;
        this.protocol = protocol;
    }

    public Integer getNationalWhitelistId() {
        return this.nationalWhitelistId;
    }

    public void setNationalWhitelistId(Integer nationalWhitelistId) {
        this.nationalWhitelistId = nationalWhitelistId;
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

    public String getMobileOperator() {
        return this.mobileOperator;
    }

    public void setMobileOperator(String mobileOperator) {
        this.mobileOperator = mobileOperator;
    }

    public String getPeriod() {
        return this.period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCreatedFilename() {
        return this.createdFilename;
    }

    public void setCreatedFilename(String createdFilename) {
        this.createdFilename = createdFilename;
    }

    public String getUpdatedFilename() {
        return this.updatedFilename;
    }

    public void setUpdatedFilename(String updatedFilename) {
        this.updatedFilename = updatedFilename;
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

    public Boolean getValidityFlag() {
        return this.validityFlag;
    }

    public void setValidityFlag(Boolean validityFlag) {
        this.validityFlag = validityFlag;
    }

    public String getTac() {
        return this.tac;
    }

    public void setTac(String tac) {
        this.tac = tac;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
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

    public String getListType() {
        return this.listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getReasonForInvalidImei() {
        return this.reasonForInvalidImei;
    }

    public void setReasonForInvalidImei(String reasonForInvalidImei) {
        this.reasonForInvalidImei = reasonForInvalidImei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getMsisdn() {
        return this.msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public LocalDate getCreatedOnDate() {
        return this.createdOnDate;
    }

    public void setCreatedOnDate(LocalDate createdOnDate) {
        this.createdOnDate = createdOnDate;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getActualOperator() {
        return this.actualOperator;
    }

    public void setActualOperator(String actualOperator) {
        this.actualOperator = actualOperator;
    }

    public Integer getIsTestImei() {
        return this.isTestImei;
    }

    public void setIsTestImei(Integer isTestImei) {
        this.isTestImei = isTestImei;
    }

    public Integer getIsUsedDeviceImei() {
        return this.isUsedDeviceImei;
    }

    public void setIsUsedDeviceImei(Integer isUsedDeviceImei) {
        this.isUsedDeviceImei = isUsedDeviceImei;
    }

    public LocalDateTime getNationalWhiteListCreatedDate() {
        return this.nationalWhiteListCreatedDate;
    }

    public void setNationalWhiteListCreatedDate(LocalDateTime nationalWhiteListCreatedDate) {
        this.nationalWhiteListCreatedDate = nationalWhiteListCreatedDate;
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

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String toString() {
        return "NationalWhitelist{nationalWhitelistId=" + this.nationalWhitelistId + ", createdOn=" + String.valueOf(this.createdOn) + ", modifiedOn=" + String.valueOf(this.modifiedOn) + ", mobileOperator='" + this.mobileOperator + "', period='" + this.period + "', createdFilename='" + this.createdFilename + "', updatedFilename='" + this.updatedFilename + "', updatedOn=" + String.valueOf(this.updatedOn) + ", systemType='" + this.systemType + "', failedRuleId=" + this.failedRuleId + ", failedRuleName='" + this.failedRuleName + "', validityFlag=" + this.validityFlag + ", tac='" + this.tac + "', action='" + this.action + "', featureName='" + this.featureName + "', recordTime=" + String.valueOf(this.recordTime) + ", actualImei='" + this.actualImei + "', recordType='" + this.recordType + "', imei='" + this.imei + "', rawCdrFileName='" + this.rawCdrFileName + "', imeiArrivalTime=" + String.valueOf(this.imeiArrivalTime) + ", source='" + this.source + "', updateRawCdrFileName='" + this.updateRawCdrFileName + "', updateImeiArrivalTime=" + String.valueOf(this.updateImeiArrivalTime) + ", updateSource='" + this.updateSource + "', serverOrigin='" + this.serverOrigin + "', listType='" + this.listType + "', reasonForInvalidImei='" + this.reasonForInvalidImei + "', imsi='" + this.imsi + "', msisdn='" + this.msisdn + "', createdOnDate=" + String.valueOf(this.createdOnDate) + ", deviceType='" + this.deviceType + "', actualOperator='" + this.actualOperator + "', isTestImei=" + this.isTestImei + ", isUsedDeviceImei=" + this.isUsedDeviceImei + ", nationalWhiteListCreatedDate=" + String.valueOf(this.nationalWhiteListCreatedDate) + ", gdceImeiStatus=" + this.gdceImeiStatus + ", gdceModifiedTime=" + String.valueOf(this.gdceModifiedTime) + ", trcImeiStatus=" + this.trcImeiStatus + ", trcModifiedTime=" + String.valueOf(this.trcModifiedTime) + ", timestamp=" + String.valueOf(this.timestamp) + ", protocol='" + this.protocol + "'}";
    }
}
