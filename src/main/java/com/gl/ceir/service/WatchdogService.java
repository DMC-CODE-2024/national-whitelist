package com.gl.ceir.service;

import com.gl.ceir.model.app.CfgFeatureAlert;
import com.gl.ceir.repository.app.CfgFeatureAlertRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WatchdogService implements Runnable {

    private final Logger log = LogManager.getLogger(getClass());
    private final ValidateRules validateRules;
    private final long MAX_IDLE_TIME_MS = 60 * 60 * 1000; // 60 minutes
    @Autowired
    private CfgFeatureAlertRepository cfgFeatureAlertRepository;

    public WatchdogService(ValidateRules validateRules) {
        this.validateRules = validateRules;
    }

    @Override
    public void run() {
        long lastProgressTime = System.currentTimeMillis();

        while (true) {
            if (validateRules.madeProgressSince(lastProgressTime)) {
                lastProgressTime = System.currentTimeMillis(); // Update last progress time
            } else {
                long currentTime = System.currentTimeMillis();
                long elapsed = currentTime - lastProgressTime;

                if (elapsed > MAX_IDLE_TIME_MS) {
                    log.error("Exiting National Whitelist process due to inactivity for 60 minutes.");
                    Optional<CfgFeatureAlert> alert = cfgFeatureAlertRepository.findByAlertId("alert1209");
                    log.error("raising alert1209");
                    System.out.println("raising alert1209");
                    if (alert.isPresent()) {
                        validateRules.raiseAnAlert(alert.get().getAlertId(), "Exiting National Whitelist process due to inactivity for 60 minutes.", "national_whitelist", 0);
//                RunningAlertDb alertDb = new RunningAlertDb(alert.get().getAlertId(), alert.get().getDescription().replace("<ERROR>", msg), 0);
//                runningAlertDbRepo.save(alertDb);
                    }
                    System.exit(0);
                }
            }

            try {
                Thread.sleep(3600000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

