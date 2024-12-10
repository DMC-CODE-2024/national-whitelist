package com.gl.ceir.model.output;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "foreign_whitelist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForeignWhitelist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foreignWhitelistId;

    private LocalDateTime createdOn;

    private LocalDateTime modifiedOn;

    private String mobileOperator;

    private String period;

    private String createdFilename;

    private String updatedFilename;

    private LocalDateTime updatedOn;

    private String systemType;

    private Integer failedRuleId;

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

    private LocalDateTime foreignWhiteListCreatedDate;
}
