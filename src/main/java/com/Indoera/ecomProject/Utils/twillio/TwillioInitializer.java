package com.Indoera.ecomProject.Utils.twillio;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.Indoera.ecomProject.Store.ServiceImpl.StoreServiceImpl;
import com.twilio.Twilio;

@Configuration
public class TwillioInitializer{

	private static final Logger logger = LogManager.getLogger(TwillioInitializer.class);
	
	private final TwillioProperties twillioProperties;

	final String accountID = System.getenv("TWILIO_ACCOUNT_SID");
	final String authId = System.getenv("TWILIO_AUTH_TOKEN");
		
//use these Variables	

	
	@Autowired
	public TwillioInitializer(TwillioProperties twillioConfig) {
//		logger.info("::::: Account ID :" +accountID);
//		logger.info("::::: Account ID :" +authId);

		this.twillioProperties = twillioConfig;
		Twilio.init(accountID, authId);
		
	}
	
}
