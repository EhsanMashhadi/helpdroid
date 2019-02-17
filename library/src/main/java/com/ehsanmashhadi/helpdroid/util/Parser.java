package com.ehsanmashhadi.helpdroid.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import androidx.annotation.NonNull;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;

/**
 * Created by mysterious on 9/12/17.
 */

public class Parser {

    /**
     * Return JWT body part in map
     *
     * @param jwt The desired JWT.
     * @return Returns a map which consists of JWT body part.
     * @throws NullPointerException If jwt  is null.
     */
    public static Map<String, Object> getJwtBody(@NonNull String jwt) {

        Objects.requireNonNull(jwt);
        String jwtToken = jwt.substring(0, jwt.lastIndexOf(".") + 1);
        Jwt<Header, Claims> untrusted = Jwts.parser().parseClaimsJwt(jwtToken);
        return untrusted.getBody();
    }

    /**
     * Convert URI query to map
     *
     * @param query The desired URI query.
     * @return Returns a map which has the query fields as keys and the query values as values.
     * @throws UnsupportedEncodingException If the query values do not support UTF-8 encoding.
     */
    public static Map<String, String> UriQueryToMap(@NonNull String query) throws UnsupportedEncodingException {

        Objects.requireNonNull(query);
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<>();
        for (String param : params) {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            value = URLDecoder.decode(value, "UTF-8");
            map.put(name, value);
        }
        return map;
    }
}