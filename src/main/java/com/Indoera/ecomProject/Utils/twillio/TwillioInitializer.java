package com.Indoera.ecomProject.Utils.twillio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwillioInitializer {

	private static final Logger logger = LoggerFactory.getLogger(TwillioInitializer.class);
	private final TwillioProperties twillioProperties;
	
	@Autowired
	public TwillioInitializer(TwillioProperties twillioConfig) {
		this.twillioProperties = twillioConfig;
		Twilio.init(twillioConfig.getAccountSid(), 
						twillioConfig.getAuthToken());
	
//		logger.info("Account Sid: :::::::::::::: " + twillioConfig.getAccountSid() );
//		logger.info("Account Sid: :::::::::::::::::: " + twillioConfig.getAuthToken() );
		
		
	}
	
}
