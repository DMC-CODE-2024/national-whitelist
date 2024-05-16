package com.gl.ceir;

import com.gl.ceir.service.ValidateRules;
import com.gl.ceir.service.WatchdogService;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEncryptableProperties
@ComponentScan(basePackages = "com.gl.ceir")
public class NaitionalWhitelistApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(NaitionalWhitelistApplication.class, args);
		ValidateRules validateRules = ctx.getBean(ValidateRules.class);
//		WatchdogService watchdogService = ctx.getBean(WatchdogService.class);
		new Thread(validateRules).start();
//		new Thread(watchdogService).start();
	}

}
