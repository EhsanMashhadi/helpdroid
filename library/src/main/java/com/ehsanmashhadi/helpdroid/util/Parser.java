package com.ehsanmashhadi.helpdroid.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;

/**
 * Created by mysterious on 9/12/17.
 */

public class Parser {

    public static Map<String, Object> getTokenBody(String jwt) {

        String jwtToken = jwt.substring(0, jwt.lastIndexOf(".") + 1);
        Jwt<Header, Claims> untrusted = Jwts.parser().parseClaimsJwt(jwtToken);
        return untrusted.getBody();
    }

    public static Map<String, String> URIToQueryToMap(String query) {

        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params) {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            try {
                value = URLDecoder.decode(value, "UTF-8");
            } catch (UnsupportedEncodingException e) {
            }
            map.put(name, value);
        }
        return map;
    }
}