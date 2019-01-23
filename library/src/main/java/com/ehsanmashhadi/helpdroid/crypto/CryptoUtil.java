package com.ehsanmashhadi.helpdroid.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtil {

    static {
        Security.setProperty("crypto.policy", "unlimited");
    }

    public static SecretKey keyDerivationBasedOnPBE(byte[] pin, byte[] salt, String pbeAlgorithm, String encryptionAlgorithm, int iterationNo, int keySize) throws NoSuchAlgorithmException, InvalidKeySpecException {

        if (salt == null) {
            salt = getSecureRandom(16);
        }
        SecretKeyFactory factory = SecretKeyFactory.getInstance(pbeAlgorithm);
        char[] pinCharArray = new String(pin).toCharArray();
        PBEKeySpec spec = new PBEKeySpec(pinCharArray, salt, iterationNo, keySize);
        SecretKey tmp = factory.generateSecret(spec);
        return new SecretKeySpec(tmp.getEncoded(), encryptionAlgorithm);
    }

    /**
     * @param length The size of generated random byte array.
     * @return The random byte array.
     */
    public static byte[] getSecureRandom(int length) {

        //Using default constructor let the OS choose the best random generator
        SecureRandom secureRandom = new SecureRandom();
        byte[] bytes = new byte[length];
        secureRandom.nextBytes(bytes);
        return bytes;
    }

    /**
     * @param key       Depend on key size (16 byte,32 byte, 64 byte) the AES algorithm will change.
     * @param iv        Must be random.
     * @param plainText Plain text which will be encrypted.
     * @return Cipher Text
     */
    public static byte[] encryptAesCbcPkcs5Padding(byte[] key, byte[] iv, byte[] plainText) throws NoSuchPaddingException, NoSuchAlgorithmException,
            BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException {

        final String algorithm = "AES/CBC/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(algorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        SecretKey secretKey = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        byte[] cipherText = cipher.doFinal(plainText);
        return cipherText;
    }

    /**
     * @param key        Depend on key size (16 byte,32 byte, 64 byte) the AES algorithm will change.
     * @param iv         Must be random.
     * @param cipherText Cipher text which will be decrypted.
     * @return Plain Text.
     */
    public static byte[] decryptAesCbcPkcs5Padding(byte[] key, byte[] iv, byte[] cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException
            , InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        final String algorithm = "AES/CBC/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(algorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        SecretKey secretKey = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] plainText = cipher.doFinal(cipherText);
        return plainText;
    }

    public static byte[] hmac(HmacType hmacType, byte[] key, byte[] data) throws InvalidKeyException, NoSuchAlgorithmException {

        SecretKeySpec hmacKey = new SecretKeySpec(key, hmacType.toString());
        Mac mac = Mac.getInstance(hmacType.toString());
        mac.init(hmacKey);
        return mac.doFinal(data);
    }

    public static byte[] sha128(String value) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest messageDigest = null;
        messageDigest = MessageDigest.getInstance("SHA1");
        messageDigest.update(value.getBytes("UTF-8"));
        byte[] digest = messageDigest.digest();
        return digest;
    }

    public static byte[] sha256(String value) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        MessageDigest messageDigest = null;
        messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(value.getBytes("UTF-8"));
        byte[] digest = messageDigest.digest();
        return digest;
    }

    public static byte[] sha512(String value) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        MessageDigest messageDigest = null;
        messageDigest = MessageDigest.getInstance("SHA-512");
        messageDigest.update(value.getBytes("UTF-8"));
        byte[] digest = messageDigest.digest();
        return digest;
    }
}