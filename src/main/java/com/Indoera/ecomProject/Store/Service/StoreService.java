package com.Indoera.ecomProject.Store.Service;

import java.util.List;
import com.Indoera.ecomProject.Store.Entity.Stores;
import com.Indoera.ecomProject.UserManagement.Entity.Users;

public interface StoreService {

	public void saveUpdateStore(Stores store,Users user,List<String> errorList,String logoPath);
	public List<Stores> getAllStores();	
	public List<Stores> getStoreUserSpecific(Users user, List<String>  errorList);
	public Stores getStoreDetails(Users user,Integer storeId, List<String> errorList);
}
