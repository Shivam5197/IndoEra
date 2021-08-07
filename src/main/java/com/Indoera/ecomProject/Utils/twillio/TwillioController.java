/**
 * 
 */
package com.Indoera.ecomProject.Utils.twillio;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Indoera.ecomProject.UserManagement.ServiceImpl.UserServiceImpl;
import com.Indoera.ecomProject.Utils.APIResponseModal;
import com.Indoera.ecomProject.Utils.Utils;

/**
 * @author shiva
 * Added on 24-Jun-2021
 * Package  com.Indoera.ecomProject.Utils.twillio
 */

@Controller
@RequestMapping("/Otp")
public class TwillioController {

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	PhoneVerificationService phoneVerificationService;

	String	mainSellerPhoneNumber="";	
	
	@ResponseBody
	@RequestMapping(value = "/sendOTPtoSeller" , method = RequestMethod.POST)
	public APIResponseModal sendSellerOTP(@RequestBody String sellerPhoneNumner) {
		APIResponseModal apiResponseModal = new Utils().getDefaultApiResponse();

		try {
			if(Utils.isNotNull(sellerPhoneNumner)) {
				mainSellerPhoneNumber = "+91"+sellerPhoneNumner;
				VerificationResult verificationResult = phoneVerificationService.startVerification(mainSellerPhoneNumber); 
				if(verificationResult.isValid()) {
					apiResponseModal.setStatus(HttpStatus.OK);
					apiResponseModal.setMessage("Otp Sent SuccessFully !!");
					apiResponseModal.setData("");
				}else {
					apiResponseModal.setStatus(HttpStatus.BAD_REQUEST);
					apiResponseModal.setMessage("Incorrect Phone Number !!");
					apiResponseModal.setData("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponseModal;
	}

	@ResponseBody
	@RequestMapping(value = "/verifyOTP",method = RequestMethod.POST)
	public APIResponseModal apiResponseModel(@RequestBody String otp) {
		APIResponseModal apiResponseModal = new Utils().getDefaultApiResponse();
//	logger.info("SELLER PHONE NUMERB :  " +mainSellerPhoneNumber);
//	logger.info("OTP :  " +otp);
		try {
			if(Utils.isNotNull(otp)) {
			    VerificationResult result=phoneVerificationService.checkverification(mainSellerPhoneNumber,otp);
			    mainSellerPhoneNumber = "";
			    if(result.isValid()) {
			    	apiResponseModal.setData("");
			    	apiResponseModal.setMessage("Congrats !! Your Number is Verified with Us !!");
			    	apiResponseModal.setStatus(HttpStatus.OK);
			    }else {
			    	apiResponseModal.setStatus(HttpStatus.FORBIDDEN);
			    	apiResponseModal.setMessage(result.getErrors().toString());
			    }
			}else {
				apiResponseModal.setStatus(HttpStatus.BAD_REQUEST);
				apiResponseModal.setMessage(" Please ENTER OTP  !!");
				apiResponseModal.setData("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResponseModal;
	}
	
}
