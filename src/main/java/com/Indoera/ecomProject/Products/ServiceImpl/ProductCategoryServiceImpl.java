/**
 * 
 */
package com.Indoera.ecomProject.Products.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Indoera.ecomProject.Products.Entity.ProductsCategory;
import com.Indoera.ecomProject.Products.Service.ProductCategoryService;

/**
 * @author shiva
 * Added on 13-Jun-2021
 * Package  com.Indoera.ecomProject.Products.ServiceImpl
 */
@Repository
public class ProductCategoryServiceImpl implements ProductCategoryService{

	private static final Logger logger = LogManager.getLogger(ProductCategoryServiceImpl.class);
	private EntityManager entityManager;
	

	@Autowired
	public ProductCategoryServiceImpl(EntityManager entityManager){
		this.entityManager = entityManager;
	}	

	
	@Override
	@Transactional
	public List<ProductsCategory> productsCategoryList(List<String> errorList) {
		List<ProductsCategory> productCategories = new ArrayList<ProductsCategory>();
		try {

			Query query = entityManager.createQuery("SELECT p FROM ProductsCategory p WHERE p.productCatId != 0 ");
			productCategories = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		logger.info("List of Countries Returned nby the MEthod is "+ allCountries ) ;
		logger.info("Products Category List :: " + productCategories);
		return productCategories;
	}

}
