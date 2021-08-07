/**
 * 
 */
package com.Indoera.ecomProject.UserManagement.Service;

import java.util.List;

import com.Indoera.ecomProject.UserManagement.Entity.UserDTO;
import com.Indoera.ecomProject.UserManagement.Entity.Users;

/**
 * @author shiva
 * Added on 15-May-2021
 * Package  com.Indoera.ecomProject.UserManagement.Service
 */
public interface UserService {

	public void SaveUser(UserDTO userDto,List<String> errorList);
	
	public List<Users> getAllUsers(Users user,List<String> errorList);
	
	public  Boolean userNameExists(String userName,List<String> errorList);

	public  Boolean phoneNumberExists(String phoneNymber,List<String> errorList);

	public  Boolean emailExists(String email,List<String> errorList);

	public Users validateUser(UserDTO userDto,List<String> errorList);
}