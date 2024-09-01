package com.gl.ceir.repository.sysParam;

import com.gl.ceir.model.sysParam.MobileDeviceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileDeviceRepoRepository extends JpaRepository<MobileDeviceRepository, Long> {
    List<MobileDeviceRepository> findByDeviceIdIn(List<String> deviceIds);
}
