package com.gl.ceir.model.app;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mobile_device_repository")
public class MobileDeviceRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "allocation_date")
    private LocalDateTime allocationDate;

    @Column(name = "announce_date")
    private LocalDateTime announceDate;

    @Column(name = "band_detail", length = 50)
    private String bandDetail;

    @Column(name = "battery_capacity")
    private Integer batteryCapacity;

    @Column(name = "battery_charging", length = 100)
    private String batteryCharging;

    @Column(name = "battery_type", length = 50)
    private String batteryType;

    @Column(name = "body_dimension", length = 50)
    private String bodyDimension;

    @Column(name = "body_weight", length = 20)
    private String bodyWeight;

    @Column(name = "brand_name", length = 50)
    private String brandName;

    @Column(name = "color", length = 100)
    private String color;

    @Column(name = "comms_bluetooth", length = 100)
    private String commsBluetooth;

    @Column(name = "comms_gps", length = 100)
    private String commsGps;

    @Column(name = "comms_nfc")
    private Integer commsNfc;

    @Column(name = "comms_radio")
    private Integer commsRadio;

    @Column(name = "comms_usb", length = 50)
    private String commsUsb;

    @Column(name = "comms_wlan", length = 100)
    private String commsWlan;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "custom_price_of_device")
    private Double customPriceOfDevice;

    @Column(name = "device_id", length = 8)
    private String deviceId;

    @Column(name = "device_state")
    private Integer deviceState;

    @Column(name = "device_status", length = 20)
    private String deviceStatus;

    @Column(name = "device_type", length = 50)
    private String deviceType;

    @Column(name = "discontinue_date")
    private LocalDateTime discontinueDate;

    @Column(name = "display_protection", length = 50)
    private String displayProtection;

    @Column(name = "display_resolution", length = 50)
    private String displayResolution;

    @Column(name = "display_size", length = 50)
    private String displaySize;

    @Column(name = "display_type", length = 50)
    private String displayType;

    @Column(name = "esim_support")
    private Integer esimSupport;

    @Column(name = "imei_quantity")
    private Integer imeiQuantity;

    @Column(name = "launch_date")
    private LocalDateTime launchDate;

    @Column(name = "is_type_approved")
    private Boolean isTypeApprovedFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getAllocationDate() {
        return allocationDate;
    }

    public void setAllocationDate(LocalDateTime allocationDate) {
        this.allocationDate = allocationDate;
    }

    public LocalDateTime getAnnounceDate() {
        return announceDate;
    }

    public void setAnnounceDate(LocalDateTime announceDate) {
        this.announceDate = announceDate;
    }

    public String getBandDetail() {
        return bandDetail;
    }

    public void setBandDetail(String bandDetail) {
        this.bandDetail = bandDetail;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getBatteryCharging() {
        return batteryCharging;
    }

    public void setBatteryCharging(String batteryCharging) {
        this.batteryCharging = batteryCharging;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getBodyDimension() {
        return bodyDimension;
    }

    public void setBodyDimension(String bodyDimension) {
        this.bodyDimension = bodyDimension;
    }

    public String getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(String bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCommsBluetooth() {
        return commsBluetooth;
    }

    public void setCommsBluetooth(String commsBluetooth) {
        this.commsBluetooth = commsBluetooth;
    }

    public String getCommsGps() {
        return commsGps;
    }

    public void setCommsGps(String commsGps) {
        this.commsGps = commsGps;
    }

    public Integer getCommsNfc() {
        return commsNfc;
    }

    public void setCommsNfc(Integer commsNfc) {
        this.commsNfc = commsNfc;
    }

    public Integer getCommsRadio() {
        return commsRadio;
    }

    public void setCommsRadio(Integer commsRadio) {
        this.commsRadio = commsRadio;
    }

    public String getCommsUsb() {
        return commsUsb;
    }

    public void setCommsUsb(String commsUsb) {
        this.commsUsb = commsUsb;
    }

    public String getCommsWlan() {
        return commsWlan;
    }

    public void setCommsWlan(String commsWlan) {
        this.commsWlan = commsWlan;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Double getCustomPriceOfDevice() {
        return customPriceOfDevice;
    }

    public void setCustomPriceOfDevice(Double customPriceOfDevice) {
        this.customPriceOfDevice = customPriceOfDevice;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(Integer deviceState) {
        this.deviceState = deviceState;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public LocalDateTime getDiscontinueDate() {
        return discontinueDate;
    }

    public void setDiscontinueDate(LocalDateTime discontinueDate) {
        this.discontinueDate = discontinueDate;
    }

    public String getDisplayProtection() {
        return displayProtection;
    }

    public void setDisplayProtection(String displayProtection) {
        this.displayProtection = displayProtection;
    }

    public String getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(String displayResolution) {
        this.displayResolution = displayResolution;
    }

    public String getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(String displaySize) {
        this.displaySize = displaySize;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public Integer getEsimSupport() {
        return esimSupport;
    }

    public void setEsimSupport(Integer esimSupport) {
        this.esimSupport = esimSupport;
    }

    public Integer getImeiQuantity() {
        return imeiQuantity;
    }

    public void setImeiQuantity(Integer imeiQuantity) {
        this.imeiQuantity = imeiQuantity;
    }

    public LocalDateTime getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDateTime launchDate) {
        this.launchDate = launchDate;
    }

    @Override
    public String toString() {
        return "MobileDeviceRepository{" +
                "id=" + id +
                ", allocationDate=" + allocationDate +
                ", announceDate=" + announceDate +
                ", bandDetail='" + bandDetail + '\'' +
                ", batteryCapacity=" + batteryCapacity +
                ", batteryCharging='" + batteryCharging + '\'' +
                ", batteryType='" + batteryType + '\'' +
                ", bodyDimension='" + bodyDimension + '\'' +
                ", bodyWeight='" + bodyWeight + '\'' +
                ", brandName='" + brandName + '\'' +
                ", color='" + color + '\'' +
                ", commsBluetooth='" + commsBluetooth + '\'' +
                ", commsGps='" + commsGps + '\'' +
                ", commsNfc=" + commsNfc +
                ", commsRadio=" + commsRadio +
                ", commsUsb='" + commsUsb + '\'' +
                ", commsWlan='" + commsWlan + '\'' +
                ", createdOn=" + createdOn +
                ", customPriceOfDevice=" + customPriceOfDevice +
                ", deviceId='" + deviceId + '\'' +
                ", deviceState=" + deviceState +
                ", deviceStatus='" + deviceStatus + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", discontinueDate=" + discontinueDate +
                ", displayProtection='" + displayProtection + '\'' +
                ", displayResolution='" + displayResolution + '\'' +
                ", displaySize='" + displaySize + '\'' +
                ", displayType='" + displayType + '\'' +
                ", esimSupport=" + esimSupport +
                ", imeiQuantity=" + imeiQuantity +
                ", launchDate=" + launchDate +
                '}';
    }
}

