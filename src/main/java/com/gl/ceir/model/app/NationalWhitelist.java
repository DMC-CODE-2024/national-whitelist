package com.gl.ceir.model.app;

import javax.persistence.*;
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
    private String foreignRule;
    private String mobileOperator;
    private String period;
    private String taxPaid;
    private String createdFilename;
    private String updatedFilename;
    private LocalDateTime updatedOn;
    private String systemType;
    private Integer failedRuleId;
    private String failedRuleName;
    private Boolean validityFlag;
    private String tac;
    private String action;
    private LocalDateTime failedRuleDate;
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
    private String isTestImei;
    private String isUsedDeviceImei;
    private LocalDateTime nationalWhiteListCreatedDate;
    private Integer gdceImeiStatus;
    private LocalDateTime gdceModifiedTime;
    private Integer trcImeiStatus;
    private LocalDateTime trcModifiedTime;

    public NationalWhitelist() {
    }

    public NationalWhitelist(Integer nationalWhitelistId, LocalDateTime createdOn, LocalDateTime modifiedOn, String foreignRule, String mobileOperator, String period, String taxPaid, String createdFilename, String updatedFilename, LocalDateTime updatedOn, String systemType, Integer failedRuleId, String failedRuleName, Boolean validityFlag, String tac, String action, LocalDateTime failedRuleDate, String featureName, LocalDateTime recordTime, String actualImei, String recordType, String imei, String rawCdrFileName, LocalDateTime imeiArrivalTime, String source, String updateRawCdrFileName, LocalDateTime updateImeiArrivalTime, String updateSource, String serverOrigin, String listType, String reasonForInvalidImei, String imsi, String msisdn, LocalDate createdOnDate, String deviceType, String actualOperator, String isTestImei, String isUsedDeviceImei, LocalDateTime nationalWhiteListCreatedDate, Integer gdceImeiStatus, LocalDateTime gdceModifiedTime, Integer trcImeiStatus, LocalDateTime trcModifiedTime) {
        this.nationalWhitelistId = nationalWhitelistId;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.foreignRule = foreignRule;
        this.mobileOperator = mobileOperator;
        this.period = period;
        this.taxPaid = taxPaid;
        this.createdFilename = createdFilename;
        this.updatedFilename = updatedFilename;
        this.updatedOn = updatedOn;
        this.systemType = systemType;
        this.failedRuleId = failedRuleId;
        this.failedRuleName = failedRuleName;
        this.validityFlag = validityFlag;
        this.tac = tac;
        this.action = action;
        this.failedRuleDate = failedRuleDate;
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
    }

    public Integer getNationalWhitelistId() {
        return nationalWhitelistId;
    }

    public void setNationalWhitelistId(Integer nationalWhitelistId) {
        this.nationalWhitelistId = nationalWhitelistId;
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

    public String getForeignRule() {
        return foreignRule;
    }

    public void setForeignRule(String foreignRule) {
        this.foreignRule = foreignRule;
    }

    public String getMobileOperator() {
        return mobileOperator;
    }

    public void setMobileOperator(String mobileOperator) {
        this.mobileOperator = mobileOperator;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTaxPaid() {
        return taxPaid;
    }

    public void setTaxPaid(String taxPaid) {
        this.taxPaid = taxPaid;
    }

    public String getCreatedFilename() {
        return createdFilename;
    }

    public void setCreatedFilename(String createdFilename) {
        this.createdFilename = createdFilename;
    }

    public String getUpdatedFilename() {
        return updatedFilename;
    }

    public void setUpdatedFilename(String updatedFilename) {
        this.updatedFilename = updatedFilename;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
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

    public Boolean getValidityFlag() {
        return validityFlag;
    }

    public void setValidityFlag(Boolean validityFlag) {
        this.validityFlag = validityFlag;
    }

    public String getTac() {
        return tac;
    }

    public void setTac(String tac) {
        this.tac = tac;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getFailedRuleDate() {
        return failedRuleDate;
    }

    public void setFailedRuleDate(LocalDateTime failedRuleDate) {
        this.failedRuleDate = failedRuleDate;
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

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
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

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getReasonForInvalidImei() {
        return reasonForInvalidImei;
    }

    public void setReasonForInvalidImei(String reasonForInvalidImei) {
        this.reasonForInvalidImei = reasonForInvalidImei;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public LocalDate getCreatedOnDate() {
        return createdOnDate;
    }

    public void setCreatedOnDate(LocalDate createdOnDate) {
        this.createdOnDate = createdOnDate;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getActualOperator() {
        return actualOperator;
    }

    public void setActualOperator(String actualOperator) {
        this.actualOperator = actualOperator;
    }

    public String getIsTestImei() {
        return isTestImei;
    }

    public void setIsTestImei(String isTestImei) {
        this.isTestImei = isTestImei;
    }

    public String getIsUsedDeviceImei() {
        return isUsedDeviceImei;
    }

    public void setIsUsedDeviceImei(String isUsedDeviceImei) {
        this.isUsedDeviceImei = isUsedDeviceImei;
    }

    public LocalDateTime getNationalWhiteListCreatedDate() {
        return nationalWhiteListCreatedDate;
    }

    public void setNationalWhiteListCreatedDate(LocalDateTime nationalWhiteListCreatedDate) {
        this.nationalWhiteListCreatedDate = nationalWhiteListCreatedDate;
    }

    public Integer getGdceImeiStatus() {
        return gdceImeiStatus;
    }

    public void setGdceImeiStatus(Integer gdceImeiStatus) {
        this.gdceImeiStatus = gdceImeiStatus;
    }

    public LocalDateTime getGdceModifiedTime() {
        return gdceModifiedTime;
    }

    public void setGdceModifiedTime(LocalDateTime gdceModifiedTime) {
        this.gdceModifiedTime = gdceModifiedTime;
    }

    public Integer getTrcImeiStatus() {
        return trcImeiStatus;
    }

    public void setTrcImeiStatus(Integer trcImeiStatus) {
        this.trcImeiStatus = trcImeiStatus;
    }

    public LocalDateTime getTrcModifiedTime() {
        return trcModifiedTime;
    }

    public void setTrcModifiedTime(LocalDateTime trcModifiedTime) {
        this.trcModifiedTime = trcModifiedTime;
    }

    @Override
    public String toString() {
        return "NationalWhitelist{" +
                "nationalWhitelistId=" + nationalWhitelistId +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                ", foreignRule='" + foreignRule + '\'' +
                ", mobileOperator='" + mobileOperator + '\'' +
                ", period='" + period + '\'' +
                ", taxPaid='" + taxPaid + '\'' +
                ", createdFilename='" + createdFilename + '\'' +
                ", updatedFilename='" + updatedFilename + '\'' +
                ", updatedOn=" + updatedOn +
                ", systemType='" + systemType + '\'' +
                ", failedRuleId=" + failedRuleId +
                ", failedRuleName='" + failedRuleName + '\'' +
                ", validityFlag=" + validityFlag +
                ", tac='" + tac + '\'' +
                ", action='" + action + '\'' +
                ", failedRuleDate=" + failedRuleDate +
                ", featureName='" + featureName + '\'' +
                ", recordTime=" + recordTime +
                ", actualImei='" + actualImei + '\'' +
                ", recordType='" + recordType + '\'' +
                ", imei='" + imei + '\'' +
                ", rawCdrFileName='" + rawCdrFileName + '\'' +
                ", imeiArrivalTime=" + imeiArrivalTime +
                ", source='" + source + '\'' +
                ", updateRawCdrFileName='" + updateRawCdrFileName + '\'' +
                ", updateImeiArrivalTime=" + updateImeiArrivalTime +
                ", updateSource='" + updateSource + '\'' +
                ", serverOrigin='" + serverOrigin + '\'' +
                ", listType='" + listType + '\'' +
                ", reasonForInvalidImei='" + reasonForInvalidImei + '\'' +
                ", imsi='" + imsi + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", createdOnDate=" + createdOnDate +
                ", deviceType='" + deviceType + '\'' +
                ", actualOperator='" + actualOperator + '\'' +
                ", isTestImei='" + isTestImei + '\'' +
                ", isUsedDeviceImei='" + isUsedDeviceImei + '\'' +
                ", nationalWhiteListCreatedDate=" + nationalWhiteListCreatedDate +
                ", gdceImeiStatus=" + gdceImeiStatus +
                ", gdceModifiedTime=" + gdceModifiedTime +
                ", trcImeiStatus=" + trcImeiStatus +
                ", trcModifiedTime=" + trcModifiedTime +
                '}';
    }
}

