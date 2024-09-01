package com.gl.ceir.repository.sysParam;

import com.gl.ceir.model.sysParam.RunningAlertDb;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RunningAlertDbRepo extends JpaRepository<RunningAlertDb, Long>{

	public RunningAlertDb save(RunningAlertDb alertDb);
}
