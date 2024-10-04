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
    public int saveNationalWhitelists(List<ForeignWhitelist> nationalWhitelists, boolean amnestyPeriodFlag) {
        int count = 0;
        for (ForeignWhitelist entry : nationalWhitelists) {
            try {
                if (amnestyPeriodFlag) {
                    foreignWhitelistRepository.save(entry);
                    count++;
                } else {
                    if (Boolean.TRUE.equals(entry.getValidityFlag())) {
                        foreignWhitelistRepository.save(entry);
                        count++;
                    }
                }
            } catch (DataIntegrityViolationException ex) {
                // Ignore duplicate entry constraint violation
//                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return count;
    }
}
