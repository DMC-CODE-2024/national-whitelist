package com.gl.ceir.service;

import com.gl.ceir.model.app.ForeignExceptionList;
import com.gl.ceir.repository.app.ForeignExceptionListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class ForeignExceptionListService {
    @Autowired
    ForeignExceptionListRepository foreignExceptionListRepository;

//    @Transactional
    public void saveExceptionLists(List<ForeignExceptionList> nationalWhitelists) {
        for (ForeignExceptionList entry : nationalWhitelists) {
            try {
                foreignExceptionListRepository.save(entry);
            } catch (DataIntegrityViolationException ex) {
                // Ignore duplicate entry constraint violation
//                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
    }
}
