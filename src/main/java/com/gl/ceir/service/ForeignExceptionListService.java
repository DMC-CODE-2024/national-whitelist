package com.gl.ceir.service;

import com.gl.ceir.model.output.ForeignExceptionList;
import com.gl.ceir.repository.output.ForeignExceptionListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeignExceptionListService {
    @Autowired
    ForeignExceptionListRepository foreignExceptionListRepository;

//    @Transactional
    public int saveExceptionLists(List<ForeignExceptionList> nationalWhitelists) {
        int count = 0;
        for (ForeignExceptionList entry : nationalWhitelists) {
            try {
                foreignExceptionListRepository.save(entry);
                count++;
            } catch (DataIntegrityViolationException ex) {
                // Ignore duplicate entry constraint violation
//                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return count;
    }
}
