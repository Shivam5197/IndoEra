package com.Indoera.ecomProject.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;


public class Utils {

	private static final Logger logger = LogManager.getLogger(Utils.class);

	public static String RandomAlphaString() {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 7;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    logger.info("Generated RAndom String "+ generatedString);
	    return generatedString;
	}
	
	
	public static String randomSmallString()
	{
		int n = 7;
		// chose a Character random from this String
		String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index
				= (int)(AlphaNumericString.length()
						* Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString
						.charAt(index));
		}

		return sb.toString();
	}
	
	
	public static String storeLogoPath(MultipartFile file) {
		logger.info("File AAYA HAI " + file);
		String path = "";
		try {
			//String paths = "G:/MainWorkSpace/Picture_testing/WebContent/resources/images/"+file.getOriginalFilename();
			path = "G:/MainWorkSpace/TestProjects/ecomProject/src/main/resources/static/img/storeLogo/"+file.getOriginalFilename();
			File newFile = new File(path);
			newFile.createNewFile();
			FileOutputStream myfile = new FileOutputStream(newFile);
			myfile.write(file.getBytes());
			path ="/img/storeLogo/"+file.getOriginalFilename(); //PAth is setted mannualy to display images 
			myfile.close();
			logger.info("File should be saved now :: ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Path Returned is ::: "  + path);
		return path;
	}

	public APIResponseModal getDefaultApiResponse() {
		APIResponseModal apiResponseModel = null;
		try {
			apiResponseModel = new APIResponseModal();
			apiResponseModel.setData(null);
			apiResponseModel.setMessage("Unable to process the request!");
			apiResponseModel.setStatus(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.info("Exception in creating Default API Response :"+e.getMessage());
		}
		return apiResponseModel;
	}

	
	public static boolean isNotNull(String string) {
		if(string != null && !string.isEmpty())
			return true;
		else
			return false;
	}
	
	public static boolean isNotNull(Integer integer) {
		if(integer != null)
			return true;
		else
			return false;
	}
	
	public static boolean isNotNull(Boolean bool) {
		if(bool != null)
			return true;
		else
			return false;
	}
	
	public static boolean isNotNull(List<?> list) {
		if(list != null && !list.isEmpty())
			return true;
		else
			return false;
	}
	
	public static boolean isNotNull(Object obj) {
		if(obj != null)
			return true;
		else
			return false;
	}

	
	
}
