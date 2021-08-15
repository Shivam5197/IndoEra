/**
 * 
 */
package com.Indoera.ecomProject.Products.Service;

import java.util.List;

import com.Indoera.ecomProject.Products.Entity.ProductsCategory;

/**
 * @author shiva
 * Added on 13-Jun-2021
 * Package  com.Indoera.ecomProject.Products.Service
 */
public interface ProductCategoryService {

	public List<ProductsCategory> productsCategoryList(List<String> errorList);
	
	public void saveProducts(String products);
}
