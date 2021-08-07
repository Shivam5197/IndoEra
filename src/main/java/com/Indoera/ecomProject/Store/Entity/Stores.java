package com.Indoera.ecomProject.Store.Entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.Indoera.ecomProject.Products.Entity.ProductsCategory;
import com.Indoera.ecomProject.UserManagement.Entity.Users;

@Entity
@Table(name="stores")
public class Stores {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="store_name")
	private String storeName;
	@Column(name="store_unique_code")
	private String uniqueStoreCode;
	@Column(name="country")
	private String country;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="address")
	private String address;
	@Column(name="zipcode")
	private Integer zipCode;
	@Column(name="store_description")
	private String storeDescription;
	@Column(name="added_at")
	private Timestamp addedAt;
	@Column(name="store_logo")
	private String logoURL;
	@Column(name="store_status")
	private Integer storeStatus;
	@Column(name="store_email")
	private String storeEmail;
	@Column(name="gstin_number")
	private String gstinNumber;
	@Column(name="store_bank_account_holder_name")
	private String storeAccountHolderName;
	@Column(name="store_bank_number")
	private String storeAccountNumber;

	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "store_owner")
	private Users storeOwner;
	
	
	@OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "selling_producsts_category")
	private ProductsCategory productSellCategory;
	
	
	//Empty constructor
	public Stores() {
		
	}
	
	//DTO Constructur
	public Stores(StoresDTO storeDto) {
		this.storeDescription = storeDto.getStoreDescription();
		this.storeName = storeDto.getStoreName();
		this.country = storeDto.getCountry();
		this.city = storeDto.getCity();
		this.state = storeDto.getState();
		this.address = storeDto.getAddress();
		this.zipCode = storeDto.getZipCode();
	}

	//Constructor using fields
	public Stores(String storeName, String uniqueStoreCode, String country, String city, String state, String address,
			Integer zipCode, String storeDescription, Timestamp addedAt, String logoURL, Integer storeStatus,
			String storeEmail, String gstinNumber, String storeAccountHolderName, String storeAccountNumber) {
		this.uniqueStoreCode = uniqueStoreCode;
		this.country = country;
		this.city = city;
		this.state = state;
		this.address = address;
		this.zipCode = zipCode;
		this.storeDescription = storeDescription;
		this.addedAt = addedAt;
		this.logoURL = logoURL;
		this.storeStatus = storeStatus;
		this.storeEmail = storeEmail;
		this.gstinNumber = gstinNumber;
		this.storeAccountHolderName = storeAccountHolderName;
		this.storeAccountNumber = storeAccountNumber;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getUniqueStoreCode() {
		return uniqueStoreCode;
	}

	public void setUniqueStoreCode(String uniqueStoreCode) {
		this.uniqueStoreCode = uniqueStoreCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getStoreDescription() {
		return storeDescription;
	}

	public void setStoreDescription(String storeDescription) {
		this.storeDescription = storeDescription;
	}

	public Timestamp getAddedAt() {
		return addedAt;
	}

	public void setAddedAt(Timestamp addedAt) {
		this.addedAt = addedAt;
	}

	public String getLogoURL() {
		return logoURL;
	}

	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}

	public Integer getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(Integer storeStatus) {
		this.storeStatus = storeStatus;
	}

	public String getStoreEmail() {
		return storeEmail;
	}

	public void setStoreEmail(String storeEmail) {
		this.storeEmail = storeEmail;
	}

	public String getGstinNumber() {
		return gstinNumber;
	}

	public void setGstinNumber(String gstinNumber) {
		this.gstinNumber = gstinNumber;
	}

	public String getStoreAccountHolderName() {
		return storeAccountHolderName;
	}

	public void setStoreAccountHolderName(String storeAccountHolderName) {
		this.storeAccountHolderName = storeAccountHolderName;
	}

	public String getStoreAccountNumber() {
		return storeAccountNumber;
	}

	public void setStoreAccountNumber(String storeAccountNumber) {
		this.storeAccountNumber = storeAccountNumber;
	}

	public Users getStoreOwner() {
		return storeOwner;
	}

	public void setStoreOwner(Users storeOwner) {
		this.storeOwner = storeOwner;
	}
	
	public ProductsCategory getProductSellCategory() {
		return productSellCategory;
	}

	public void setProductSellCategory(ProductsCategory productSellCategory) {
		this.productSellCategory = productSellCategory;
	}

	
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"storeName\":\"" + storeName + "\", \"uniqueStoreCode\":\"" + uniqueStoreCode
				+ "\", \"country\":\"" + country + "\", \"city\":\"" + city + "\", \"state\":\"" + state
				+ "\", \"address\":\"" + address + "\", \"zipCode\":\"" + zipCode + "\", \"storeDescription\":\""
				+ storeDescription + "\", \"addedAt\":\"" + addedAt + "\", \"logoURL\":\"" + logoURL
				+ "\", \"storeStatus\":\"" + storeStatus + "\", \"storeEmail\":\"" + storeEmail
				+ "\", \"gstinNumber\":\"" + gstinNumber + "\", \"storeAccountHolderName\":\"" + storeAccountHolderName
				+ "\", \"storeAccountNumber\":\"" + storeAccountNumber + "\", \"storeOwner\":\"" + storeOwner
				+ "\", \"productSellCategory\":\"" + productSellCategory + "\"}";
	}

}
