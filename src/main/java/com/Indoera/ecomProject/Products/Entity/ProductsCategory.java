/**
 * 
 */
package com.Indoera.ecomProject.Products.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author shiva
 * Added on 13-Jun-2021
 * Package  com.Indoera.ecomProject.Products.Entity
 */
@Entity
@Table(name="product_category")
public class ProductsCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_cat_id")
	private Integer productCatId;
	@Column(name="category_name")
	private String  categoryName;

	
	ProductsCategory() {
	}

	
	public ProductsCategory(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	
	public Integer getProductCatId() {
		return productCatId;
	}
	public void setProductCatId(Integer productCatId) {
		this.productCatId = productCatId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	@Override
	public String toString() {
		return "{\"productCatId\":\"" + productCatId + "\", \"categoryName\":\"" + categoryName + "\"}";
	}
	
	
	
	
	
}
