package com.ehsanmashhadi.helpdroid;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.ehsanmashhadi.helpdroid.application.AppSigner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Base64;

public class AppSignerTest {

    @Mock
    private Context mContext;

    @Mock
    private PackageManager mPackageManager;

    @Mock
    private PackageInfo mPackageInfo;

    @Mock
    private Signature mSignature;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSha1() throws PackageManager.NameNotFoundException, CertificateException, NoSuchAlgorithmException {

        Signature[] signatures = {mSignature};
        mPackageInfo.signatures = signatures;

        byte[] bytes = Base64.getDecoder().decode("MIIB3TCCAUYCAQEwDQYJKoZIhvcNAQEFBQAwNzEWMBQGA1UE" +
                "AwwNQW5kcm9pZCBEZWJ1ZzEQMA4GA1UECgwHQW5kcm9pZDELMAkGA1UEBhMCVVMwHhcNMTkwMTE4MTQ0MDI4Whc" +
                "NNDkwMTEwMTQ0MDI4WjA3MRYwFAYDVQQDDA1BbmRyb2lkIERlYnVnMRAwDgYDVQQKDAdBbmRyb2lkMQswCQYDVQ" +
                "QGEwJVUzCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAkHiqYEMLbLhcRLpIGLyzaSePiapg69DqkggLc+sKH" +
                "UVS42p2vI8oCHcJSJL7LAKS3XDYn0iC45MNyH2/yV1Haz+6ldWxVXyDQher9bCMCDzxP7jpy8KjzyZSawGKKpAz" +
                "kxrqNCxDXGg2UZCFFJf5FLX9cwU4UFm48vIpncx1xQkCAwEAATANBgkqhkiG9w0BAQUFAAOBgQBLYFMWkA1qklA" +
                "8BFw+3W/U8lbi9iSihEnxwS3ly1EbTFYth+u/ZPZ/ih84FDaQIcS9VTDXKP2JyP7ItRg4yuRFWKJGsQzL5JKjHf" +
                "YV7oSis2OhYj/ZfMnJv1c3SpvA03fhEIGsFh21FaUgTLTJ12hztVPKP/pclwvB+nsK/qKa/Q==");

        Mockito.when(mSignature.toByteArray()).thenReturn(bytes);
        Mockito.when(mContext.getPackageName()).thenReturn("");
        Mockito.when(mPackageManager.getPackageInfo(Mockito.anyString(), Mockito.anyInt())).thenReturn(mPackageInfo);
        Mockito.when(mContext.getPackageManager()).thenReturn(mPackageManager);

        String sha1Sign = AppSigner.getSign(mContext, AppSigner.DigestType.sha1);

        Assert.assertEquals(sha1Sign, "56C4822421A1651D1CDF7041DE3A3F345BD37D30");
    }

    @Test
    public void testSha256() throws PackageManager.NameNotFoundException, CertificateException, NoSuchAlgorithmException {

        Signature[] signatures = {mSignature};
        mPackageInfo.signatures = signatures;

        byte[] bytes = Base64.getDecoder().decode("MIIB3TCCAUYCAQEwDQYJKoZIhvcNAQEFBQAwNzEWMBQGA1UEAwwNQW5kcm9pZ" +
                "CBEZWJ1ZzEQMA4GA1UECgwHQW5kcm9pZDELMAkGA1UEBhMCVVMwHhcNMTkwMTE4MTQ0MDI4WhcNNDkwMTEwMTQ0MDI4WjA3MRYw" +
                "FAYDVQQDDA1BbmRyb2lkIERlYnVnMRAwDgYDVQQKDAdBbmRyb2lkMQswCQYDVQQGEwJVUzCBnzANBgkqhkiG9w0BAQEFAAOBjQA" +
                "wgYkCgYEAkHiqYEMLbLhcRLpIGLyzaSePiapg69DqkggLc+sKHUVS42p2vI8oCHcJSJL7LAKS3XDYn0iC45MNyH2/yV1Haz+6ld" +
                "WxVXyDQher9bCMCDzxP7jpy8KjzyZSawGKKpAzkxrqNCxDXGg2UZCFFJf5FLX9cwU4UFm48vIpncx1xQkCAwEAATANBgkqhkiG9" +
                "w0BAQUFAAOBgQBLYFMWkA1qklA8BFw+3W/U8lbi9iSihEnxwS3ly1EbTFYth+u/ZPZ/ih84FDaQIcS9VTDXKP2JyP7ItRg4yuRF" +
                "WKJGsQzL5JKjHfYV7oSis2OhYj/ZfMnJv1c3SpvA03fhEIGsFh21FaUgTLTJ12hztVPKP/pclwvB+nsK/qKa/Q==");

        Mockito.when(mSignature.toByteArray()).thenReturn(bytes);
        Mockito.when(mContext.getPackageName()).thenReturn("");
        Mockito.when(mPackageManager.getPackageInfo(Mockito.anyString(), Mockito.anyInt())).thenReturn(mPackageInfo);
        Mockito.when(mContext.getPackageManager()).thenReturn(mPackageManager);

        String sha256Sign = AppSigner.getSign(mContext, AppSigner.DigestType.sha256);

        Assert.assertEquals(sha256Sign, "4962D0075ABB969C4501D4619FE42AA43D0640CDA4F9EADB93443CC50A64DB57");
    }
}
