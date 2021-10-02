/**
 * 
 */
package com.Indoera.ecomProject.Utils.Country;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Indoera.ecomProject.Utils.APIResponseModal;
import com.Indoera.ecomProject.Utils.Utils;


/**
 * @author shiva
 * Added on 20-May-2021
 * Package  com.Indoera.ecomProject.Utils.Country
 */
@Controller
@RequestMapping("/")
public class CountryController {

	private static final Logger logger = LogManager.getLogger(CountryController.class);

	private CountriesService countryService;

	@Autowired
	public CountryController (CountriesService countryService) {
		this.countryService = countryService;
	}

	@ResponseBody
	@RequestMapping(value = "/getCountryList",method = RequestMethod.POST)
	public APIResponseModal getlistCountries(){
		List<Countries> countiries = null;
		APIResponseModal apiResponse;
		apiResponse = new Utils().getDefaultApiResponse();
		try {
			List<String> errorList = new ArrayList<String>();
			countiries = countryService.getListofCountries(errorList);
			//			logger.info("++++++++++++++++ "+countiries);
			if(!Utils.isNotNull(errorList)) {
				apiResponse.setStatus(HttpStatus.OK);
				apiResponse.setData(countiries.toString());
				apiResponse.setMessage("Country list");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 	apiResponse;
	}

	
	@ResponseBody
	@RequestMapping(value = "/verifyZip", method = RequestMethod.POST)
	public APIResponseModal getZipDetails(@RequestBody String zipCode) throws IOException {
		APIResponseModal apiResponseModel = new Utils().getDefaultApiResponse();		
		StringBuffer zipResponse = null;
		try {
			if (Utils.isNotNull(zipCode)) {
				zipResponse = MyGETRequest(zipCode);
				if(Utils.isNotNull(zipResponse)) {
					logger.info(zipResponse.toString());
					apiResponseModel.setData(zipResponse.toString());
					apiResponseModel.setMessage("ZipCode Found");
					apiResponseModel.setStatus(HttpStatus.OK);
				}else {
					apiResponseModel.setData(zipResponse.toString());
					apiResponseModel.setMessage("ZipCode Not Found");
					apiResponseModel.setStatus(HttpStatus.BAD_REQUEST);
				}
			}else {
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return apiResponseModel;
	}
		
	public static StringBuffer MyGETRequest(String pincode) throws IOException {
		URL urlForGetRequest = new URL("https://api.postalpincode.in/pincode/"+pincode);
		String readLine = null;
		StringBuffer response=null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		conection.setRequestMethod("GET");
		int responseCode = conection.getResponseCode();
		try {
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(
						new InputStreamReader(conection.getInputStream()));
				response   = new StringBuffer();
				while ((readLine = in .readLine()) != null) {
					response.append(readLine);
				} in .close();
			} else {
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
		
		return response;
	}

		
}