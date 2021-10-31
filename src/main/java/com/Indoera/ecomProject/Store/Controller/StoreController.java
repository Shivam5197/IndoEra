package com.Indoera.ecomProject.Store.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Indoera.ecomProject.Store.Entity.Stores;
import com.Indoera.ecomProject.Store.Entity.StoresDTO;
import com.Indoera.ecomProject.Store.Service.StoreService;
import com.Indoera.ecomProject.UserManagement.Entity.Users;
import com.Indoera.ecomProject.Utils.APIResponseModal;
import com.Indoera.ecomProject.Utils.Constants;
import com.Indoera.ecomProject.Utils.Utils;

@Controller
@RequestMapping("/store")
public class StoreController {

	private static final Logger logger = LogManager.getLogger(StoreController.class);
	private StoreService storeService;

	@Autowired
	public StoreController(StoreService storeService) {
		this.storeService = storeService;
	}

	@RequestMapping(value="/storeslist" ,method = RequestMethod.GET )
	public String listofStores(Model theModel) {
		List<Stores> stores = new ArrayList<Stores>();
		stores = storeService.getAllStores();
		theModel.addAttribute("storeList",stores);
		return "User/test";
	}
	
	@RequestMapping(value = "/storeFormshow" ,method = RequestMethod.GET)
	public String addStoreForm(Model theModel, HttpSession session) {
		Users user = (Users) session.getAttribute("loggedInUser");
		if(Utils.isNotNull(user)) {
			if(user.getRole() == Constants.userRole.STOREOWNER) {
				logger.info(" Seller Name is  :::::: " +user);
				Stores storeObj = new Stores();
				theModel.addAttribute("storeForm",storeObj);
				return "Store/storeForm";
			}else {
				return "redirect:/Indoera/home";
			}
		}else {
			return "redirect:/Indoera/home";
		}
	}
	

	@ResponseBody
	@RequestMapping(value = "/saveStore" , method = {RequestMethod.POST})
	public APIResponseModal saveStore(@ModelAttribute StoresDTO store,HttpSession session) throws BindException {
		
		Stores storeModal  = new Stores();
		String logopath = "";
		APIResponseModal apiResponse = new Utils().getDefaultApiResponse();
		List<String> errorList = new ArrayList<String>();
		try {
			if(store !=null){
				Users user = (Users) session.getAttribute("loggedInUser");
				if(Utils.isNotNull(user)) {
					if(user.getRole() == Constants.userRole.STOREOWNER) {
						storeModal = new Stores(store);				
						logopath = Utils.storeLogoPath(store.getLogoFile());
						storeService.saveUpdateStore(storeModal,user,errorList,logopath);
						if(errorList.isEmpty() && !Utils.isNotNull(errorList)) {
							apiResponse.setStatus(HttpStatus.OK);
							apiResponse.setData(storeModal.toString());
							apiResponse.setMessage("Store Saved Successfully !!");
						}else {
							apiResponse.setMessage("Failed to save store !!");
						}
					}else {
						errorList.add("You are not registered with us as Seller");
					}
				}else {
					errorList.add("Please login before Adding a Store");
				}
			}			
		}catch (Exception e) {
			e.printStackTrace();
			apiResponse.setStatus(HttpStatus.BAD_REQUEST);
			apiResponse.setMessage("Error Occured at our end !!");			
		}
		return apiResponse;
	}

	@ResponseBody
	@RequestMapping(value="/updateStore/{storeId}", method = {RequestMethod.GET,RequestMethod.POST})
	public APIResponseModal updateStoredetails(@PathVariable Integer storeId, @ModelAttribute StoresDTO storeDto, HttpSession session) {

		logger.info("Update me aaya hu m Id lekr : " + storeId);	
		logger.info("Update me aaya hu m updated details  lekr : " + storeDto);	
		Stores storeModel = new Stores();
		APIResponseModal apiResponseModel = new Utils().getDefaultApiResponse();
		String logopath = "";
		List<String> errorList = new ArrayList<>();
		if(storeModel !=null) {
			Users user = (Users) session.getAttribute("loggedInUser");
			if(Utils.isNotNull(user)) {
				if(user.getRole() == Constants.userRole.STOREOWNER) {
					storeModel = new Stores(storeDto);		
					storeModel.setId(storeId);
					logopath = Utils.storeLogoPath(storeDto.getLogoFile());
					storeService.saveUpdateStore(storeModel,user,errorList,logopath);
					if(errorList.isEmpty() && !Utils.isNotNull(errorList)) {
						apiResponseModel.setStatus(HttpStatus.OK);
						apiResponseModel.setData(storeModel.toString());
						apiResponseModel.setMessage("Store Saved Successfully !!");
					}else {
						apiResponseModel.setMessage("Failed to save store !!");
					}
				}else {
					errorList.add("You are not registered with us as Seller");
				}
			}else {
				errorList.add("Please login before Adding a Store");
			}
		}
	return apiResponseModel;	
	}
	


}
