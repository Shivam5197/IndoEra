package com.Indoera.ecomProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//Auto config stopped for system to generate default passwords and throwing 403 errors
public class EcomProjectApplication {

	private static final Logger logger = LogManager.getLogger(EcomProjectApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(EcomProjectApplication.class, args);
	}

}


