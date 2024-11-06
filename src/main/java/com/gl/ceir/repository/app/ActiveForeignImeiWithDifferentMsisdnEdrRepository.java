package com.gl.ceir.repository.app;

import com.gl.ceir.model.app.ActiveForeignImeiWithDifferentImsi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ActiveForeignImeiWithDifferentMsisdnEdrRepository extends JpaRepository<ActiveForeignImeiWithDifferentImsi, Long>, JpaSpecificationExecutor<ActiveForeignImeiWithDifferentImsi> {
    @Query(value = "SELECT  a.*, CASE WHEN m.device_id IS NULL THEN 'false' ELSE 'true' END AS validity_flag, m.device_type FROM active_foreign_imei_with_different_imsi a LEFT JOIN mobile_device_repository m ON a.tac = m.device_id WHERE a.created_on <= :endDate AND a.created_on >= :startDate", nativeQuery = true)
    Page<ActiveForeignImeiWithDifferentImsi> findAllLatestDifferentImeiInLastXDays(@Param("startDate") LocalDateTime paramLocalDateTime1, @Param("endDate") LocalDateTime paramLocalDateTime2, Pageable paramPageable);

    @Query(value = "SELECT min(created_on) from active_foreign_imei_with_different_imsi", nativeQuery = true)
    String getEarliestActiveTimestamp();

    @Query("SELECT a FROM ActiveForeignImeiWithDifferentImsi a WHERE a.createdOn BETWEEN :startDate AND :endDate")
    Page<ActiveForeignImeiWithDifferentImsi> findAllByCreatedOnBetween(@Param("startDate") LocalDateTime paramLocalDateTime1, @Param("endDate") LocalDateTime paramLocalDateTime2, Pageable paramPageable);
}
