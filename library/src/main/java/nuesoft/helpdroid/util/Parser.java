package nuesoft.helpdroid.util;

import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;

/**
 * Created by mysterious on 9/12/17.
 */

public class Parser {

    public static Map<String, Object> getTokenBody(String jwsToken) {
        String jwtToken = jwsToken.substring(0, jwsToken.lastIndexOf(".") + 1);
        Jwt<Header, Claims> untrusted = Jwts.parser().parseClaimsJwt(jwtToken);
        return untrusted.getBody();
    }
}