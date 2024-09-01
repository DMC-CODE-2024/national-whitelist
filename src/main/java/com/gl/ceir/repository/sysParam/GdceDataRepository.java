package com.gl.ceir.repository.sysParam;

import com.gl.ceir.model.sysParam.GdceData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GdceDataRepository extends JpaRepository<GdceData,Long>, JpaSpecificationExecutor<GdceData> {
    Optional<GdceData> findByImei(String imei);
}
