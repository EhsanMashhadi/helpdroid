package nuesoft.helpdroid;

import org.junit.Assert;
import org.junit.Test;

import javax.crypto.SecretKey;

import nuesoft.helpdroid.crypto.CryptoUtil;

public class CryptoUtilTest {

    private static final String PKDF2_HMAC_SHA1 = "PBKDF2WithHmacSHA1";
    private static final String ENCRYPTION_ALGORITHM = "AES";

    @Test
    public void generateKey() {

        byte[] pin = new byte[16];
        byte[] salt = new byte[16];
        SecretKey secretKey = CryptoUtil.keyDerivationBasedOnPBE(pin, salt, PKDF2_HMAC_SHA1, ENCRYPTION_ALGORITHM, 1000, 512);
        Assert.assertNotNull(secretKey);
    }
}
