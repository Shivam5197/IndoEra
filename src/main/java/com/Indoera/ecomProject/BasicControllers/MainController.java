package com.Indoera.ecomProject.BasicControllers;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Indoera.ecomProject.UserManagement.Entity.Users;
import com.Indoera.ecomProject.Utils.APIResponseModal;
import com.Indoera.ecomProject.Utils.Utils;

@Controller
@RequestMapping("/Indoera")
public class MainController {
	
	public static final Logger logger = LogManager.getLogger(MainController.class);
			
	@RequestMapping("/home")
	public String view() {
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getUser",method = {RequestMethod.GET,RequestMethod.POST})
	public APIResponseModal getUser(HttpSession session) {
		logger.info("I am called at main controller");
		APIResponseModal apiResponseModal = new Utils().getDefaultApiResponse();
		Users user = (Users) session.getAttribute("loggedInUser");
		try {
			if(Utils.isNotNull(user)) {
			apiResponseModal.setData(user.toString());
			apiResponseModal.setMessage("User Found");
			apiResponseModal.setStatus(HttpStatus.OK);
			}else {
				apiResponseModal.setData(null);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		logger.info("API ::: " + apiResponseModal);
		return apiResponseModal;
	}
	
	
	

	
}
