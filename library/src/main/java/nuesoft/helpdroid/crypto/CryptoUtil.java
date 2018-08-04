package nuesoft.helpdroid.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
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

    public static SecretKey keyDerivationBasedOnPBE(byte[] pin, byte[] salt, String pbeAlgorithm, String encryptionAlgorithm, int iterationNo, int keySize) {

        try {
            if (salt == null) {
                salt = getSecureRandom(16);
            }
            SecretKeyFactory factory = SecretKeyFactory.getInstance(pbeAlgorithm);
            char[] pinCharArray = new String(pin).toCharArray();
            PBEKeySpec spec = new PBEKeySpec(pinCharArray, salt, iterationNo, keySize);
            SecretKey tmp = factory.generateSecret(spec);
            return new SecretKeySpec(tmp.getEncoded(), encryptionAlgorithm);

        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (InvalidKeySpecException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
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
    public static byte[] encryptAesCbcPkcs5Padding(byte[] key, byte[] iv, byte[] plainText) {

        final String algorithm = "AES/CBC/PKCS5Padding";
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            SecretKey secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
            byte[] cipherText = cipher.doFinal(plainText);
            return cipherText;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param key        Depend on key size (16 byte,32 byte, 64 byte) the AES algorithm will change.
     * @param iv         Must be random.
     * @param cipherText Cipher text which will be decrypted.
     * @return Plain Text.
     */
    public static byte[] decryptAesCbcPkcs5Padding(byte[] key, byte[] iv, byte[] cipherText) {

        final String algorithm = "AES/CBC/PKCS5Padding";
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            SecretKey secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            byte[] plainText = cipher.doFinal(cipherText);
            return plainText;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }
}