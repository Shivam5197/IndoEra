package com.Indoera.ecomProject.Store.ServiceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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

//	static Cipher cipher;  
//	static SecretKey secretKey;
//
//	/* This Block of Code will be responsible fo encrypting the Values for GSTN and AccountNumbers*/
//	public StoreServiceImpl() { 
//		try {
//			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//			keyGenerator.init(128); // block size is 128bits
//			secretKey = keyGenerator.generateKey();
//			cipher = Cipher.getInstance("AES"); //SunJCE provider AES algorithm, mode(optional) and padding schema(optional)  
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchPaddingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public SecretKey generateSecretKey() {
//		logger.info("---------------Generate Seceret key called Here ");
//		try {
//			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//			keyGenerator.init(128); // block size is 128bits
//			secretKey = keyGenerator.generateKey();
//			cipher = Cipher.getInstance("AES"); //SunJCE provider AES algorithm, mode(optional) and padding schema(optional)  
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchPaddingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		logger.info("--------------- Seceret key returned :  "+ secretKey);
//		logger.info("--------------- Seceret key returned :  "+ cipher);
//
//
//		return secretKey;
//	}
//




//	@Override
//	@Transactional
//	public void saveUpdateStore(Stores storeModel, Users user, List<String> errorList, String logoPath) {
//
//		logger.info(storeModel.getId());
//		if(storeModel.getId() != null) {
//		Stores storeID = entityManager.find(Stores.class, storeModel.getId());
//		logger.info("DO we have the ID : " + storeID);
//		}
//		
//		try {
//			if(Utils.isNotNull(user)) {
//				if(Utils.isNotNull(storeModel.getStoreName()) && 
//						Utils.isNotNull(storeModel.getStoreEmail()) &&
//						Utils.isNotNull(storeModel.getAddress()) && 
//						Utils.isNotNull(storeModel.getCity()) &&
//						Utils.isNotNull(storeModel.getState()) &&
//						Utils.isNotNull(storeModel.getZipCode())) {
//
//					if(storeModel.getProductSellCategory()==null && storeModel.getProductCategoryId()!=null) {
//						storeModel.setProductSellCategory(entityManager.find(ProductsCategory.class,storeModel.getProductCategoryId()));
//					}
//
//					if(Utils.isNotNull(logoPath)) {
//						storeModel.setLogoURL(logoPath);
//					}else {
//						storeModel.setLogoURL(null);
//					}
//
//					if(Utils.isNotNull(storeModel.getStoreDescription())) {
//						storeModel.setStoreDescription(storeModel.getStoreDescription());
//					}else {
//						storeModel.setStoreDescription(null);
//					}
//					if(Utils.isNotNull(storeModel.getStoreAccountHolderName())) {
//						storeModel.setStoreAccountHolderName(storeModel.getStoreAccountHolderName());
//					}else {
//						storeModel.setStoreAccountHolderName(null);
//					}
//					if(Utils.isNotNull(storeModel.getBankAccountType())) {
//						storeModel.setBankAccountType(storeModel.getBankAccountType());
//					}else {
//						storeModel.setBankAccountType(null);
//					}
//					if(Utils.isNotNull(storeModel.getGstinNumber())) {
//						storeModel.setGstinNumber(storeModel.getGstinNumber());//Encryption code should be implemented
//					}else {
//						storeModel.setGstinNumber(null);
//					}
//					if(Utils.isNotNull(storeModel.getStoreAccountNumber())) {
//						storeModel.setStoreAccountNumber(storeModel.getStoreAccountNumber()); //Encryption code should be implemented
//					}else {
//						storeModel.setStoreAccountNumber(null);
//					}
//					if(Utils.isNotNull(storeModel.getSellerPanNumber())) {
//						storeModel.setSellerPanNumber(storeModel.getSellerPanNumber());
//					}else {
//						storeModel.setSellerPanNumber(null);
//					}
//					storeModel.setAddedAt(new java.sql.Timestamp(System.currentTimeMillis()));
//					storeModel.setStoreOwner(user);
//					storeModel.setUniqueStoreCode(storeModel.getStoreName().substring(0,2)+Utils.RandomAlphaString());
//					storeModel.setStoreStatus(Constants.storeStatus.OPEN);
//					storeModel.setCountry("India");
//
//					entityManager.merge(storeModel);
//				}else {
//					errorList.add("Please Enter Required Data");
//					logger.info("Something is missing");
//				}
//			}else {
//				errorList.add("Session timed out Please Login agian !!");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.info("================================ Exception Handeled In SAVEUPDATESTORE Method =====================================================" );
//			logger.info(e.getMessage());
//			logger.info("================================ Exception Handeled In SAVEUPDATESTORE Method =====================================================" );
//			
//		}finally {
//			logger.info("Store Saved Successfully!!");
//		}		
//	}

	@Override
	@Transactional
	public void saveUpdateStore(Stores storeModel, Users user, List<String> errorList, String logoPath) {
		logger.info("Store Model :   : "+storeModel);
//		logger.info(storeModel.getId());
		if(storeModel.getId() != null) {
		logger.info("DO we have the ID : " + storeModel.getId());
		}
		Stores storetoSaveUpdate = new Stores();
		try {
			if(Utils.isNotNull(user)) {
				if(Utils.isNotNull(storeModel)) {
					if (Utils.isNotNull(storeModel.getId())) {
						/* Store To Update will come here */
						storetoSaveUpdate = entityManager.find(Stores.class, storeModel.getId());
						/*	Store Name & Product sell category cannot be changed so no need to update it */ 
						
						if(Utils.isNotNull(storeModel.getStoreEmail())) {
							storetoSaveUpdate.setStoreEmail(storeModel.getStoreEmail());
						}else {//No changes will be made if the storeModel is empty Just to be sure we are saving the fetched details from the already saved store
							storetoSaveUpdate.setStoreEmail(storetoSaveUpdate.getStoreEmail());
						}
						
						if(Utils.isNotNull(logoPath)) {
							storetoSaveUpdate.setLogoURL(logoPath);
						}else {
							storetoSaveUpdate.setLogoURL(storetoSaveUpdate.getLogoURL());
						}
						
						if(Utils.isNotNull(storeModel.getStoreDescription())) {
							storetoSaveUpdate.setStoreDescription(storeModel.getStoreDescription());
						}else {//No changes will be made if the storeModel is empty Just to be sure we are saving the fetched details from the already saved store
							storetoSaveUpdate.setStoreDescription(storetoSaveUpdate.getStoreDescription());
						}

						if(Utils.isNotNull(storeModel.getZipCode())) {
							storetoSaveUpdate.setZipCode(storeModel.getZipCode());
						}else {//No changes will be made if the storeModel is empty Just to be sure we are saving the fetched details from the already saved store
							storetoSaveUpdate.setZipCode(storetoSaveUpdate.getZipCode());
						}

//						if(Utils.isNotNull(storeModel.getZipCode())) {
//							storetoSaveUpdate.setZipCode(storeModel.getZipCode());
//						}else {//No changes will be made if the storeModel is empty Just to be sure we are saving the fetched details from the already saved store
//							storetoSaveUpdate.setZipCode(storetoSaveUpdate.getZipCode());
//						}

						if(Utils.isNotNull(storeModel.getCity())) {
							storetoSaveUpdate.setCity(storeModel.getCity());
						}else {//No changes will be made if the storeModel is empty Just to be sure we are saving the fetched details from the already saved store
							storetoSaveUpdate.setCity(storeModel.getCity());
						}

						if(Utils.isNotNull(storeModel.getState())) {
							storetoSaveUpdate.setState(storeModel.getState());
						}else {//No changes will be made if the storeModel is empty Just to be sure we are saving the fetched details from the already saved store
							storetoSaveUpdate.setState(storetoSaveUpdate.getState());
						}

						if(Utils.isNotNull(storeModel.getAddress())) {
							storetoSaveUpdate.setAddress(storeModel.getAddress());
						}else {//No changes will be made if the storeModel is empty Just to be sure we are saving the fetched details from the already saved store
							storetoSaveUpdate.setAddress(storetoSaveUpdate.getAddress());
						}

						if(Utils.isNotNull(storeModel.getBankAccountType())) {
							storetoSaveUpdate.setBankAccountType(storeModel.getBankAccountType());
						}else {//No changes will be made if the storeModel is empty Just to be sure we are saving the fetched details from the already saved store
							storetoSaveUpdate.setBankAccountType(storetoSaveUpdate.getBankAccountType());
						}

						if(Utils.isNotNull(storeModel.getStoreAccountHolderName())) {
							storetoSaveUpdate.setStoreAccountHolderName(storeModel.getStoreAccountHolderName());
						}else {//No changes will be made if the storeModel is empty Just to be sure we are saving the fetched details from the already saved store
							storetoSaveUpdate.setStoreAccountHolderName(storetoSaveUpdate.getStoreAccountHolderName());
						}

						if(Utils.isNotNull(storeModel.getSellerPanNumber())) {
							storetoSaveUpdate.setSellerPanNumber(storeModel.getSellerPanNumber());
						}else {//No changes will be made if the storeModel is empty Just to be sure we are saving the fetched details from the already saved store
							storetoSaveUpdate.setSellerPanNumber(storetoSaveUpdate.getSellerPanNumber());
						}

						if(Utils.isNotNull(storeModel.getStoreAccountNumber())) {
							storetoSaveUpdate.setStoreAccountNumber(storeModel.getStoreAccountNumber());
						}else {//No changes will be made if the storeModel is empty Just to be sure we are saving the fetched details from the already saved store
							storetoSaveUpdate.setStoreAccountNumber(storetoSaveUpdate.getStoreAccountNumber());
						}
						
						if(Utils.isNotNull(storeModel.getGstinNumber())) {
							storetoSaveUpdate.setGstinNumber(storeModel.getGstinNumber());
						}else {//No changes will be made if the storeModel is empty Just to be sure we are saving the fetched details from the already saved store
							storetoSaveUpdate.setGstinNumber(storeModel.getGstinNumber());
						}
						
						//After this It will be merged in DataBAse
					}else {
						logger.info("Store Model In Else PArt  :   : "+storeModel);

						/* New Store To Be Created */ 
						if(Utils.isNotNull(storeModel.getStoreName()) && 
						Utils.isNotNull(storeModel.getStoreEmail()) &&
						Utils.isNotNull(storeModel.getAddress()) && 
						Utils.isNotNull(storeModel.getCity()) &&
						Utils.isNotNull(storeModel.getState()) &&
						Utils.isNotNull(storeModel.getZipCode())) {

					storetoSaveUpdate.setStoreName(storeModel.getStoreName());		
					storetoSaveUpdate.setStoreEmail(storeModel.getStoreEmail());		
					storetoSaveUpdate.setCity(storeModel.getCity());
					storetoSaveUpdate.setAddress(storeModel.getAddress());
					storetoSaveUpdate.setState(storeModel.getState());
					storetoSaveUpdate.setZipCode(storeModel.getZipCode());
					
					if(storeModel.getProductSellCategory()==null && storeModel.getProductCategoryId()!=null) {
						storetoSaveUpdate.setProductSellCategory(entityManager.find(ProductsCategory.class,storeModel.getProductCategoryId()));
					}
					
					if(Utils.isNotNull(logoPath)) {
						storetoSaveUpdate.setLogoURL(logoPath);
					}else {
						storetoSaveUpdate.setLogoURL(null);
					}

					if(Utils.isNotNull(storeModel.getStoreDescription())) {
						storetoSaveUpdate.setStoreDescription(storeModel.getStoreDescription());
					}else {
						storetoSaveUpdate.setStoreDescription(null);
					}
					if(Utils.isNotNull(storeModel.getStoreAccountHolderName())) {
						storetoSaveUpdate.setStoreAccountHolderName(storeModel.getStoreAccountHolderName());
					}else {
						storetoSaveUpdate.setStoreAccountHolderName(null);
					}
					if(Utils.isNotNull(storeModel.getBankAccountType())) {
						storetoSaveUpdate.setBankAccountType(storeModel.getBankAccountType());
					}else {
						storetoSaveUpdate.setBankAccountType(null);
					}
					if(Utils.isNotNull(storeModel.getGstinNumber())) {
						storetoSaveUpdate.setGstinNumber(storeModel.getGstinNumber());//Encryption code should be implemented
					}else {
						storetoSaveUpdate.setGstinNumber(null);
					}
					if(Utils.isNotNull(storeModel.getStoreAccountNumber())) {
						storetoSaveUpdate.setStoreAccountNumber(storeModel.getStoreAccountNumber()); //Encryption code should be implemented
					}else {
						storetoSaveUpdate.setStoreAccountNumber(null);
					}
					if(Utils.isNotNull(storeModel.getSellerPanNumber())) {
						storetoSaveUpdate.setSellerPanNumber(storeModel.getSellerPanNumber());
					}else {
						storetoSaveUpdate.setSellerPanNumber(null);
					}
					storetoSaveUpdate.setAddedAt(new java.sql.Timestamp(System.currentTimeMillis()));
					storetoSaveUpdate.setStoreOwner(user);
					storetoSaveUpdate.setUniqueStoreCode(storeModel.getStoreName().substring(0,2)+Utils.RandomAlphaString());
					storetoSaveUpdate.setStoreStatus(Constants.storeStatus.OPEN);
					storetoSaveUpdate.setCountry("India");
				}else {
					errorList.add("Please Enter Required Data");
					logger.info("Something is missing");
				}
					}
					
				}else {
					errorList.add(" WOO..HOO - Session Expired !! Please Sign In Again !!!");
				}
			}else {
				errorList.add(" WOO..HOO - Session Expired !! Please Sign In Again !!!");
			}
		
			entityManager.merge(storetoSaveUpdate);
		} catch (Exception e) {
			e.printStackTrace();
			errorList.add("Someting Went Wrong. Please Try after some time !!!");
			logger.info("================================ Exception Handeled In SAVEUPDATESTORE Method =====================================================" );
			logger.info(e.getMessage());
			logger.info("================================ Exception Handeled In SAVEUPDATESTORE Method =====================================================" );
			
		}		
	}



	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Stores> getAllStores() {
		List<Stores> storeList = new ArrayList<Stores>();
		Query query = entityManager.createQuery("SELECT s FROM Stores s WHERE s.id !=0");
		storeList=	query.getResultList();
		logger.info(storeList);
		return storeList;
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Stores> getStoreUserSpecific(Users user, List<String> errorList) {
		List<Stores> storesList = new ArrayList<Stores>();
		try {
			if(Utils.isNotNull(user)) {
				
				Query query = entityManager.createQuery("Select s FROM Stores s WHERE s.id !=0 AND s.storeOwner ="+ user.getId());
				storesList = query.getResultList();	
			}else {
				errorList.add("Request Timed out !! Please try to login again");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Catch Query");
			errorList.add("Something went wrong!! We are looking into it. Please try after sometime");
		}
		return storesList;
	}

	@Override
	@Transactional
	public Stores getStoreDetails(Users user,Integer storeId,List<String> errorList) {
		Stores store = null;
		try {
			if(Utils.isNotNull(user)) {
				if(Utils.isNotNull(storeId)) {
				 store = entityManager.find(Stores.class, storeId);
				}else {
					errorList.add("Store not Found");
				}
			}else {
				errorList.add("Please Sign in to Continue!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorList.add("Something went Wrong Please try agter some time !!");
		}
		return store;
	}





}
