package com.gl.ceir.repository.audit;

import com.gl.ceir.model.audit.ModulesAuditTrail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ModulesAuditTrailRepository extends JpaRepository<ModulesAuditTrail,Long>, JpaSpecificationExecutor<ModulesAuditTrail> {
}
