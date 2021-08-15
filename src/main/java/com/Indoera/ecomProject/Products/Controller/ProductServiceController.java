/**
 * 
 */
package com.Indoera.ecomProject.Products.Controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Indoera.ecomProject.Products.Entity.ProductsCategory;
import com.Indoera.ecomProject.Products.Service.ProductCategoryService;
import com.Indoera.ecomProject.Utils.APIResponseModal;
import com.Indoera.ecomProject.Utils.Utils;

/**
 * @author shiva
 * Added on 13-Jun-2021
 * Package  com.Indoera.ecomProject.Products.Controller
 */
@Controller
@RequestMapping("/products")
public class ProductServiceController {

	private static final Logger logger = LogManager.getLogger(ProductServiceController.class);

	private ProductCategoryService productCategoryService;

	@Autowired
	public ProductServiceController (ProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}

	@ResponseBody
	@RequestMapping(value = "/getProductCategoryList",method = RequestMethod.POST)
	public APIResponseModal getPRoductCategoryList() {
		List<ProductsCategory>  productsCategory ; 
		APIResponseModal apiResponseModel = new Utils().getDefaultApiResponse();
		try {
			List<String> errorList = new ArrayList<String>();
			productsCategory = productCategoryService.productsCategoryList(errorList);
			if(!Utils.isNotNull(errorList)) {
				apiResponseModel.setData(productsCategory.toString());
				apiResponseModel.setMessage("PRODUCTS CATEGORY LIST");
				apiResponseModel.setStatus(HttpStatus.OK);
			}else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		logger.info(apiResponseModel);
		return apiResponseModel;
	}
		
	
	@RequestMapping(value = "/saveProductsforMap", method = {RequestMethod.GET,RequestMethod.POST})
	public APIResponseModal saveProducts(@RequestBody String products) {
			logger.info("ProductCame to be saved ??"+products);
		APIResponseModal apiResponseModel = new Utils().getDefaultApiResponse();
		try {
			productCategoryService.saveProducts(products);
			apiResponseModel.setData(products.toString());
			apiResponseModel.setMessage("Sucess");
			apiResponseModel.setStatus(HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return apiResponseModel;
	}
	
	
}
