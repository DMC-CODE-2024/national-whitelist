package com.gl.ceir.repository.app;

import com.gl.ceir.model.app.ForeignExceptionList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ForeignExceptionListRepository extends JpaRepository<ForeignExceptionList,Long>, JpaSpecificationExecutor<ForeignExceptionList> {
}

