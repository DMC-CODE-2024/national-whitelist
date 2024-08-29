package com.gl.ceir.service;

import com.gl.ceir.model.output.ForeignWhitelist;
import com.gl.ceir.repository.output.ForeignWhitelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeignWhitelistService {
    @Autowired
    ForeignWhitelistRepository foreignWhitelistRepository;

//    @Transactional
    public void saveNationalWhitelists(List<ForeignWhitelist> nationalWhitelists, boolean amnestyPeriodFlag) {
        for (ForeignWhitelist entry : nationalWhitelists) {
            try {
                if (amnestyPeriodFlag) {
                    foreignWhitelistRepository.save(entry);
                } else {
                    if (Boolean.TRUE.equals(entry.getValidityFlag())) {
                        foreignWhitelistRepository.save(entry);
                    }
                }
            } catch (DataIntegrityViolationException ex) {
                // Ignore duplicate entry constraint violation
//                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
    }
}
