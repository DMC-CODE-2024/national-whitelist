package com.gl.ceir.service;

import com.gl.ceir.model.app.ExceptionList;
import com.gl.ceir.repository.app.ExceptionListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class ExceptionListService {
    @Autowired
    ExceptionListRepository exceptionListRepository;

//    @Transactional
    public void saveExceptionLists(List<ExceptionList> nationalWhitelists) {
        for (ExceptionList entry : nationalWhitelists) {
            try {
                exceptionListRepository.save(entry);
            } catch (DataIntegrityViolationException ex) {
                ex.printStackTrace();
                // Ignore duplicate entry constraint violation
//                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
    }
}
