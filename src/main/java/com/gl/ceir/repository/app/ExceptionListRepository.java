package com.gl.ceir.repository.app;

import com.gl.ceir.model.app.ExceptionList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionListRepository  extends JpaRepository<ExceptionList,Long>, JpaSpecificationExecutor<ExceptionList> {
}
