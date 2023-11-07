package com.gl.ceir.repository.app;

import com.gl.ceir.model.app.RunningAlertDb;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RunningAlertDbRepo extends JpaRepository<RunningAlertDb, Long>{

	public RunningAlertDb save(RunningAlertDb alertDb);
}
