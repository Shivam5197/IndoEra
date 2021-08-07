/**
 * 
 */
package com.Indoera.ecomProject.UserManagement.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.Indoera.ecomProject.Store.Entity.Stores;
/**
 * @author shiva
 * Added on 14-May-2021
 * Package  com.Indoera.ecomProject.UserManagement.Entity
 */

@Entity
@Table(name="indo_users")
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7142538021673305659L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="unique_user_id")
	private String uniqueUserId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="date_birth")
	private String dateOfBirth;
	@Column(name="email")
	private String email;
	@Column(name="user_name")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="status")
	private Integer status;
	@Column(name="role")
	private Integer role;
	@Column(name="country")
	private String country;
	@Column(name="state")
	private String state;
	@Column(name="city")
	private String city;
	@Column(name="zip_code")
	private String zipCode;
	@Column(name="address")
	private String address;
	@Column(name="gender")
	private Integer gender;
	@Column(name="phone_no")
	private String phoneNumber;
	@Column(name="added_at")
	private Timestamp addedAt;
	
	@OneToMany(mappedBy = "storeOwner" ,cascade = CascadeType.ALL)
	private List<Stores> userStores;
	
	public Users() {
		
	}
	
	public Users(String uniqueUserId, String firstName, String lastName, String dateOfBirth, String email,
			String userName, String password, Integer status, Integer role, String country, String state, String city,
			String zipCode, String address, String phoneNumber,Timestamp addedAt,Integer gender) {
		this.uniqueUserId = uniqueUserId;
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
		this.addedAt = addedAt;
		this.gender = gender;
	}
	
	public Users(UserDTO userDto) {
		this.firstName = userDto.getFirstName();
		this.lastName = userDto.getLastName();
		this.dateOfBirth = userDto.getDateOfBirth();
		this.email = userDto.getEmail();
		this.userName = userDto.getUserName();
		this.password = userDto.getPassword();
		this.status = userDto.getStatus();
		this.role = userDto.getRole();
		this.country = userDto.getCountry();
		this.state = userDto.getState();
		this.city = userDto.getCity();
		this.zipCode = userDto.getZipCode();
		this.address = userDto.getAddress();
		this.phoneNumber = userDto.getPhoneNumber();
		this.gender = userDto.getGender();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUniqueUserId() {
		return uniqueUserId;
	}

	public void setUniqueUserId(String uniqueUserId) {
		this.uniqueUserId = uniqueUserId;
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

	public Timestamp getAddedAt() {
		return addedAt;
	}

	public void setAddedAt(Timestamp addedAt) {
		this.addedAt = addedAt;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public List<Stores> getUserStores() {
		return userStores;
	}

	public void setUserStores(List<Stores> userStores) {
		this.userStores = userStores;
	}


	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"uniqueUserId\":\"" + uniqueUserId + "\", \"firstName\":\"" + firstName
				+ "\", \"lastName\":\"" + lastName + "\", \"dateOfBirth\":\"" + dateOfBirth + "\", \"email\":\"" + email
				+ "\", \"userName\":\"" + userName + "\", \"status\":\"" + status + "\", \"role\":\"" + role
				+ "\", \"country\":\"" + country + "\", \"state\":\"" + state + "\", \"city\":\"" + city
				+ "\", \"zipCode\":\"" + zipCode + "\", \"address\":\"" + address + "\", \"gender\":\"" + gender
				+ "\", \"phoneNumber\":\"" + phoneNumber + "\", \"addedAt\":\"" + addedAt + "\"}";
	}

	public void store(Stores tempStores) {
		if(userStores ==null) {
			userStores = new ArrayList<Stores>();
		}
		userStores.add(tempStores);
		tempStores.setStoreOwner(this);
	}
	
	
}
