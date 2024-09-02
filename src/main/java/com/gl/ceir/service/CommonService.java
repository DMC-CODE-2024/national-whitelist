package com.gl.ceir.service;

import com.gl.ceir.model.app.*;
import com.gl.ceir.model.sysParam.MobileDeviceRepository;
import com.gl.ceir.repository.app.*;
import com.gl.ceir.repository.sysParam.MobileDeviceRepoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CommonService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ActiveUniqueImeiEdrOptRepository activeUniqueImeiRepository;
    @Autowired
    private MobileDeviceRepoRepository mobileDeviceRepository;
    @Autowired
    ActiveUniqueForeignImeiEdrOptRepository activeUniqueForeignImeiEdrRepository;
    @Autowired
    ActiveForeignImeiWithDifferentMsisdnEdrOptRepository activeForeignImeiWithDifferentMsisdnEdrRepository;

    public Page<ActiveUniqueEdr> findAllLatestUniqueImeiInLastXDaysWithDeviceInfo(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        // Fetch ActiveUniqueImei records within the date range
        Page<ActiveUniqueEdrOpt> activeUniqueImeisOpt = activeUniqueImeiRepository.findAllByCreatedOnBetween(startDate, endDate, pageable);

        List<ActiveUniqueEdr> activeUniqueImeis = activeUniqueImeisOpt.stream()
                .map(imei -> modelMapper.map(imei, ActiveUniqueEdr.class))
                .collect(Collectors.toList());

        // Extract TACs from ActiveUniqueImei records
        List<String> tacs = activeUniqueImeis.stream().map(ActiveUniqueEdr::getTac).filter(Objects::nonNull).collect(Collectors.toList());

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

        return new PageImpl<>(activeUniqueImeis, pageable, activeUniqueImeisOpt.getTotalElements());
    }

    public Page<ActiveUniqueForeignImeiEdr> findAllLatestForeignImeiInLastXDaysWithDeviceInfo(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        // Fetch ActiveUniqueForeignImeiEdr records within the date range
        Page<ActiveUniqueForeignImeiEdrOpt> activeUniqueForeignImeisOpt = activeUniqueForeignImeiEdrRepository.findAllByCreatedOnBetween(startDate, endDate, pageable);

        List<ActiveUniqueForeignImeiEdr> activeUniqueForeignImeis = activeUniqueForeignImeisOpt.stream()
                .map(imei -> modelMapper.map(imei, ActiveUniqueForeignImeiEdr.class))
                .collect(Collectors.toList());

        // Extract TACs from ActiveUniqueForeignImeiEdr records
        List<String> tacs = activeUniqueForeignImeis.stream().map(ActiveUniqueForeignImeiEdr::getTac).filter(Objects::nonNull).collect(Collectors.toList());

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

        return new PageImpl<>(activeUniqueForeignImeis, pageable, activeUniqueForeignImeisOpt.getTotalElements());
    }

    public Page<ActiveForeignImeiWithDifferentImsi> findAllLatestDifferentImeiInLastXDaysWithDeviceInfo(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        // Fetch ActiveForeignImeiWithDifferentImsi records within the date range
        Page<ActiveForeignImeiWithDifferentImsiOpt> activeForeignImeisOpt = activeForeignImeiWithDifferentMsisdnEdrRepository.findAllByCreatedOnBetween(startDate, endDate, pageable);

        List<ActiveForeignImeiWithDifferentImsi> activeForeignImeis = activeForeignImeisOpt.stream()
                .map(imei -> modelMapper.map(imei, ActiveForeignImeiWithDifferentImsi.class))
                .collect(Collectors.toList());

        // Extract TACs from ActiveForeignImeiWithDifferentImsi records
        List<String> tacs = activeForeignImeis.stream().map(ActiveForeignImeiWithDifferentImsi::getTac).filter(Objects::nonNull).collect(Collectors.toList());

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

        return new PageImpl<>(activeForeignImeis, pageable, activeForeignImeisOpt.getTotalElements());
    }
}

