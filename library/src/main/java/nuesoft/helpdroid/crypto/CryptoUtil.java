package nuesoft.helpdroid.crypto;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public final class CryptoUtil {

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

    private static byte[] getSecureRandom(int length) {

        //Using default constructor let the OS choose the best random generator
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[length];
        secureRandom.nextBytes(salt);
        return salt;
    }
}