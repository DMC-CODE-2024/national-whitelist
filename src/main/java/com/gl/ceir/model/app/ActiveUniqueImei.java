package com.gl.ceir.model.app;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "active_unique_imei")
public class ActiveUniqueImei implements Serializable{

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
    private boolean validityFlag;
    private String actualOperator;
    private String testImei;
    private String deviceType;
    private String isUsed;
    @Transient
    private String reason;


    public ActiveUniqueImei() {
    }

    public ActiveUniqueImei(Integer id, LocalDateTime createdOn, LocalDateTime modifiedOn, String foreginRule, String tac, String msisdn, Integer failedRuleId, String failedRuleName, String imsi, String mobileOperator, String createFilename, String updateFilename, LocalDateTime updatedOn, String systemType, String action, String period, LocalDateTime failedRuleDate, Integer mobileOperatorId, Integer taxPaid, String featureName, LocalDateTime recordTime, String actualImei, String recordType, String imei, String rawCdrFileName, LocalDateTime imeiArrivalTime, String source, String updateRawCdrFileName, LocalDateTime updateImeiArrivalTime, String updateSource, String serverOrigin, boolean validityFlag, String actualOperator, String testImei, String deviceType, String isUsed, String reason) {
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
        this.actualOperator = actualOperator;
        this.testImei = testImei;
        this.deviceType = deviceType;
        this.isUsed = isUsed;
        this.reason = reason;
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

    public boolean isValidityFlag() {
        return validityFlag;
    }

    public void setValidityFlag(boolean validityFlag) {
        this.validityFlag = validityFlag;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ActiveUniqueImei{");
        sb.append("id=").append(id);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", modifiedOn=").append(modifiedOn);
        sb.append(", foreginRule='").append(foreginRule).append('\'');
        sb.append(", tac='").append(tac).append('\'');
        sb.append(", msisdn='").append(msisdn).append('\'');
        sb.append(", failedRuleId=").append(failedRuleId);
        sb.append(", failedRuleName='").append(failedRuleName).append('\'');
        sb.append(", imsi='").append(imsi).append('\'');
        sb.append(", mobileOperator='").append(mobileOperator).append('\'');
        sb.append(", createFilename='").append(createFilename).append('\'');
        sb.append(", updateFilename='").append(updateFilename).append('\'');
        sb.append(", updatedOn=").append(updatedOn);
        sb.append(", systemType='").append(systemType).append('\'');
        sb.append(", action='").append(action).append('\'');
        sb.append(", period='").append(period).append('\'');
        sb.append(", failedRuleDate=").append(failedRuleDate);
        sb.append(", mobileOperatorId=").append(mobileOperatorId);
        sb.append(", taxPaid=").append(taxPaid);
        sb.append(", featureName='").append(featureName).append('\'');
        sb.append(", recordTime=").append(recordTime);
        sb.append(", actualImei='").append(actualImei).append('\'');
        sb.append(", recordType='").append(recordType).append('\'');
        sb.append(", imei='").append(imei).append('\'');
        sb.append(", rawCdrFileName='").append(rawCdrFileName).append('\'');
        sb.append(", imeiArrivalTime=").append(imeiArrivalTime);
        sb.append(", source='").append(source).append('\'');
        sb.append(", updateRawCdrFileName='").append(updateRawCdrFileName).append('\'');
        sb.append(", updateImeiArrivalTime=").append(updateImeiArrivalTime);
        sb.append(", updateSource='").append(updateSource).append('\'');
        sb.append(", serverOrigin='").append(serverOrigin).append('\'');
        sb.append(", validityFlag=").append(validityFlag);
        sb.append(", actualOperator='").append(actualOperator).append('\'');
        sb.append(", testImei='").append(testImei).append('\'');
        sb.append(", deviceType='").append(deviceType).append('\'');
        sb.append(", isUsed='").append(isUsed).append('\'');
        sb.append(", reason='").append(reason).append('\'');
        sb.append('}');
        return sb.toString();
    }
}