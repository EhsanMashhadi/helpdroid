package com.ehsanmashhadi.helpdroid.crypto;

import androidx.annotation.NonNull;
import com.ehsanmashhadi.helpdroid.application.AppSigner;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.Objects;

public class CryptoUtil {

    static {
        Security.setProperty("crypto.policy", "unlimited");
    }

    /**
     * Derivate a key based on PBE
     *
     * @param pin                 The context of desired application.
     * @param salt                The salt value which is used in key derivation.
     * @param pbeAlgorithm        The pbe algorithm which derivation algorithm should use.
     * @param encryptionAlgorithm The encryption algorithm which derivation algorithm should use.
     * @param iterationNo         The iteration number which derivation algorithm should use.
     * @param keySize             The desired digest method
     * @return Returns Secret key which is derivated from params.
     * @throws NullPointerException     If pin or pbeAlgorithm or encryptionAlgorithm is null.
     * @throws NoSuchAlgorithmException If no Provider supports CertificateFactorySpi implementation for the specified type.
     * @throws InvalidKeySpecException  If no Provider supports a MessageDigestSpi implementation for the specified algorithm.
     */
    public static SecretKey keyDerivationBasedOnPBE(@NonNull byte[] pin, byte[] salt, @NonNull String pbeAlgorithm
            , String encryptionAlgorithm, int iterationNo, int keySize) throws NoSuchAlgorithmException
            , InvalidKeySpecException {

        Objects.requireNonNull(pin);
        Objects.requireNonNull(pbeAlgorithm);
        Objects.requireNonNull(encryptionAlgorithm);
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
     * Generate a secure random number
     *
     * @param length The length of desired output.
     * @return Returns random number which is generated from a secure random generator.
     */
    public static byte[] getSecureRandom(int length) {

        //Using default constructor let the OS choose the best random generator
        SecureRandom secureRandom = new SecureRandom();
        byte[] bytes = new byte[length];
        secureRandom.nextBytes(bytes);
        return bytes;
    }

    /**
     * Encrypt the plain text using the AES algorithm with iv and key
     *
     * @param key       AES key size (16 bytes,32 bytes, 64 bytes).
     * @param iv        Initial vector which must be a 16 bytes random.
     * @param plainText Plain text which will be encrypted.
     * @return Cipher text.
     */
    public static byte[] encryptAesCbcPkcs5Padding(byte[] key, byte[] iv, byte[] plainText) throws
            NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException
            , IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException {

        Objects.requireNonNull(key);
        Objects.requireNonNull(iv);
        Objects.requireNonNull(plainText);
        final String algorithm = "AES/CBC/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(algorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        SecretKey secretKey = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        return cipher.doFinal(plainText);
    }

    /**
     * Decrypt the cipher text using the AES algorithm with iv and key
     *
     * @param key        AES key size (16 bytes,32 bytes, 64 bytes).
     * @param iv         Initial vector which must be a 16 bytes random.
     * @param cipherText Cipher text which will be decrypted.
     * @return Cipher text.
     */
    public static byte[] decryptAesCbcPkcs5Padding(@NonNull byte[] key, @NonNull byte[] iv, @NonNull byte[] cipherText) throws
            NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException
            , InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Objects.requireNonNull(key);
        Objects.requireNonNull(iv);


        Objects.requireNonNull(cipherText);
        final String algorithm = "AES/CBC/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(algorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        SecretKey secretKey = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        return cipher.doFinal(cipherText);
    }

    /**
     * Calculate HMAC of data with key
     *
     * @param hmacType The type of desired HMAC.
     * @param key      The key of HMAC function.
     * @param data     The data which hmac should be calculated on it.
     * @return Returns HMAC of data.
     * @throws InvalidKeyException      If pin or pbeAlgorithm or encryptionAlgorithm is null.
     * @throws NoSuchAlgorithmException If no Provider supports CertificateFactorySpi implementation for the specified type.
     * @see HmacType
     */
    public static byte[] hmac(@NonNull HmacType hmacType, @NonNull byte[] key, @NonNull byte[] data) throws InvalidKeyException, NoSuchAlgorithmException {
        Objects.requireNonNull(hmacType);
        Objects.requireNonNull(key);
        Objects.requireNonNull(data);
        SecretKeySpec hmacKey = new SecretKeySpec(key, hmacType.toString());
        Mac mac = Mac.getInstance(hmacType.toString());
        mac.init(hmacKey);
        return mac.doFinal(data);
    }

    /**
     * Calculate digest digest of input.
     *
     * @param value      The input value.
     * @param charset    The charset of input string.
     * @param digestType The desired digest type.
     * @return Returns digest of input.
     * @throws InvalidKeyException      If pin or pbeAlgorithm or encryptionAlgorithm is null.
     * @throws NoSuchAlgorithmException If no Provider supports CertificateFactorySpi implementation for the specified type.
     */
    public static byte[] digest(@NonNull String value, @NonNull Charset charset, AppSigner.DigestType digestType)
            throws NoSuchAlgorithmException {

        Objects.requireNonNull(value);
        Objects.requireNonNull(charset);
        MessageDigest messageDigest = MessageDigest.getInstance(digestType.getDigestMethod());
        messageDigest.update(value.getBytes(charset));
        return messageDigest.digest();
    }

    public enum HmacType {
        HmacSHA1,
        HmacSHA256,
        HmacSHA384,
        HmacSHA512
    }
}