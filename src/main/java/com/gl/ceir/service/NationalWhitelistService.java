package com.gl.ceir.service;

import com.gl.ceir.model.output.NationalWhitelist;
import com.gl.ceir.model.sysParam.SystemConfigurationDb;
import com.gl.ceir.repository.output.NationalWhitelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NationalWhitelistService {
    @Autowired
    NationalWhitelistRepository nationalWhitelistRepository;


//    @Transactional
    public int saveNationalWhitelists(List<NationalWhitelist> nationalWhitelists, boolean amnestyPeriod, Optional<SystemConfigurationDb> deviceTypeOptional) {
        int count = 0;
        for (NationalWhitelist entry : nationalWhitelists) {
            try {
                if (amnestyPeriod) {
                    nationalWhitelistRepository.save(entry);
                    count++;
                } else {
                    if (Boolean.TRUE.equals(entry.getValidityFlag())) {
                        if (deviceTypeOptional.isPresent()) {
                            String deviceType = deviceTypeOptional.get().getValue();
                            if (deviceType.contains(entry.getDeviceType())) {
                                if (entry.getGdceImeiStatus() == 1) {
                                    nationalWhitelistRepository.save(entry);
                                    count++;
                                }
                            } else {
                                nationalWhitelistRepository.save(entry);
                                count++;
                            }
                        } else {
                            nationalWhitelistRepository.save(entry);
                            count++;
                        }
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
