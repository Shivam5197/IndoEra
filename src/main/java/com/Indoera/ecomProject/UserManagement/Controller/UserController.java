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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Indoera.ecomProject.UserManagement.Entity.UserDTO;
import com.Indoera.ecomProject.UserManagement.Entity.Users;
import com.Indoera.ecomProject.UserManagement.Service.UserService;
import com.Indoera.ecomProject.Utils.APIResponseModal;
import com.Indoera.ecomProject.Utils.Constants;
import com.Indoera.ecomProject.Utils.Utils;
import com.Indoera.ecomProject.Utils.Mail.MailService;

/**
 * @author shiva
 * Added on 15-May-2021
 * Package  com.Indoera.ecomProject.UserManagement.Controller
 */

@Controller
@RequestMapping("/indoUser")
public class UserController {
	
	private static final Logger logger = LogManager.getLogger(UserController.class);

	private static final String storeManagerPage = "User/Seller/sellerDashboard";	
	private static final String AdminPage = "Admin/adminHome";	
	private static final String customerHome = "redirect:/Indoera/home";	
	
	
	@Autowired
	private MailService mailService;

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/showSignupForm", method = RequestMethod.GET)
	public String signUPForm(Model theModel) {
		Users user = new Users();
		theModel.addAttribute("userForm", user);
		return "User/signUp";
	}
	
	@RequestMapping(value = "/stores", method = {RequestMethod.POST,RequestMethod.GET})
	public String storesPage(Model theModel , HttpSession session) {
		String returnpath = null;
		if(Utils.isNotNull(session)) {
			Users user = (Users) session.getAttribute("loggedInUser");
			theModel.addAttribute("storesList",user);
			returnpath =  "User/Seller/sellerStoreList";
		}else {
			returnpath = customerHome;
		}
		return returnpath;
	}
	
	
	@RequestMapping(value = "/admin-indo", method = RequestMethod.GET)
	public String adminhomePage(Model theModel,HttpSession session) {

		Users user = (Users) session.getAttribute("loggedInUser");
		if(Utils.isNotNull(user)) {
			if(user.getRole() == Constants.userRole.ADMIN) {
			theModel.addAttribute("userForm", user);
			return AdminPage;
			}else {
				return "/error";
			}
		}else {
			return "redirect:/Indoera/home";
		}
	}

	@RequestMapping(value = "/sales-indo", method = RequestMethod.GET)
	public String storehomePage(Model theModel,HttpSession session) {

		Users user = (Users) session.getAttribute("loggedInUser");
		if(Utils.isNotNull(user)) {
			if(user.getRole() == Constants.userRole.STOREOWNER) {
			theModel.addAttribute("userForm", user);
			return storeManagerPage;
			}else {
				return "/error";
			}
		}else {
			return "redirect:/Indoera/home";
		}
	}

	@RequestMapping(value = "/register-Saller")
	public String registerSellerPage(Model theModel) {
		Users user = new Users();
		theModel.addAttribute("sellerForm",user);
		
		return "User/Seller/sellerSignUp";
	}
		
