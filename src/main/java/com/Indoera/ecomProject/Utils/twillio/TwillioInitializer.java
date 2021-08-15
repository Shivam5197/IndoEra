package com.Indoera.ecomProject.Utils.twillio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.twilio.Twilio;

@Configuration
public class TwillioInitializer /* implements CommandLineRunner */{

	private static final Logger logger = LoggerFactory.getLogger(TwillioInitializer.class);
	private final TwillioProperties twillioProperties;
		
	
//	final String accountID = System.getenv("TWILIO_ACCOUNT_SID");
//	final String authId = System.getenv("TWILIO_AUTH_TOKEN");
//	logger.info("System Account ID------- "+ accountID);
//	logger.info("System Auth ------- "+ authId);
	
//use these Variables	

	
	@Autowired
	public TwillioInitializer(TwillioProperties twillioConfig) {
		this.twillioProperties = twillioConfig;
		Twilio.init(twillioConfig.getAccountSid(), 
						twillioConfig.getAuthToken());
		

//	logger.info("Account S ID env ============== "+ env.getProperty("TWILIO_ACCOUNT_SID"));	
//	logger.info("Account auth token env ============== "+ env.getProperty("TWILIO_AUTH_TOKEN"));	

	
//	logger.info("Account Sid: :::::::::::::: " + twillioConfig.getAccountSid() );
//		logger.info("Account Sid: :::::::::::::::::: " + twillioConfig.getAuthToken() );
	}
	
}
