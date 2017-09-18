package nuesoft.helpdroid;

import junit.framework.Assert;

import org.junit.Test;

import java.util.Map;

import nuesoft.helpdroid.util.Parser;

/**
 * Created by mysterious on 9/12/17.
 */

public class JWTParserTest {

    @Test
    public void testJwtToken() {
        String token = "eyJleHAiOjE0OTQ5MTYyNzIsImlhdCI6MTQ5NDgyOTg3MiwiYWxnIjoiSFMyNTYifQ.eyJzZXNzaW9uSWQiOiJiZTQ2OWJmOC01Y2ZkLTQzNGMtOTEzNC01MTdkNmI3MDg3ZTIiLCJuYW1lIjoiRWhzYW4iLCJzcGVjaWFsaXR5SWQiOjEsImlkIjo2LCJyb2xlcyI6WyJ1c2VyIl0sImVtYWlsIjoiZWhzYW5AY2FycmVuZS5jb20ifQ.";
        Map<String, Object> body = Parser.getTokenBody(token);
        Assert.assertEquals(body.get("name"), "Ehsan");
        Assert.assertEquals(body.get("email"), "ehsan@carrene.com");
        Assert.assertEquals(body.get("specialityId"), 1);
    }
}
