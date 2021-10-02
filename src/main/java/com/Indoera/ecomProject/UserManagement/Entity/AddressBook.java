/**
 * 
 */
package com.Indoera.ecomProject.UserManagement.Entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author shiva
 * Added on 21-Aug-2021
 * Package  com.Indoera.ecomProject.UserManagement.Entity
 */
@Entity
@Table(name = "users_address")
public class AddressBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private Integer addressID;
	@Column(name="zip_code")
	private Integer zipCode;
	@Column(name="state")
	private String state;
	@Column(name="city")
	private String city;
	@Column(name="address")
	private String address;
	@Column(name="country")
	private String country;
	@Column(name="added_at")
	private Timestamp added_at;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "address_of_user")
	private Users addressOf;
	
	
	public AddressBook() {
		
	}

	public AddressBook(Integer zipCode, String state, String city, String address, String country, Timestamp added_at) {
		this.zipCode = zipCode;
		this.state = state;
		this.city = city;
		this.address = address;
		this.country = country;
		this.added_at = added_at;
	}

	public Integer getAddressID() {
		return addressID;
	}

	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Timestamp getAdded_at() {
		return added_at;
	}

	public void setAdded_at(Timestamp added_at) {
		this.added_at = added_at;
	}

	public Users getAddressOf() {
		return addressOf;
	}

	public void setAddressOf(Users addressOf) {
		this.addressOf = addressOf;
	}

	@Override
	public String toString() {
		return "{\"addressID\":\"" + addressID + "\", \"zipCode\":\"" + zipCode + "\", \"state\":\"" + state
				+ "\", \"city\":\"" + city + "\", \"address\":\"" + address + "\", \"country\":\"" + country
				+ "\", \"added_at\":\"" + added_at + "\", \"addressOf\":\"" + addressOf + "\"}";
	}
		
}


