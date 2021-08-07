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

import com.Indoera.ecomProject.Store.Entity.Stores;
import com.Indoera.ecomProject.Store.Service.StoreService;
import com.Indoera.ecomProject.UserManagement.Entity.Users;
import com.Indoera.ecomProject.Utils.Constants;
import com.Indoera.ecomProject.Utils.EncryptionDecryptionAES;
import com.Indoera.ecomProject.Utils.Utils;

@Repository
public class StoreServiceImpl implements StoreService {


	private static final Logger logger = LogManager.getLogger(StoreServiceImpl.class);

//	@Autowired
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
		
	
//	@Override
//	@Transactional
//	public void saveStore(Stores store,Users user,List<String> errorList,String logoPath) {
//
//		try {
//			if(Utils.isNotNull(store)) {
//				if(Utils.isNotNull(store.getStoreName())
//						&Utils.isNotNull(store.getAddress())
//						&Utils.isNotNull(store.getCountry())
//						&Utils.isNotNull(store.getCity())
//						&Utils.isNotNull(store.getStreet())
//						&Utils.isNotNull(store.getStoreOpenTime())
//						&Utils.isNotNull(store.getZipCode())
//						&Utils.isNotNull(store.getStoreDescription())
//						) {
//					store.setAddedAt(new java.sql.Timestamp(System.currentTimeMillis()));
//					store.setStoreOwner(user);
//					store.setUniqueStoreCode(store.getStoreName().substring(0,2)+Utils.RandomAlphaString());
//					store.setStoreStatus(Constants.storeStatus.OPEN);
//					store.setLogoURL(logoPath);
//					entityManager.merge(store);
//				}else {
//					errorList.add("Please Enter required Details !");
//				}
//			}else {
//				errorList.add("Please Enter required Details !");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.info("Exception Occured in Save Store Method : " + e.getMessage());
//			errorList.add("Error Occured at our End we are Sorry !! Please try again later");
//		}
//	}

	
//	private String StoreAccountHolderName;
	
	@Override
	@Transactional
	public void saveStore(Stores store, Users user, List<String> errorList, String logoPath) {

		try {
			if(Utils.isNotNull(user)) {
				if(Utils.isNotNull(store.getStoreName()) && 
						Utils.isNotNull(store.getStoreEmail()) &&
						Utils.isNotNull(store.getAddress()) && 
						Utils.isNotNull(store.getCountry()) && 
						Utils.isNotNull(store.getCity()) &&
						Utils.isNotNull(store.getState()) &&
						Utils.isNotNull(store.getZipCode())&& 
						Utils.isNotNull(store.getProductSellCategory())) {

					if(Utils.isNotNull(store.getLogoURL())) {
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
					if(Utils.isNotNull(store.getGstinNumber())) {
						store.setGstinNumber(encrept.encrypt(store.getGstinNumber(), secretKey));//Key Related Issues will come from Here
					}else {
						store.setGstinNumber(null);
					}
					if(Utils.isNotNull(store.getStoreAccountNumber())) {
						store.setStoreAccountNumber(encrept.encrypt(store.getStoreAccountNumber(), secretKey));//Key Related Issues will come from Here
					}else {
						store.setStoreAccountNumber(null);
					}
					store.setAddedAt(new java.sql.Timestamp(System.currentTimeMillis()));
					store.setStoreOwner(user);
					store.setUniqueStoreCode(store.getStoreName().substring(0,2)+Utils.RandomAlphaString());
					store.setStoreStatus(Constants.storeStatus.OPEN);
					
					entityManager.merge(store);
					
				}else {
					errorList.add("Please Enter Required Data");
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
