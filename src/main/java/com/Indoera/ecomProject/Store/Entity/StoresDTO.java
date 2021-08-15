package com.Indoera.ecomProject.Store.Entity;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import com.Indoera.ecomProject.Products.Entity.ProductsCategory;
import com.Indoera.ecomProject.UserManagement.Entity.Users;


public class StoresDTO {

	private Integer id;
	private String storeName;
	private String uniqueStoreCode;
	private String country;
	private String city;
	private String state;
	private String address;
	private Integer zipCode;
	private String storeDescription;
	private Timestamp addedAt;
	private String logoURL;
	private Integer storeStatus;
	private String storeEmail;
	private String gstinNumber;
	private String StoreAccountHolderName;
	private String storeAccountNumber;
	private Integer accountType;
	private MultipartFile logoFile;
	private String sellerPanNumber;
	
	private Users storeOwner;

	private Integer productCategory;
	
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
		return StoreAccountHolderName;
	}

	public void setStoreAccountHolderName(String storeAccountHolderName) {
		StoreAccountHolderName = storeAccountHolderName;
	}

	public String getStoreAccountNumber() {
		return storeAccountNumber;
	}

	public void setStoreAccountNumber(String storeAccountNumber) {
		this.storeAccountNumber = storeAccountNumber;
	}

	public MultipartFile getLogoFile() {
		return logoFile;
	}
	public void setLogoFile(MultipartFile logoFile) {
		this.logoFile = logoFile;
	}
	public Users getStoreOwner() {
		return storeOwner;
	}

	public void setStoreOwner(Users storeOwner) {
		this.storeOwner = storeOwner;
	}

	public Integer getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Integer productCategory) {
		this.productCategory = productCategory;
	}
	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	
	public String getSellerPanNumber() {
		return sellerPanNumber;
	}

	public void setSellerPanNumber(String sellerPanNumber) {
		this.sellerPanNumber = sellerPanNumber;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"storeName\":\"" + storeName + "\", \"uniqueStoreCode\":\"" + uniqueStoreCode
				+ "\", \"country\":\"" + country + "\", \"city\":\"" + city + "\", \"state\":\"" + state
				+ "\", \"address\":\"" + address + "\", \"zipCode\":\"" + zipCode + "\", \"storeDescription\":\""
				+ storeDescription + "\", \"addedAt\":\"" + addedAt + "\", \"logoURL\":\"" + logoURL
				+ "\", \"storeStatus\":\"" + storeStatus + "\", \"storeEmail\":\"" + storeEmail
				+ "\", \"gstinNumber\":\"" + gstinNumber + "\", \"StoreAccountHolderName\":\"" + StoreAccountHolderName
				+ "\", \"storeAccountNumber\":\"" + storeAccountNumber + "\", \"accountType\":\"" + accountType
				+ "\", \"logoFile\":\"" + logoFile + "\", \"sellerPanNumber\":\"" + sellerPanNumber
				+ "\", \"storeOwner\":\"" + storeOwner + "\", \"productCategory\":\"" + productCategory + "\"}";
	}
	
}
