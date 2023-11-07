package com.gl.ceir.repository.app;

import com.gl.ceir.model.app.NationalWhitelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NationalWhitelistRepository  extends JpaRepository<NationalWhitelist,Long>, JpaSpecificationExecutor<NationalWhitelist> {
}
