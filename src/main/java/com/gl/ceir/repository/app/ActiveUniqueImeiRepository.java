package com.gl.ceir.repository.app;

import com.gl.ceir.model.app.ActiveUniqueImei;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ActiveUniqueImeiRepository extends JpaRepository<ActiveUniqueImei,Long>, JpaSpecificationExecutor<ActiveUniqueImei> {
    @Query(value = "SELECT  a.*, CASE WHEN m.device_id IS NULL THEN 'false' ELSE 'true' END AS validity_flag, m.device_type, m.is_type_approved FROM active_unique_imei a LEFT JOIN mobile_device_repository m ON a.tac = m.device_id WHERE a.created_on <= :endDate AND a.created_on >= :startDate", nativeQuery = true)
    public Page<ActiveUniqueImei> findAllLatestUniqueImeiInLastXDays(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, Pageable pageable);

    @Query(value = "SELECT min(created_on) from active_unique_imei", nativeQuery = true)
    public String getEarliestActiveTimestamp();

    @Query(value = "SELECT  a.*, CASE WHEN m.device_id IS NULL THEN 'false' ELSE 'true' END AS validity_flag, m.device_type FROM active_unique_imei a LEFT JOIN mobile_device_repository m ON a.tac = m.device_id WHERE a.created_on <= :endDate AND a.created_on >= :startDate and a.tac = 01254100", nativeQuery = true)
    public Page<ActiveUniqueImei> findAllLatestUniqueImeiInLastXDaysTest(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, Pageable pageable);
}
