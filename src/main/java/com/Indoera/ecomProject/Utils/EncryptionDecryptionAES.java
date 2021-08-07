/**
 * 
 */
package com.Indoera.ecomProject.Utils;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;    
import javax.crypto.Cipher;  
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * @author shiva
 * Added on 12-Jun-2021
 * Package  
 */


public class EncryptionDecryptionAES {  
    static Cipher cipher;  
   static SecretKey secretKey;

//    public EncryptionDecryptionAES() {
//    	try {
//    		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//			keyGenerator.init(128); // block size is 128bits
//			 secretKey = keyGenerator.generateKey();
//			cipher = Cipher.getInstance("AES"); //SunJCE provider AES algorithm, mode(optional) and padding schema(optional)  
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchPaddingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//    }

    public  String encrypt(String plainText, SecretKey secretKey) throws Exception {
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    
    }

    public  String decrypt(String encryptedText, SecretKey secretKey)
            throws Exception {
    	System.out.println("String come to Decrypt : " + encryptedText);
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }


    
//    public static void main(String[] args) throws Exception {
//    	EncryptionDecryptionAES en = new EncryptionDecryptionAES();	
//        String plainText = "Hello";
//        System.out.println("Plain Text Before Encryption: " + plainText);
//        String encryptedText = en.encrypt(plainText, secretKey);
//        System.out.println("Encrypted Text After Encryption: " + encryptedText);
//        String decryptedText = en.decrypt(encryptedText, secretKey);
//        System.out.println("Decrypted Text After Decryption: " + decryptedText);
//    }


}