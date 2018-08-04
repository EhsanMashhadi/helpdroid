package nuesoft.helpdroid;

import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import javax.crypto.SecretKey;

import nuesoft.helpdroid.crypto.CryptoUtil;

public class CryptoUtilTest {
    private static final String PKDF2_HMAC_SHA1 = "PBKDF2WithHmacSHA1";
    private static final String ENCRYPTION_ALGORITHM = "AES";

    @Test
    public void testGenerateRandom_success() {

        byte[] random = CryptoUtil.getSecureRandom(32);
        Assert.assertNotNull(random);
    }

    @Test
    public void testGenerateKey_pbkdf2WithHmacSha1() {

        byte[] pin = new byte[16];
        byte[] salt = new byte[16];
        SecretKey secretKey = CryptoUtil.keyDerivationBasedOnPBE(pin, salt, PKDF2_HMAC_SHA1, ENCRYPTION_ALGORITHM, 1000, 512);
        Assert.assertNotNull(secretKey);
    }

    @Test
    public void testEncrypt_aes128() {

        byte[] iv = new byte[16];
        byte[] key = new byte[16];
        byte[] plainText = null;
        try {
            plainText = "This is plain text".getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Assert.fail(e.getMessage());
        }
        byte[] cipherText = CryptoUtil.encryptAesCbcPkcs5Padding(key, iv, plainText);
        Assert.assertNotNull(cipherText);
        String cipherTextString = java.util.Base64.getEncoder().encodeToString(cipherText);
        Assert.assertEquals(cipherTextString, "dZYt1sj/enRcMesqFJ08qR5t1QVYq6GWSzCKQjr18hs=");
    }

    @Test
    public void testDecrypt_aes128() {

        byte[] iv = new byte[16];
        byte[] key = new byte[16];
        byte[] cipherText = java.util.Base64.getDecoder().decode("dZYt1sj/enRcMesqFJ08qR5t1QVYq6GWSzCKQjr18hs=");
        byte[] plainText = CryptoUtil.decryptAesCbcPkcs5Padding(key, iv, cipherText);
        String plainTextString = null;
        try {
            plainTextString = new String(plainText, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Assert.fail(e.getLocalizedMessage());
        }
        Assert.assertEquals(plainTextString, "This is plain text");
    }

    @Test
    public void testEncrypt_aes256() {

        byte[] iv = new byte[16];
        byte[] key = new byte[32];
        byte[] plainText = null;
        try {
            plainText = "This is plain text".getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            Assert.fail(e.getMessage());
        }
        byte[] cipherText = CryptoUtil.encryptAesCbcPkcs5Padding(key, iv, plainText);
        Assert.assertNotNull(cipherText);
        String cipherTextString = java.util.Base64.getEncoder().encodeToString(cipherText);
        Assert.assertEquals(cipherTextString, "/I7IYZYFF/SEpJ1A8QQZsiD4lAKjALR6v54JMBBg4cE=");
    }

    @Test
    public void testDecrypt_aes256() {

        byte[] iv = new byte[16];
        byte[] key = new byte[32];
        byte[] cipherText = java.util.Base64.getDecoder().decode("/I7IYZYFF/SEpJ1A8QQZsiD4lAKjALR6v54JMBBg4cE=");
        byte[] plainText = CryptoUtil.decryptAesCbcPkcs5Padding(key, iv, cipherText);
        String plainTextString = null;
        try {
            plainTextString = new String(plainText, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Assert.fail(e.getLocalizedMessage());
        }
        Assert.assertEquals(plainTextString, "This is plain text");
    }
}