package com.gl.ceir.model.app;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "exception_list")
public class ExceptionList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer exceptionListId;

    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;
    private String foreignRule;
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
    private LocalDateTime failedRuleDate;
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
    private String reasonForInvalidImei;
    private Boolean validityFlag;
    private String deviceType;
    private LocalDateTime exceptionListCreatedDate;
    private String actualOperator;
    private String isTestImei;
    private String listType;
    private String isUsedDeviceImei;

    public ExceptionList() {
    }

    public ExceptionList(Integer exceptionListId, LocalDateTime createdOn, LocalDateTime modifiedOn, String foreignRule, String tac, String msisdn, Integer failedRuleId, String failedRuleName, String imsi, String mobileOperator, String createdFilename, String updatedFilename, LocalDateTime updatedOn, String systemType, String action, String period, LocalDateTime failedRuleDate, Integer taxPaid, String featureName, LocalDateTime recordTime, String actualImei, String recordType, String imei, String rawCdrFileName, LocalDateTime imeiArrivalTime, String source, String updateRawCdrFileName, LocalDateTime updateImeiArrivalTime, String updateSource, String serverOrigin, String reasonForInvalidImei, Boolean validityFlag, String deviceType, LocalDateTime exceptionListCreatedDate, String actualOperator, String isTestImei, String listType, String isUsedDeviceImei) {
        this.exceptionListId = exceptionListId;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.foreignRule = foreignRule;
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
        this.failedRuleDate = failedRuleDate;
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
        this.reasonForInvalidImei = reasonForInvalidImei;
        this.validityFlag = validityFlag;
        this.deviceType = deviceType;
        this.exceptionListCreatedDate = exceptionListCreatedDate;
        this.actualOperator = actualOperator;
        this.isTestImei = isTestImei;
        this.listType = listType;
        this.isUsedDeviceImei = isUsedDeviceImei;
    }

    public Integer getExceptionListId() {
        return exceptionListId;
    }

    public void setExceptionListId(Integer exceptionListId) {
        this.exceptionListId = exceptionListId;
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

    public String getReasonForInvalidImei() {
        return reasonForInvalidImei;
    }

    public void setReasonForInvalidImei(String reasonForInvalidImei) {
        this.reasonForInvalidImei = reasonForInvalidImei;
    }

    public Boolean getValidityFlag() {
        return validityFlag;
    }

    public void setValidityFlag(Boolean validityFlag) {
        this.validityFlag = validityFlag;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public LocalDateTime getExceptionListCreatedDate() {
        return exceptionListCreatedDate;
    }

    public void setExceptionListCreatedDate(LocalDateTime exceptionListCreatedDate) {
        this.exceptionListCreatedDate = exceptionListCreatedDate;
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

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getIsUsedDeviceImei() {
        return isUsedDeviceImei;
    }

    public void setIsUsedDeviceImei(String isUsedDeviceImei) {
        this.isUsedDeviceImei = isUsedDeviceImei;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExceptionList{");
        sb.append("exceptionListId=").append(exceptionListId);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", modifiedOn=").append(modifiedOn);
        sb.append(", foreignRule='").append(foreignRule).append('\'');
        sb.append(", tac='").append(tac).append('\'');
        sb.append(", msisdn='").append(msisdn).append('\'');
        sb.append(", failedRuleId=").append(failedRuleId);
        sb.append(", failedRuleName='").append(failedRuleName).append('\'');
        sb.append(", imsi='").append(imsi).append('\'');
        sb.append(", mobileOperator='").append(mobileOperator).append('\'');
        sb.append(", createdFilename='").append(createdFilename).append('\'');
        sb.append(", updatedFilename='").append(updatedFilename).append('\'');
        sb.append(", updatedOn=").append(updatedOn);
        sb.append(", systemType='").append(systemType).append('\'');
        sb.append(", action='").append(action).append('\'');
        sb.append(", period='").append(period).append('\'');
        sb.append(", failedRuleDate=").append(failedRuleDate);
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
        sb.append(", reasonForInvalidImei='").append(reasonForInvalidImei).append('\'');
        sb.append(", validityFlag=").append(validityFlag);
        sb.append(", deviceType='").append(deviceType).append('\'');
        sb.append(", exceptionListCreatedDate=").append(exceptionListCreatedDate);
        sb.append(", actualOperator='").append(actualOperator).append('\'');
        sb.append(", isTestImei='").append(isTestImei).append('\'');
        sb.append(", listType='").append(listType).append('\'');
        sb.append(", isUsedDeviceImei='").append(isUsedDeviceImei).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExceptionList that = (ExceptionList) o;
        return Objects.equals(imei, that.imei) && Objects.equals(msisdn, that.msisdn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imei, msisdn);
    }
}

