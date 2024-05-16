package com.gl.ceir.model.app;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "gdce_data")
public class GdceData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_on", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdOn;

    @Column(name = "importer_id", length = 25)
    private String importerId;

    @Column(name = "importer_name", length = 50)
    private String importerName;

    @Column(name = "imei", length = 20)
    private String imei;

    @Column(name = "serial_number", length = 15)
    private String serialNumber;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "date_of_actual_import")
    private LocalDateTime dateOfActualImport;

    @Column(name = "is_used")
    private Integer isUsed;

    @Column(name = "is_custom_tax_paid")
    private Integer isCustomTaxPaid;

    public GdceData(Integer id, LocalDateTime createdOn, String importerId, String importerName, String imei, String serialNumber, LocalDateTime registrationDate, LocalDateTime dateOfActualImport, Integer isUsed, Integer isCustomTaxPaid) {
        this.id = id;
        this.createdOn = createdOn;
        this.importerId = importerId;
        this.importerName = importerName;
        this.imei = imei;
        this.serialNumber = serialNumber;
        this.registrationDate = registrationDate;
        this.dateOfActualImport = dateOfActualImport;
        this.isUsed = isUsed;
        this.isCustomTaxPaid = isCustomTaxPaid;
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

    public String getImporterId() {
        return importerId;
    }

    public void setImporterId(String importerId) {
        this.importerId = importerId;
    }

    public String getImporterName() {
        return importerName;
    }

    public void setImporterName(String importerName) {
        this.importerName = importerName;
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

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDateTime getDateOfActualImport() {
        return dateOfActualImport;
    }

    public void setDateOfActualImport(LocalDateTime dateOfActualImport) {
        this.dateOfActualImport = dateOfActualImport;
    }

    public Integer getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Integer isUsed) {
        this.isUsed = isUsed;
    }

    public Integer getIsCustomTaxPaid() {
        return isCustomTaxPaid;
    }

    public void setIsCustomTaxPaid(Integer isCustomTaxPaid) {
        this.isCustomTaxPaid = isCustomTaxPaid;
    }

    @Override
    public String toString() {
        return "GdceData{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                ", importerId='" + importerId + '\'' +
                ", importerName='" + importerName + '\'' +
                ", imei='" + imei + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", registrationDate=" + registrationDate +
                ", dateOfActualImport=" + dateOfActualImport +
                ", isUsed=" + isUsed +
                ", isCustomTaxPaid=" + isCustomTaxPaid +
                '}';
    }
}
