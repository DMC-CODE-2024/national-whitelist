package com.gl.ceir.service;

import com.gl.ceir.model.app.ActiveForeignImeiWithDifferentImsi;
import com.gl.ceir.model.app.ActiveUniqueEdr;
import com.gl.ceir.model.app.ActiveUniqueForeignImeiEdr;
import com.gl.ceir.model.sysParam.MobileDeviceRepository;
import com.gl.ceir.repository.app.ActiveForeignImeiWithDifferentMsisdnEdrRepository;
import com.gl.ceir.repository.app.ActiveUniqueForeignImeiEdrRepository;
import com.gl.ceir.repository.app.ActiveUniqueImeiEdrRepository;
import com.gl.ceir.repository.sysParam.MobileDeviceRepoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CommonService {

    @Autowired
    private ActiveUniqueImeiEdrRepository activeUniqueImeiRepository;
    @Autowired
    private MobileDeviceRepoRepository mobileDeviceRepository;
    @Autowired
    ActiveUniqueForeignImeiEdrRepository activeUniqueForeignImeiEdrRepository;
    @Autowired
    ActiveForeignImeiWithDifferentMsisdnEdrRepository activeForeignImeiWithDifferentMsisdnEdrRepository;

    public Page<ActiveUniqueEdr> findAllLatestUniqueImeiInLastXDaysWithDeviceInfo(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        // Fetch ActiveUniqueImei records within the date range
        Page<ActiveUniqueEdr> activeUniqueImeis = activeUniqueImeiRepository.findAllByCreatedOnBetween(startDate, endDate, pageable);

        // Extract TACs from ActiveUniqueImei records
        List<String> tacs = activeUniqueImeis.stream().map(ActiveUniqueEdr::getTac).collect(Collectors.toList());

        // Fetch corresponding MobileDeviceRepository records
        List<MobileDeviceRepository> mobileDevices = mobileDeviceRepository.findByDeviceIdIn(tacs);

        // Map MobileDeviceRepository records to their TAC
        Map<String, MobileDeviceRepository> deviceMap = mobileDevices.stream()
                .collect(Collectors.toMap(MobileDeviceRepository::getDeviceId, Function.identity()));

        // Update ActiveUniqueImei records with information from MobileDeviceRepository
        for (ActiveUniqueEdr imei : activeUniqueImeis) {
            MobileDeviceRepository device = deviceMap.get(imei.getTac());
            if (device != null) {
                imei.setValidityFlag(true);
                imei.setDeviceType(device.getDeviceType());
                imei.setIsTypeApproved(device.getTypeApprovedFlag() ? 1 : 0);
            } else {
                imei.setValidityFlag(false);
                imei.setDeviceType(null);
                imei.setIsTypeApproved(null);
            }
        }

        return activeUniqueImeis;
    }

    public Page<ActiveUniqueForeignImeiEdr> findAllLatestForeignImeiInLastXDaysWithDeviceInfo(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        // Fetch ActiveUniqueForeignImeiEdr records within the date range
        Page<ActiveUniqueForeignImeiEdr> activeUniqueForeignImeis = activeUniqueForeignImeiEdrRepository.findAllByCreatedOnBetween(startDate, endDate, pageable);

        // Extract TACs from ActiveUniqueForeignImeiEdr records
        List<String> tacs = activeUniqueForeignImeis.stream().map(ActiveUniqueForeignImeiEdr::getTac).collect(Collectors.toList());

        // Fetch corresponding MobileDeviceRepository records
        List<MobileDeviceRepository> mobileDevices = mobileDeviceRepository.findByDeviceIdIn(tacs);

        // Map MobileDeviceRepository records to their TAC
        Map<String, MobileDeviceRepository> deviceMap = mobileDevices.stream()
                .collect(Collectors.toMap(MobileDeviceRepository::getDeviceId, Function.identity()));

        // Update ActiveUniqueForeignImeiEdr records with information from MobileDeviceRepository
        for (ActiveUniqueForeignImeiEdr imei : activeUniqueForeignImeis) {
            MobileDeviceRepository device = deviceMap.get(imei.getTac());
            if (device != null) {
                imei.setValidityFlag(true);
                imei.setDeviceType(device.getDeviceType());
            } else {
                imei.setValidityFlag(false);
                imei.setDeviceType(null);
            }
        }

        return activeUniqueForeignImeis;
    }

    public Page<ActiveForeignImeiWithDifferentImsi> findAllLatestDifferentImeiInLastXDaysWithDeviceInfo(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        // Fetch ActiveForeignImeiWithDifferentImsi records within the date range
        Page<ActiveForeignImeiWithDifferentImsi> activeForeignImeis = activeForeignImeiWithDifferentMsisdnEdrRepository.findAllByCreatedOnBetween(startDate, endDate, pageable);

        // Extract TACs from ActiveForeignImeiWithDifferentImsi records
        List<String> tacs = activeForeignImeis.stream().map(ActiveForeignImeiWithDifferentImsi::getTac).collect(Collectors.toList());

        // Fetch corresponding MobileDeviceRepository records
        List<MobileDeviceRepository> mobileDevices = mobileDeviceRepository.findByDeviceIdIn(tacs);

        // Map MobileDeviceRepository records to their TAC
        Map<String, MobileDeviceRepository> deviceMap = mobileDevices.stream()
                .collect(Collectors.toMap(MobileDeviceRepository::getDeviceId, Function.identity()));

        // Update ActiveForeignImeiWithDifferentImsi records with information from MobileDeviceRepository
        for (ActiveForeignImeiWithDifferentImsi imei : activeForeignImeis) {
            MobileDeviceRepository device = deviceMap.get(imei.getTac());
            if (device != null) {
                imei.setValidityFlag(true);
                imei.setDeviceType(device.getDeviceType());
            } else {
                imei.setValidityFlag(false);
                imei.setDeviceType(null);
            }
        }

        return activeForeignImeis;
    }
}

