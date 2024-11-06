package com.gl.ceir.model.output;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "foreign_exception_list")
public class ForeignExceptionList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foreignExceptionListId;

    private LocalDateTime createdOn;

    private LocalDateTime modifiedOn;

    private String tac;

    private String msisdn;

    private Integer failedRuleId;

    private String failedRuleName;

    private String imsi;

    private String mobileOperator;

    private String createdFilename;

    private String updatedFilename;

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

    private String reasonForInvalidImei;

    private Boolean validityFlag;

    private LocalDateTime exceptionListCreatedDate;

    private String deviceType;

    private String actualOperator;

    private Integer isTestImei;

    private String listType;

    private Integer isUsedDeviceImei;

    public ForeignExceptionList() {}

    public ForeignExceptionList(Integer foreignExceptionListId, LocalDateTime createdOn, LocalDateTime modifiedOn, String tac, String msisdn, Integer failedRuleId, String failedRuleName, String imsi, String mobileOperator, String createdFilename, String updatedFilename, LocalDateTime updatedOn, String systemType, String action, String period, String featureName, LocalDateTime recordTime, String actualImei, String recordType, String imei, String rawCdrFileName, LocalDateTime imeiArrivalTime, String source, String updateRawCdrFileName, LocalDateTime updateImeiArrivalTime, String updateSource, String serverOrigin, String reasonForInvalidImei, Boolean validityFlag, LocalDateTime exceptionListCreatedDate, String deviceType, String actualOperator, Integer isTestImei, String listType, Integer isUsedDeviceImei) {
        this.foreignExceptionListId = foreignExceptionListId;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.tac = tac;
        this.msisdn = msisdn;
        this.failedRuleId = failedRuleId;
        this.failedRuleName = failedRuleName;
        this.imsi = imsi;
        this.mobileOperator = mobileOperator;
        this.createdFilename = createdFilename;
        this.updatedFilename = updatedFilename;
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
        this.reasonForInvalidImei = reasonForInvalidImei;
        this.validityFlag = validityFlag;
        this.exceptionListCreatedDate = exceptionListCreatedDate;
        this.deviceType = deviceType;
        this.actualOperator = actualOperator;
        this.isTestImei = isTestImei;
        this.listType = listType;
        this.isUsedDeviceImei = isUsedDeviceImei;
    }

    public Integer getForeignExceptionListId() {
        return this.foreignExceptionListId;
    }

    public void setForeignExceptionListId(Integer foreignExceptionListId) {
        this.foreignExceptionListId = foreignExceptionListId;
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

    public String getReasonForInvalidImei() {
        return this.reasonForInvalidImei;
    }

    public void setReasonForInvalidImei(String reasonForInvalidImei) {
        this.reasonForInvalidImei = reasonForInvalidImei;
    }

    public Boolean getValidityFlag() {
        return this.validityFlag;
    }

    public void setValidityFlag(Boolean validityFlag) {
        this.validityFlag = validityFlag;
    }

    public LocalDateTime getExceptionListCreatedDate() {
        return this.exceptionListCreatedDate;
    }

    public void setExceptionListCreatedDate(LocalDateTime exceptionListCreatedDate) {
        this.exceptionListCreatedDate = exceptionListCreatedDate;
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

    public String getListType() {
        return this.listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public Integer getIsUsedDeviceImei() {
        return this.isUsedDeviceImei;
    }

    public void setIsUsedDeviceImei(Integer isUsedDeviceImei) {
        this.isUsedDeviceImei = isUsedDeviceImei;
    }

    public String toString() {
        return "ForeignExceptionList{foreignExceptionListId=" + this.foreignExceptionListId + ", createdOn=" + String.valueOf(this.createdOn) + ", modifiedOn=" + String.valueOf(this.modifiedOn) + ", tac='" + this.tac + "', msisdn='" + this.msisdn + "', failedRuleId=" + this.failedRuleId + ", failedRuleName='" + this.failedRuleName + "', imsi='" + this.imsi + "', mobileOperator='" + this.mobileOperator + "', createdFilename='" + this.createdFilename + "', updatedFilename='" + this.updatedFilename + "', updatedOn=" + String.valueOf(this.updatedOn) + ", systemType='" + this.systemType + "', action='" + this.action + "', period='" + this.period + "', featureName='" + this.featureName + "', recordTime=" + String.valueOf(this.recordTime) + ", actualImei='" + this.actualImei + "', recordType='" + this.recordType + "', imei='" + this.imei + "', rawCdrFileName='" + this.rawCdrFileName + "', imeiArrivalTime=" + String.valueOf(this.imeiArrivalTime) + ", source='" + this.source + "', updateRawCdrFileName='" + this.updateRawCdrFileName + "', updateImeiArrivalTime=" + String.valueOf(this.updateImeiArrivalTime) + ", updateSource='" + this.updateSource + "', serverOrigin='" + this.serverOrigin + "', reasonForInvalidImei='" + this.reasonForInvalidImei + "', validityFlag=" + this.validityFlag + ", exceptionListCreatedDate=" + String.valueOf(this.exceptionListCreatedDate) + ", deviceType='" + this.deviceType + "', actualOperator='" + this.actualOperator + "', isTestImei=" + this.isTestImei + ", listType='" + this.listType + "', isUsedDeviceImei=" + this.isUsedDeviceImei + "}";
    }
}
