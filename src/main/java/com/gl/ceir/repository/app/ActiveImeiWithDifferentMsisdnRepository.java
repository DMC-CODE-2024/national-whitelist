package com.gl.ceir.repository.app;

import com.gl.ceir.model.app.ActiveImeiWithDifferentMsisdn;
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
public interface ActiveImeiWithDifferentMsisdnRepository extends JpaRepository<ActiveImeiWithDifferentMsisdn,Long>, JpaSpecificationExecutor<ActiveImeiWithDifferentMsisdn> {
    @Query(value = "SELECT  a.*, CASE WHEN m.device_id IS NULL THEN 'false' ELSE 'true' END AS validity_flag, m.device_type FROM active_imei_with_different_msisdn a LEFT JOIN mobile_device_repository m ON a.tac = m.device_id WHERE a.created_on <= :endDate AND a.created_on >= :startDate", nativeQuery = true)
    public Page<ActiveImeiWithDifferentMsisdn> findAllLatestDifferentImeiInLastXDays(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, Pageable pageable);

    @Query(value = "SELECT min(created_on) from active_imei_with_different_msisdn", nativeQuery = true)
    public String getEarliestActiveTimestamp();
}
