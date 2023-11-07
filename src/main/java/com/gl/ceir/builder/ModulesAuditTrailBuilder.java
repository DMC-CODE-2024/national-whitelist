package com.gl.ceir.builder;

import com.gl.ceir.model.audit.ModulesAuditTrail;

import java.net.InetAddress;
import java.time.LocalDateTime;

public class ModulesAuditTrailBuilder {

    public static ModulesAuditTrail forInsert(Integer statusCode, String status,
                                                         String errorMessage, String featureName,
                                                         String action, Integer count, String info, String moduleName, LocalDateTime startTime) {
        ModulesAuditTrail modulesAuditTrail = new ModulesAuditTrail();

        modulesAuditTrail.setCreatedOn(startTime);
        modulesAuditTrail.setModifiedOn(LocalDateTime.now());
        modulesAuditTrail.setExecutionTime(Math.toIntExact(System.currentTimeMillis() / 1000));
        modulesAuditTrail.setStatusCode(statusCode);
        modulesAuditTrail.setStatus(status);
        modulesAuditTrail.setErrorMessage(errorMessage);
        modulesAuditTrail.setModuleName(moduleName);
        modulesAuditTrail.setFeatureName(featureName);
        modulesAuditTrail.setAction(action);
        modulesAuditTrail.setCount(count);
        modulesAuditTrail.setInfo(info);
        modulesAuditTrail.setServerName(getHostname());

        return modulesAuditTrail;
    }

    public static ModulesAuditTrail forUpdate(int id, Integer statusCode, String status,
                                              String errorMessage, String featureName,
                                              String action, String info, String moduleName, int count, int executionTime, LocalDateTime startTime) {
        ModulesAuditTrail modulesAuditTrail = new ModulesAuditTrail();

        modulesAuditTrail.setId(id);
        modulesAuditTrail.setCreatedOn(startTime);
        modulesAuditTrail.setModifiedOn(LocalDateTime.now());
        modulesAuditTrail.setExecutionTime(Math.toIntExact(System.currentTimeMillis() / 1000) - executionTime);
        modulesAuditTrail.setStatusCode(statusCode);
        modulesAuditTrail.setStatus(status);
        modulesAuditTrail.setErrorMessage(errorMessage);
        modulesAuditTrail.setModuleName(moduleName);
        modulesAuditTrail.setFeatureName(featureName);
        modulesAuditTrail.setAction(action);
        modulesAuditTrail.setInfo(info);
        modulesAuditTrail.setCount(count);
        modulesAuditTrail.setServerName(getHostname());

        return modulesAuditTrail;
    }

    public static ModulesAuditTrail forUpdate(int id, Integer statusCode, String status,
                                              String errorMessage, String featureName,
                                              String action, String info, String moduleName, int executionTime, LocalDateTime startTime) {
        ModulesAuditTrail modulesAuditTrail = new ModulesAuditTrail();

        modulesAuditTrail.setId(id);
        modulesAuditTrail.setCreatedOn(startTime);
        modulesAuditTrail.setModifiedOn(LocalDateTime.now());
        modulesAuditTrail.setExecutionTime(Math.toIntExact(System.currentTimeMillis() / 1000) - executionTime);
        modulesAuditTrail.setStatusCode(statusCode);
        modulesAuditTrail.setStatus(status);
        modulesAuditTrail.setErrorMessage(errorMessage);
        modulesAuditTrail.setModuleName(moduleName);
        modulesAuditTrail.setFeatureName(featureName);
        modulesAuditTrail.setAction(action);
        modulesAuditTrail.setInfo(info);
        modulesAuditTrail.setServerName(getHostname());

        return modulesAuditTrail;
    }
    public static String getHostname() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            return localHost.getHostName();
        } catch (Exception ex) {
            return "NA";
        }
    }

}
