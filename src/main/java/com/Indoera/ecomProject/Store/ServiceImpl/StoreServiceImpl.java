package com.Indoera.ecomProject.Store.ServiceImpl;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Indoera.ecomProject.Products.Entity.ProductsCategory;
import com.Indoera.ecomProject.Store.Entity.Stores;
import com.Indoera.ecomProject.Store.Service.StoreService;
import com.Indoera.ecomProject.UserManagement.Entity.Users;
import com.Indoera.ecomProject.Utils.Constants;
import com.Indoera.ecomProject.Utils.EncryptionDecryptionAES;
import com.Indoera.ecomProject.Utils.Utils;

@Repository
public class StoreServiceImpl implements StoreService {


	private static final Logger logger = LogManager.getLogger(StoreServiceImpl.class);

	@Autowired
	private EntityManager entityManager;
	
	EncryptionDecryptionAES encrept = new EncryptionDecryptionAES();
	
	@Autowired
	 public StoreServiceImpl( EntityManager entityManager) {
		 this.entityManager =entityManager;
	 }
	
	   static Cipher cipher;  
	   static SecretKey secretKey;

		/* This Block of Code will be responsible fo encrypting the Values for GSTN and AccountNumbers*/
	    public StoreServiceImpl() { 
	    	try {
	    		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
				keyGenerator.init(128); // block size is 128bits
				 secretKey = keyGenerator.generateKey();
				cipher = Cipher.getInstance("AES"); //SunJCE provider AES algorithm, mode(optional) and padding schema(optional)  
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    public SecretKey generateSecretKey() {
	    	logger.info("---------------Generate Seceret key called Here ");
	    	try {
	    		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
				keyGenerator.init(128); // block size is 128bits
				 secretKey = keyGenerator.generateKey();
				cipher = Cipher.getInstance("AES"); //SunJCE provider AES algorithm, mode(optional) and padding schema(optional)  
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	logger.info("--------------- Seceret key returned :  "+ secretKey);
	    	logger.info("--------------- Seceret key returned :  "+ cipher);
	    	

	    	return secretKey;
	    }
	    
	    
	    
	    
				
	@Override
	@Transactional
	public void saveStore(Stores store, Users user, List<String> errorList, String logoPath) {
		try {
			if(Utils.isNotNull(user)) {
				if(Utils.isNotNull(store.getStoreName()) && 
						Utils.isNotNull(store.getStoreEmail()) &&
						Utils.isNotNull(store.getAddress()) && 
						Utils.isNotNull(store.getCity()) &&
						Utils.isNotNull(store.getState()) &&
						Utils.isNotNull(store.getZipCode())) {

					if(store.getProductSellCategory()==null && store.getProductCategoryId()!=null) {
						store.setProductSellCategory(entityManager.find(ProductsCategory.class,store.getProductCategoryId()));
					}
					
					if(Utils.isNotNull(logoPath)) {
						store.setLogoURL(logoPath);
						}else {
						store.setLogoURL(null);
					}
					
					if(Utils.isNotNull(store.getStoreDescription())) {
						store.setStoreDescription(store.getStoreDescription());
					}else {
						store.setStoreDescription(null);
					}
					if(Utils.isNotNull(store.getStoreAccountHolderName())) {
						store.setStoreAccountHolderName(store.getStoreAccountHolderName());
					}else {
						store.setStoreAccountHolderName(null);
					}
					if(Utils.isNotNull(store.getBankAccountType())) {
						store.setBankAccountType(store.getBankAccountType());
					}else {
						store.setBankAccountType(null);
					}
					if(Utils.isNotNull(store.getGstinNumber())) {
						store.setGstinNumber(encrept.encrypt(store.getGstinNumber(), generateSecretKey(),cipher));//Key Related Issues will come from Here
					}else {
						store.setGstinNumber(null);
					}
					if(Utils.isNotNull(store.getStoreAccountNumber())) {
						store.setStoreAccountNumber(encrept.encrypt(store.getStoreAccountNumber(), generateSecretKey(),cipher));//Key Related Issues will come from Here
					}else {
						store.setStoreAccountNumber(null);
					}
					if(Utils.isNotNull(store.getSellerPanNumber())) {
						store.setSellerPanNumber(store.getSellerPanNumber());
					}else {
						store.setSellerPanNumber(null);
					}
					
					store.setAddedAt(new java.sql.Timestamp(System.currentTimeMillis()));
					store.setStoreOwner(user);
					store.setUniqueStoreCode(store.getStoreName().substring(0,2)+Utils.RandomAlphaString());
					store.setStoreStatus(Constants.storeStatus.OPEN);
					store.setCountry("India");
					
					entityManager.merge(store);
				}else {
					errorList.add("Please Enter Required Data");
					logger.info("Something is missing");
				}
			}else {
				errorList.add("Session timed out Please Login agian !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			logger.info("Store Saved Successfully!!");
		}		
	}
	
	
	
	@Override
	@Transactional
	public List<Stores> getAllStores() {
		List<Stores> storeList = new ArrayList<Stores>();
		Query query = entityManager.createQuery("SELECT s FROM Stores s WHERE s.id !=0");
		storeList=	query.getResultList();
		logger.info(storeList);
		return storeList;
	}


	@Override
	@Transactional
	public List<Stores> getStoreUserSpecific(Users user, List<String> errorList) {
		return null;
	}


	
	
	
}
