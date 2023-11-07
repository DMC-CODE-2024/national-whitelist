package com.gl.ceir.repository.app;

import com.gl.ceir.model.app.ForeignWhitelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ForeignWhitelistRepository extends JpaRepository<ForeignWhitelist,Long>, JpaSpecificationExecutor<ForeignWhitelist> {
}
