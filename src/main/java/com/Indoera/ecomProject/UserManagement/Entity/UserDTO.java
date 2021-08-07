/**
 * 
 */
package com.Indoera.ecomProject.UserManagement.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author shiva
 * Added on 14-May-2021
 * Package  com.Indoera.ecomProject.UserManagement.Entity
 */
public class UserDTO {

	private Integer id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String email;
	private String userName;
	private String password;
	private Integer status;
	private Integer role;
	private Integer gender;
	private String country;
	private String state;
	private String city;
	private String zipCode;
	private String address;
	private String phoneNumber;
	
	public UserDTO() {}
	
	public UserDTO( String firstName, String lastName, String dateOfBirth, String email, String userName,
			String password, Integer status, Integer role, String country, String state, String city, String zipCode,
			String address, String phoneNumber,Integer gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.role = role;
		this.country = country;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"firstName\":\"" + firstName + "\", \"lastName\":\"" + lastName
				+ "\", \"dateOfBirth\":\"" + dateOfBirth + "\", \"email\":\"" + email + "\", \"userName\":\"" + userName
				+ "\", \"password\":\"" + password + "\", \"status\":\"" + status + "\", \"role\":\"" + role
				+ "\", \"gender\":\"" + gender + "\", \"country\":\"" + country + "\", \"state\":\"" + state
				+ "\", \"city\":\"" + city + "\", \"zipCode\":\"" + zipCode + "\", \"address\":\"" + address
				+ "\", \"phoneNumber\":\"" + phoneNumber + "\"}";
	}

	
}
