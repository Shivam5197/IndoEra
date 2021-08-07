/**
 * 
 */
package com.Indoera.ecomProject.UserManagement.ServiceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.Indoera.ecomProject.UserManagement.Entity.UserDTO;
import com.Indoera.ecomProject.UserManagement.Entity.Users;
import com.Indoera.ecomProject.UserManagement.Service.UserService;
import com.Indoera.ecomProject.Utils.Constants;
import com.Indoera.ecomProject.Utils.Utils;

/**
 * @author shiva
 * Added on 15-May-2021
 * Package  com.Indoera.ecomProject.UserManagement.ServiceImpl
 */
@Repository
public class UserServiceImpl implements UserService {

	private EntityManager entityManager;

	@Autowired
	public UserServiceImpl (EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Override
	@Transactional
	public void SaveUser(UserDTO userDto, List<String> errorList) {
		Users user = null;
		try {
			if(Utils.isNotNull(userDto)) {
				user = new Users();
				if(Utils.isNotNull(userDto.getFirstName())) {
					user.setFirstName(userDto.getFirstName());
				}				
				if(Utils.isNotNull(userDto.getLastName())) {
					user.setLastName(userDto.getLastName());
				}
				if(Utils.isNotNull(userDto.getDateOfBirth())) {
					user.setDateOfBirth(userDto.getDateOfBirth());
				}
				if(Utils.isNotNull(userDto.getEmail())) {
					user.setEmail(userDto.getEmail());
				}else {
					errorList.add("Email is required !");
				}
				if(Utils.isNotNull(userDto.getUserName())) {
					user.setUserName(userDto.getUserName());
				}else {
					errorList.add("User name is required ! & Should be unique ");
				}				
				if(Utils.isNotNull(userDto.getPassword())) {
					user.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
				}else {
					errorList.add("Password is required !");
				}
				if(Utils.isNotNull(userDto.getCountry())) {
					user.setCountry(userDto.getCountry());
				}else {
					errorList.add("Country is required !");
				}
				if(Utils.isNotNull(userDto.getState())) {
					user.setState(userDto.getState());
				}else {
					errorList.add("State is required !");
				}
				if(Utils.isNotNull(userDto.getCity())) {
					user.setCity(userDto.getCity());
				}else {
					errorList.add("City is required !");
				}
				if(Utils.isNotNull(userDto.getZipCode())) {
					user.setZipCode(userDto.getZipCode());
				}else {
					errorList.add("ZipCode is required !");
				}
				if(Utils.isNotNull(userDto.getAddress())) {
					user.setAddress(userDto.getAddress());
				}else {
					errorList.add("Address is required !");
				}
				if(Utils.isNotNull(userDto.getPhoneNumber())) {
					user.setPhoneNumber("+"+userDto.getPhoneNumber());
				}else {
					errorList.add("Phone Number is required !");
				}
				if(Utils.isNotNull(userDto.getRole())) {
					user.setRole(userDto.getRole());
				}else {
					user.setRole(Constants.userRole.CUSTOMER);
				}
				if(Utils.isNotNull(userDto.getGender())) {
					user.setGender(userDto.getGender());
				}else {
					user.setGender(null);
				}
				user.setUniqueUserId(userDto.getUserName().substring(0,2)+Utils.RandomAlphaString());
				user.setAddedAt(new java.sql.Timestamp(System.currentTimeMillis()));
				user.setStatus(Constants.userStatus.ACTIVE);

				entityManager.merge(user);
				logger.info("Congrats !!!!!!!! User is Saved HURRRAAY !");
			}else {
				errorList.add("Please enter all Required details");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception Occured at saving the USER :: " + e.getMessage());
			errorList.add("Error Occured at our End");
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Users> getAllUsers(Users userModel,List<String> errorList) {
		
		List<Users> allUsersNotRoleSpecific = null;
		try { 											
			StringBuilder qryStr= new StringBuilder("SELECT u from Users u WHERE u.id !=0 AND u.status= "+Constants.userStatus.ACTIVE );
			if(Utils.isNotNull(userModel)) {
				if(Utils.isNotNull(userModel.getId())) {
					qryStr.append(" AND u.id=:id");
				}			
				if(Utils.isNotNull(userModel.getUniqueUserId())) {
					qryStr.append(" AND u.uniqueUserId=:uniqueUserId");
				}
				if(Utils.isNotNull(userModel.getFirstName())) {
					qryStr.append(" AND u.firstName=:firstName");
				}
				if(Utils.isNotNull(userModel.getLastName())) {
					qryStr.append(" AND u.lastName=:lastName");
				}
				if(Utils.isNotNull(userModel.getDateOfBirth())) {
					qryStr.append(" AND u.dateOfBirth=:dateOfBirth");
				}
				if(Utils.isNotNull(userModel.getEmail())) {
					qryStr.append(" AND u.email=:email");
				}
				if(Utils.isNotNull(userModel.getUserName())) {
					qryStr.append(" AND u.userName=:userName");
				}
				if(Utils.isNotNull(userModel.getStatus())) {
					qryStr.append(" AND u.status=:status");
				}
				if(Utils.isNotNull(userModel.getRole())) {
					qryStr.append(" AND u.role=:role");
				}
				if(Utils.isNotNull(userModel.getCountry())) {
					qryStr.append(" AND u.country=:country");
				}
				if(Utils.isNotNull(userModel.getState())) {
					qryStr.append(" AND u.state=:state");
				}
				if(Utils.isNotNull(userModel.getCity())) {
					qryStr.append(" AND u.city=:city");
				}
				if(Utils.isNotNull(userModel.getZipCode())) {
					qryStr.append(" AND u.zipCode=:zipCode");
				}
				if(Utils.isNotNull(userModel.getAddress())) {
					qryStr.append(" AND u.address=:address");
				}
				if(Utils.isNotNull(userModel.getPhoneNumber())) {
					qryStr.append(" AND u.phoneNumber=:phoneNumber");
				}
				if(Utils.isNotNull(userModel.getAddedAt())) {
					qryStr.append(" AND u.addedAt=:addedAt");
				}
			}else {
				errorList.add("No Users Found !");
				logger.info("USER MODEL IS NULL !");
			}
			Query query = entityManager.createQuery(qryStr.toString());

			if(Utils.isNotNull(userModel)) {
				if(Utils.isNotNull(userModel.getId())) {
					query.setParameter("id",userModel.getId());
				}			
				if(Utils.isNotNull(userModel.getUniqueUserId())) {
					query.setParameter("uniqueUserId",userModel.getUniqueUserId());
				}
				if(Utils.isNotNull(userModel.getFirstName())) {
					query.setParameter("firstName",userModel.getFirstName());
				}
				if(Utils.isNotNull(userModel.getLastName())) {
					query.setParameter("lastName",userModel.getLastName());
				}
				if(Utils.isNotNull(userModel.getDateOfBirth())) {
					query.setParameter("dateOfBirth",userModel.getDateOfBirth());
				}
				if(Utils.isNotNull(userModel.getEmail())) {
					query.setParameter("email",userModel.getEmail());
				}
				if(Utils.isNotNull(userModel.getUserName())) {
					query.setParameter("userName",userModel.getUserName());
				}
				if(Utils.isNotNull(userModel.getStatus())) {
					query.setParameter("status",userModel.getStatus());
				}
				if(Utils.isNotNull(userModel.getRole())) {
					query.setParameter("role",userModel.getRole());
				}
				if(Utils.isNotNull(userModel.getCountry())) {
					query.setParameter("country",userModel.getCountry());
				}
				if(Utils.isNotNull(userModel.getState())) {
					query.setParameter("state",userModel.getState());
				}
				if(Utils.isNotNull(userModel.getCity())) {
					query.setParameter("city",userModel.getCity());
				}
				if(Utils.isNotNull(userModel.getZipCode())) {
					query.setParameter("zipCode",userModel.getZipCode());
				}
				if(Utils.isNotNull(userModel.getAddress())) {
					query.setParameter("address",userModel.getAddress());
				}
				if(Utils.isNotNull(userModel.getPhoneNumber())) {
					query.setParameter("phoneNumber",userModel.getPhoneNumber());
				}
				if(Utils.isNotNull(userModel.getAddedAt())) {
					query.setParameter("addedAt",userModel.getAddedAt());
				}
			}else {
				errorList.add("No User were Found !!");
			}		
			allUsersNotRoleSpecific = query.getResultList();
						
		} catch (Exception e) {
			e.printStackTrace();
			errorList.add("Error Occured at our End!! Please try again Later");
			logger.info("Error Occured at our End!! Please try again Later");
		}
		return allUsersNotRoleSpecific;
	}
	
	@Transactional
	@Override
	public  Boolean userNameExists(String userName,List<String> errorList) {
		Boolean isPresent = false;
		
		if(Utils.isNotNull(userName)) {
			Query query = entityManager.createQuery("SELECT u FROM Users u WHERE u.userName =: userNameuser ");
			query.setParameter("userNameuser", userName);
			Object usname = query.getSingleResult();
			Users user = (Users) usname;
			if(user.getUserName().equals(userName)) {
				isPresent = true;
			}else {
				isPresent =false;
			}
		}else {
			errorList.add("Please enter Username !!.. Caution = Try to write Unique UserName as it should not match with Any other user ");
		}
		return isPresent;
	}
	
	@Override
	@Transactional
	public Boolean phoneNumberExists(String phoneNumber, List<String> errorList) {
		Boolean isPresent = false;
		logger.info("PHONE NUMBER :: " + phoneNumber);
		if(Utils.isNotNull(phoneNumber)) {
			Query query = entityManager.createQuery("SELECT u FROM Users u WHERE u.phoneNumber =: phone ");
			query.setParameter("phone", phoneNumber);
			Object usname = query.getSingleResult();
			Users user = (Users) usname;
			if(user.getPhoneNumber().equals(phoneNumber)) {
				isPresent = true;
			}else {
				isPresent =false;
			}
		}else {
			errorList.add("Please enter your Phone Number !");
		}
		return isPresent;
	}

	@Override
	@Transactional
	public Boolean emailExists(String email, List<String> errorList) {
		Boolean isPresent = false;
		
		if(Utils.isNotNull(email)) {
			Query query = entityManager.createQuery("SELECT u FROM Users u WHERE u.email =: emailId ");
			query.setParameter("emailId", email);
			Object usname = query.getSingleResult();
			Users user = (Users) usname;
			if(user.getEmail().equals(email)) {
				isPresent = true;
			}else {
				isPresent =false;
			}
		}else {
			errorList.add("Please enter your Email ID !");
		}
		return isPresent;
	}

	@Override
	@Transactional
	public Users validateUser(UserDTO userDto, List<String> errorList) {
		Users user = null;
		try {
			Users userModel = new Users(userDto);
			if(Utils.isNotNull(userModel.getUserName()) && Utils.isNotNull(userModel.getPassword()) ) {
				List<Users> userList = getAllUsers(userModel, errorList);

				if(Utils.isNotNull(userList)) {
					if(Utils.isNotNull(userList) && userList.size() ==1) {// Have to fetch only one user
						user = userList.get(0);

						if(Utils.isNotNull(user) && new BCryptPasswordEncoder().matches(userDto.getPassword(), user.getPassword())) {
							//						return user;
						}else {
							errorList.add("Incorrect Password");
						}
					}else {
						errorList.add("Invalid Credentials !!");
					}
				}else {
					errorList.add("No User found with Entered Credentials !");
				}
			}else {
				errorList.add("Please enter User Name and Password");
			}
		}catch (Exception e) {
			e.printStackTrace();
			errorList.add("We are having trouble to log you In");
			logger.info("Exception in Validate login");
		}
		return user;
	}
	
	
}