	@ResponseBody
	@RequestMapping(value = "/saveUser" , method = {RequestMethod.GET,RequestMethod.POST})
	public APIResponseModal saveUser(@RequestBody String passWord,  HttpSession session ) {
		APIResponseModal apiresponseModel = new Utils().getDefaultApiResponse();
		List<String> errorList =null;
		try {
			if(Utils.isNotNull(passWord)) {
				errorList = new ArrayList<String>();
				UserDTO user = (UserDTO)session.getAttribute("signUpUser");
				if(Utils.isNotNull(user)) {
					user.setPassword(passWord);
					userService.SaveUser(user, errorList);
					if(!Utils.isNotNull(errorList)) {
						apiresponseModel.setMessage("User is saved Successfully !!! ");
						apiresponseModel.setStatus(HttpStatus.OK);
						apiresponseModel.setData(user.toString());
						session.invalidate();
					}
				}else {
				logger.info("SEssion is invalid");	
				}
			}else {
				apiresponseModel.setMessage("Please Enter your password !");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception occured at saving the student :: " + e.getMessage());
			apiresponseModel.setMessage("");
		}	
		return apiresponseModel;
	}
	
	@ResponseBody
	@RequestMapping(value="/validate-phn",method = RequestMethod.POST)
	public APIResponseModal checkPhonePresent(@RequestBody String phoneNumber) {
		logger.info("Check Phone MEthod");
		logger.info(phoneNumber);
		List<String> errorList = new ArrayList<String>();
		APIResponseModal apiResponse = new Utils().getDefaultApiResponse();
		try {
			if(Utils.isNotNull(phoneNumber)) {

				Boolean isExists = userService.phoneNumberExists("+"+phoneNumber, errorList);
				if(isExists ==true) {
					apiResponse.setMessage("Number already Present please login with OTP !");
					apiResponse.setStatus(HttpStatus.BAD_REQUEST);
				}else {
					apiResponse.setMessage("Number is New ");
					apiResponse.setStatus(HttpStatus.OK);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setMessage("Number is New ");
			apiResponse.setStatus(HttpStatus.OK);
		}
		return apiResponse;
	}
	
	@ResponseBody
	@RequestMapping(value="/validate-usNa",method = RequestMethod.POST)
	public APIResponseModal checkUserPresent(@RequestBody String userName) {
		logger.info("Check Phone MEthod");
		logger.info(userName);
		List<String> errorList = new ArrayList<String>();
		APIResponseModal apiResponse = new Utils().getDefaultApiResponse();
		try {
			if(Utils.isNotNull(userName)) {

				Boolean isExists = userService.userNameExists(userName, errorList);
				if(isExists ==true) {
					apiResponse.setMessage("This username is already taken try another you can try with : " + Utils.RandomAlphaString());
					apiResponse.setStatus(HttpStatus.BAD_REQUEST);
				}else {
					apiResponse.setMessage("UserName is Unique");
					apiResponse.setStatus(HttpStatus.OK);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setMessage("UserName is Unique");
			apiResponse.setStatus(HttpStatus.OK);
		}
		return apiResponse;
	}
	
	@ResponseBody
	@RequestMapping(value="/validate-eml",method = RequestMethod.POST)
	public APIResponseModal checkEmailPresent(@RequestBody String email) {
		logger.info("Check Email MEthod");
		logger.info(email);
		List<String> errorList = new ArrayList<String>();
		APIResponseModal apiResponse = new Utils().getDefaultApiResponse();
		try {
			if(Utils.isNotNull(email)) {

				Boolean isExists =userService.emailExists(email, errorList);
				if(isExists ==true) {
					apiResponse.setMessage("This Email account is Already registered with us? try using forget password !");
					apiResponse.setStatus(HttpStatus.BAD_REQUEST);
				}else {
					apiResponse.setMessage("Email is Unique");
					apiResponse.setStatus(HttpStatus.OK);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setMessage("Email is Unique");
			apiResponse.setStatus(HttpStatus.OK);
		}
		return apiResponse;
	}
	
	@ResponseBody
	@RequestMapping(value = "/mailsend",method = {RequestMethod.GET,RequestMethod.POST})
	public APIResponseModal sendMailToUser(@ModelAttribute UserDTO user, HttpSession session ) {
		APIResponseModal apiResponse = new Utils().getDefaultApiResponse();
		List<String> errorList = new ArrayList<String>();
		try {
			if(Utils.isNotNull(user)) {
				mailService.sendMail(user.getEmail(), user.getUserName(),errorList);

				if(!Utils.isNotNull(errorList)) {
				apiResponse.setMessage("Hello "+user.getFirstName()+" "+user.getLastName()+" We have send you a verification mail to "+user.getEmail()+ " Please Check your Email"
						+ " to get Access to the Profile !!");
				apiResponse.setStatus(HttpStatus.OK);		
				apiResponse.setData(user.toString());
				session.setAttribute("signUpUser", user);
				}else {
					apiResponse.setMessage(errorList.toString());
					apiResponse.setStatus(HttpStatus.BAD_REQUEST);		
					apiResponse.setData("");
				}
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return apiResponse;
	}
	
	@RequestMapping(value="/setpas",method = RequestMethod.GET)
	public String passwordSetPage(Model theModel,HttpSession session) {
		String returnPath = "";
		UserDTO user = (UserDTO)session.getAttribute("signUpUser");
//		logger.info("Currentle Logged in user is :" + user);
		Users us = new Users();
		if(Utils.isNotNull(user)) {
			theModel.addAttribute(us);
			returnPath = "User/passSet";
		}else {
			returnPath = "redirect:/Indoera/home";
		}
		return returnPath;
	}
	
	@ResponseBody
	@RequestMapping(value = "/validatelogin", method = {RequestMethod.POST})
	public APIResponseModal validateLogin(@ModelAttribute UserDTO userDto, HttpSession session) {
		APIResponseModal apiResponse = new Utils().getDefaultApiResponse();
		List<String> errorList = new ArrayList<String>();
		Users user = new Users();
		try {
			if(Utils.isNotNull(session)) {
				if(Utils.isNotNull(userDto.getUserName()) && userDto.getUserName() !="" && Utils.isNotNull(userDto.getPassword()) && userDto.getPassword() !="") {
					user =	userService.validateUser(userDto, errorList);
					if(errorList.isEmpty()) {
						if(Utils.isNotNull(user)) {
							
							if(user.getRole()==Constants.userRole.ADMIN) {
								apiResponse.setData(user.toString());
								apiResponse.setMessage("Welcome To IndoEra Cheif");
								apiResponse.setStatus(HttpStatus.OK);
							}else if(user.getRole() == Constants.userRole.STOREOWNER) {
								apiResponse.setData(user.toString());
								apiResponse.setMessage("Welcome To IndoEra");
								apiResponse.setStatus(HttpStatus.OK);
							}else {
								apiResponse.setData(user.toString());
								apiResponse.setMessage("Welcome To IndoEra");
								apiResponse.setStatus(HttpStatus.OK);
							}
						session.setAttribute("loggedInUser", user);	
						}else {
							apiResponse.setMessage(errorList.toString());
						}
					}else {
						errorList.add(errorList.toString());//if errorList is not Empty from Validate login method
						logger.info(errorList.toString());
						apiResponse.setMessage(errorList.toString());
					}
				}else {
					logger.info("Please enter User Name and Password");
					apiResponse.setMessage("Please enter User Name and Password");
				}
			}else {
				apiResponse.setMessage("You are already logged in Please refresh your Page");
			}
		} catch (Exception e) {
			e.printStackTrace();
			apiResponse.setMessage("We are having trouble to log you In");
		}
		return apiResponse;
	}
		
	@ResponseBody
	@RequestMapping(value = "/saveSeller",method = RequestMethod.POST)
	public APIResponseModal saveSellerDetails(@ModelAttribute UserDTO userDto, HttpSession session) {
	//	logger.info(")()))) "+userDto);
		APIResponseModal apiResponseModal = new Utils().getDefaultApiResponse();
		
		ArrayList<String> errorList = null;	
		try {
			if(Utils.isNotNull(userDto)) {
				errorList= new ArrayList<String>();
				//Setting the Blanked Details Here
				userDto.setCountry("India");
				userDto.setRole(Constants.userRole.STOREOWNER);
//				logger.info("Updated USer :: " + userDto);
				userService.SaveUser(userDto, errorList);
				if(!Utils.isNotNull(errorList)) {
					apiResponseModal.setMessage("Your Account is Succesfully Created Please Login using your Entered UserName and Password !! \n You will be "
							+ "Redirected to the Home shortly !");
					apiResponseModal.setStatus(HttpStatus.OK);
					apiResponseModal.setData(userDto.toString());
				}else {
					apiResponseModal.setMessage(errorList.toString());
					apiResponseModal.setStatus(HttpStatus.BAD_REQUEST);
					apiResponseModal.setData(userDto.toString());
				}
			}else {
				apiResponseModal.setMessage("Please Enter Required Detials !!");
			}
		} catch (Exception e) {
			apiResponseModal.setMessage("Somthing Went Wrong We are looking into it !! Please try agian after sometime.");
			e.printStackTrace();
		}
		return apiResponseModal;
	}
	
	
	
	@RequestMapping(value = "/ListPage")
	public String allUsers(Model theModel) {
		List<Users> users = null;
		Users user = new Users();
		List<String> errorList = new ArrayList<String>(); 
		try {
			users = userService.getAllUsers(user, errorList);
			logger.info(users);
			theModel.addAttribute("theListOFUSeer",users);
		} catch (Exception e) {
			logger.info("Exception occuerd at Get StundetLIST CONTROLLER ");
		}
		return "User/test";
	}

	@RequestMapping(value = "/logout",method = {RequestMethod.POST,RequestMethod.GET})
	public String logoutUser(HttpSession session) {
		
		if(Utils.isNotNull(session)) {
			session.invalidate();
		}
		return customerHome;
	}
	
	
	
}
