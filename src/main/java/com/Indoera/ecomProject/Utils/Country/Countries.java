/**
 * 
 */
package com.Indoera.ecomProject.Utils.Country;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author shiva
 * Added on 15-May-2021
 * Package  com.Indoera.ecomProject.Utils.Country
 */

@Entity
@Table(name="country")
public class Countries implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7255975274557394855L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String countryName;
	@Column(name="phonecode")
	private Integer countryPhoneCode;
	@Column(name="iso3")
	private Character countryISOThree;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Integer getCountryPhoneCode() {
		return countryPhoneCode;
	}
	public void setCountryPhoneCode(Integer countryPhoneCode) {
		this.countryPhoneCode = countryPhoneCode;
	}
	public Character getCountryISOThree() {
		return countryISOThree;
	}
	public void setCountryISOThree(Character countryISOThree) {
		this.countryISOThree = countryISOThree;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"countryName\":\"" + countryName + "\", \"countryPhoneCode\":\""
				+ countryPhoneCode + "\", \"countryISOThree\":\"" + countryISOThree + "\"}";
	}
}
