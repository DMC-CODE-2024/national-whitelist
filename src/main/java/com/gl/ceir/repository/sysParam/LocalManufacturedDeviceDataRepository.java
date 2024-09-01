package com.gl.ceir.repository.sysParam;

import com.gl.ceir.model.sysParam.LocalManufacturedDeviceData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalManufacturedDeviceDataRepository extends JpaRepository<LocalManufacturedDeviceData,Long>, JpaSpecificationExecutor<LocalManufacturedDeviceData> {
    Optional<LocalManufacturedDeviceData> findByImei(String imei);
}