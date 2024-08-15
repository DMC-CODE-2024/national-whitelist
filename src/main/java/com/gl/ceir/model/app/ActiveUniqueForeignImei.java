package com.gl.ceir.model.app;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "active_unique_foreign_imei")
public class ActiveUniqueForeignImei {

    @Id
    private Integer id;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;
    private String foreginRule;
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
    private LocalDateTime failedRuleDate;
    private Integer mobileOperatorId;
    private Integer taxPaid;
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
    private Integer isTypeApproved;
    private String testImei;
    private String actualOperator;
    private String deviceType;
    private String isUsed;
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


    public ActiveUniqueForeignImei() {
    }

    public ActiveUniqueForeignImei(Integer id, LocalDateTime createdOn, LocalDateTime modifiedOn, String foreginRule, String tac, String msisdn, Integer failedRuleId, String failedRuleName, String imsi, String mobileOperator, String createFilename, String updateFilename, LocalDateTime updatedOn, String systemType, String action, String period, LocalDateTime failedRuleDate, Integer mobileOperatorId, Integer taxPaid, String featureName, LocalDateTime recordTime, String actualImei, String recordType, String imei, String rawCdrFileName, LocalDateTime imeiArrivalTime, String source, String updateRawCdrFileName, LocalDateTime updateImeiArrivalTime, String updateSource, String serverOrigin, Boolean validityFlag, Integer isTypeApproved, String testImei, String actualOperator, String deviceType, String isUsed, String reason, Integer gdceImeiStatus, LocalDateTime gdceModifiedTime, Integer trcImeiStatus, LocalDateTime trcModifiedTime, Integer customsStatus, Integer localManufacturerStatus) {
        this.id = id;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.foreginRule = foreginRule;
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
        this.failedRuleDate = failedRuleDate;
        this.mobileOperatorId = mobileOperatorId;
        this.taxPaid = taxPaid;
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
        this.isTypeApproved = isTypeApproved;
        this.testImei = testImei;
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

    public String getForeginRule() {
        return foreginRule;
    }

    public void setForeginRule(String foreginRule) {
        this.foreginRule = foreginRule;
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

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
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

    public Boolean getValidityFlag() {
        return validityFlag;
    }

    public void setValidityFlag(Boolean validityFlag) {
        this.validityFlag = validityFlag;
    }

    public Integer getIsTypeApproved() {
        return isTypeApproved;
    }

    public void setIsTypeApproved(Integer isTypeApproved) {
        this.isTypeApproved = isTypeApproved;
    }

    public String getTestImei() {
        return testImei;
    }

    public void setTestImei(String testImei) {
        this.testImei = testImei;
    }

    public String getActualOperator() {
        return actualOperator;
    }

    public void setActualOperator(String actualOperator) {
        this.actualOperator = actualOperator;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public Integer getCustomsStatus() {
        return customsStatus;
    }

    public void setCustomsStatus(Integer customsStatus) {
        this.customsStatus = customsStatus;
    }

    public Integer getLocalManufacturerStatus() {
        return localManufacturerStatus;
    }

    public void setLocalManufacturerStatus(Integer localManufacturerStatus) {
        this.localManufacturerStatus = localManufacturerStatus;
    }

    @Override
    public String toString() {
        return "ActiveUniqueForeignImei{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                ", foreginRule='" + foreginRule + '\'' +
                ", tac='" + tac + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", failedRuleId=" + failedRuleId +
                ", failedRuleName='" + failedRuleName + '\'' +
                ", imsi='" + imsi + '\'' +
                ", mobileOperator='" + mobileOperator + '\'' +
                ", createFilename='" + createFilename + '\'' +
                ", updateFilename='" + updateFilename + '\'' +
                ", updatedOn=" + updatedOn +
                ", systemType='" + systemType + '\'' +
                ", action='" + action + '\'' +
                ", period='" + period + '\'' +
                ", failedRuleDate=" + failedRuleDate +
                ", mobileOperatorId=" + mobileOperatorId +
                ", taxPaid=" + taxPaid +
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
                ", validityFlag=" + validityFlag +
                ", isTypeApproved=" + isTypeApproved +
                ", testImei='" + testImei + '\'' +
                ", actualOperator='" + actualOperator + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", isUsed='" + isUsed + '\'' +
                ", reason='" + reason + '\'' +
                ", gdceImeiStatus=" + gdceImeiStatus +
                ", gdceModifiedTime=" + gdceModifiedTime +
                ", trcImeiStatus=" + trcImeiStatus +
                ", trcModifiedTime=" + trcModifiedTime +
                ", customsStatus=" + customsStatus +
                ", localManufacturerStatus=" + localManufacturerStatus +
                '}';
    }
}
