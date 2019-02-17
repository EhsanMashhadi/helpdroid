package com.ehsanmashhadi.helpdroid;


import com.ehsanmashhadi.helpdroid.util.Parser;

import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by mysterious on 9/12/17.
 */

public class ParserTest {

    @Test
    public void testGetJwtBody() {

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6Il" +
                "Rlc3QiLCJpYXQiOjE1MTYyMzkwMjJ9.r2tIfSQyjfh-s0S3IXibZ5ftEeqK7_KfkXPuPBkfFm8";
        Map<String, Object> body = Parser.getJwtBody(token);
        Assert.assertEquals(body.get("sub"), "1234567890");
        Assert.assertEquals(body.get("name"), "Test");
        Assert.assertEquals(body.get("iat"), 1516239022);
    }

    @Test
    public void testUriQueryToMap() throws UnsupportedEncodingException {
        String string = "key1=value1&key2=value2";
        Map<String, String> map = Parser.UriQueryToMap(string);
        Assert.assertEquals(map.get("key1"), "value1");
        Assert.assertEquals(map.get("key2"), "value2");
    }
}