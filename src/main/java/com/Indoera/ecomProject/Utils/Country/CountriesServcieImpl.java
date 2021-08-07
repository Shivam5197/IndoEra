/**
 * 
 */
package com.Indoera.ecomProject.Utils.Country;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author shiva
 * Added on 15-May-2021
 * Package  com.Indoera.ecomProject.Utils.Country
 */
@Repository
public class CountriesServcieImpl implements CountriesService{

	private static final Logger logger = LogManager.getLogger(CountriesServcieImpl.class);
	private EntityManager entityManager;
	

	@Autowired
	public CountriesServcieImpl(EntityManager entityManager){
		this.entityManager = entityManager;
	}	

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Countries> getListofCountries(List<String> errorList) {
		List<Countries> allCountries = new ArrayList<Countries>();
		try {

			Query query = entityManager.createQuery("SELECT c FROM Countries c WHERE c.id != 0 ORDER BY countryName");
			allCountries = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		logger.info("List of Countries Returned nby the MEthod is "+ allCountries ) ;
		return allCountries;
	}

}
