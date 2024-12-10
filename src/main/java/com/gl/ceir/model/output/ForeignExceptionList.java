package com.gl.ceir.model.output;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "foreign_exception_list")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForeignExceptionList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foreignExceptionListId;

    private LocalDateTime createdOn;

    private LocalDateTime modifiedOn;

    private String tac;

    private String msisdn;

    private Integer failedRuleId;

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
}
