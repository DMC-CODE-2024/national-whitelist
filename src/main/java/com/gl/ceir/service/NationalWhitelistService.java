package com.gl.ceir.service;

import com.gl.ceir.model.app.NationalWhitelist;
import com.gl.ceir.repository.app.NationalWhitelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class NationalWhitelistService {
    @Autowired
    NationalWhitelistRepository nationalWhitelistRepository;


//    @Transactional
    public void saveNationalWhitelists(List<NationalWhitelist> nationalWhitelists) {
        for (NationalWhitelist entry : nationalWhitelists) {
            try {
                nationalWhitelistRepository.save(entry);
            } catch (DataIntegrityViolationException ex) {
                // Ignore duplicate entry constraint violation
//                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
    }
}
