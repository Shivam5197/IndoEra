/**
 * 
 */
package com.Indoera.ecomProject.UserManagement.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Indoera.ecomProject.Store.Entity.Stores;
import com.Indoera.ecomProject.Store.Service.StoreService;
import com.Indoera.ecomProject.UserManagement.Entity.Users;
import com.Indoera.ecomProject.Utils.APIResponseModal;
import com.Indoera.ecomProject.Utils.Utils;

/**
 * @author shiva
 * Added on 23-Sep-2021
 * Package  com.Indoera.ecomProject.UserManagement.Controller
 */
@Controller
@RequestMapping(value="/seller")
public class SellerController {
	
	private static final Logger logger = LogManager.getLogger(SellerController.class);

	private StoreService storeService;

	@Autowired
	public SellerController(StoreService storeService) {
		this.storeService = storeService;
	}

	
	@ResponseBody
	@RequestMapping(value = "/yourStores",method = {RequestMethod.GET,RequestMethod.POST})
	public APIResponseModal getOwnerSpecificList(HttpSession session) {
		APIResponseModal apiResponse = new Utils().getDefaultApiResponse();
		List<String> errorList = new ArrayList<String>();
		Users user = (Users) session.getAttribute("loggedInUser");
		try {
			if(Utils.isNotNull(user)) {
				List<Stores> OwnerStores = storeService.getStoreUserSpecific(user, errorList);
				
				if(errorList.isEmpty() && !Utils.isNotNull(errorList)) {
					apiResponse.setMessage("Stores Found !!");
					apiResponse.setData(OwnerStores.toString());
					apiResponse.setStatus(HttpStatus.OK);
				}else {
					logger.info("Error List Not null");
				}
			}else {
				errorList.add("Please Login before trying");
				logger.info("userNull");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Catch");
			errorList.add("Something went wrong Please try again later");
		}
		return apiResponse;
	}
	
	
	@ResponseBody
	@RequestMapping( value = "/editStorePage/{storeid}" , method = {RequestMethod.GET,RequestMethod.POST})
	public  APIResponseModal getStoreDetails(@PathVariable Integer storeid,  HttpSession session) {
		APIResponseModal apiResponseModel = new Utils().getDefaultApiResponse();
//		logger.info("=====================                 :       "+storeid);
		Users user = (Users) session.getAttribute("loggedInUser");
		List<String> errorList = new ArrayList<String>();
		Stores store = null;

		try {
			store = storeService.getStoreDetails(user, storeid, errorList);	
			if(!Utils.isNotNull(errorList)) {
				apiResponseModel.setData(store.toString());
				apiResponseModel.setStatus(HttpStatus.OK);
				apiResponseModel.setMessage("Store fetched successfully!!!!");
			}else {
				apiResponseModel.setData(null);
				apiResponseModel.setStatus(HttpStatus.EXPECTATION_FAILED);
				apiResponseModel.setMessage(errorList.toString());
			}			
		} catch (Exception e) {
			e.printStackTrace();
			errorList.add("Something Went Wrong !! Please try after some time ");
		}
//		logger.info("Store Details Fetched :    "+apiResponseModel.toString());
		return apiResponseModel;
	}
	
	
	
}
