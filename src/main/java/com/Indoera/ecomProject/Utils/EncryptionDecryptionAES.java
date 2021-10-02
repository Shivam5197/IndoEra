/**
 * 
 */
package com.Indoera.ecomProject.Utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author shiva
 * Added on 12-Jun-2021
 * Package  
 */


public class EncryptionDecryptionAES {  
	
	private static final  Logger logger = LogManager.getLogger(EncryptionDecryptionAES.class);
	
	
	public  String encrypt(String str) {
		int key = 8;
		String st = "";		
		char[] chr = str.toCharArray();
		for(char c : chr) {
			c += key;
			st +=  Character.toString(c);
		}
		return st;
	}
	
	
	public String decrypt(String str) {
		int key = 8;
		String st = "";		
		char[] chr = str.toCharArray();
		for(char c : chr) {
			c -= key;
			st +=  Character.toString(c);
		}
		return st;
	}


//   
//    public  String encrypt(String plainText, SecretKey secretKey,Cipher cipher) throws Exception {
//		logger.info("Secret Key While adding a new Store is :     :     {  "+secretKey+"  } AND CYPHER IS : :  { " + cipher+ "  }");
//    	String encryptedText = "";
//		try {
//			byte[] plainTextByte = plainText.getBytes();
//			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//			byte[] encryptedByte = cipher.doFinal(plainTextByte);
//			Base64.Encoder encoder = Base64.getEncoder();
//			encryptedText = encoder.encodeToString(encryptedByte);
//			  return encryptedText;
//		} catch (InvalidKeyException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalBlockSizeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (BadPaddingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		logger.info("Returened Encrypted Text : : " + encryptedText);
//		return encryptedText;
//    }
//
//    public String decrypt(String encryptedText, SecretKey secretKey,Cipher cipher)throws Exception {
//		logger.info("Secret Key While Fetching the Store is :     :     {  "+secretKey+"  } AND CYPHER IS : :  { " + cipher+ "  }");
//
//    	System.out.println("String come to Decrypt : " + encryptedText);
//        Base64.Decoder decoder = Base64.getDecoder();
//        byte[] encryptedTextByte = decoder.decode(encryptedText);
//        cipher.init(Cipher.DECRYPT_MODE, secretKey);
//        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
//        String decryptedText = new String(decryptedByte);
//        return decryptedText;
//    }


    


}