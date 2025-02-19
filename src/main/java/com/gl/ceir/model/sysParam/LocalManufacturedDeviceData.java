package com.gl.ceir.model.sysParam;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "trc_local_manufactured_device_data")
public class LocalManufacturedDeviceData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_on", nullable = false)
    private Timestamp createdOn;

    @Column(name = "imei")
    private String imei;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "manufacturer_id")
    private String manufacturerId;

    @Column(name = "manufacturer_name")
    private String manufacturerName;

    @Column(name = "manufacturing_date")
    private String manufacturingDate;

    public LocalManufacturedDeviceData() {
    }

    public LocalManufacturedDeviceData(Integer id, Timestamp createdOn, String imei, String serialNumber, String manufacturerId, String manufacturerName, String manufacturingDate) {
        this.id = id;
        this.createdOn = createdOn;
        this.imei = imei;
        this.serialNumber = serialNumber;
        this.manufacturerId = manufacturerId;
        this.manufacturerName = manufacturerName;
        this.manufacturingDate = manufacturingDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    @Override
    public String toString() {
        return "LocalManufacturedDeviceData{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", imei='" + imei + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", manufacturerId='" + manufacturerId + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", manufacturingDate='" + manufacturingDate + '\'' +
                '}';
    }
}

