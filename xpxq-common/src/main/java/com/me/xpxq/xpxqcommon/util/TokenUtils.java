package com.me.xpxq.xpxqcommon.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.jackson.io.JacksonDeserializer;
import io.jsonwebtoken.lang.Maps;
import io.jsonwebtoken.security.Keys;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.Map;


public class TokenUtils {
    public static String encode(String username){
        Map<String,String> claims = new HashMap<String, String>();
        claims.put("username",username);
        SecretKey key = getSecretkey();
        return Jwts.builder().setClaims(claims).signWith(key).compact();
    }

    public static String decode(String token){
        Claims claims = Jwts.parserBuilder().setSigningKey(getSecretkey()).setAllowedClockSkewSeconds(180L)
                .deserializeJsonWith(new JacksonDeserializer(Maps.of("username", String.class).build())).build()
                .parseClaimsJws(token).getBody();
        String username = (String) claims.get("username");
        return username;
    }

    private static SecretKey getSecretkey() {
        return Keys.hmacShaKeyFor(Base64.encode("eyJ1c2VybmFtZSI6IjEyMzQ0NDQ0In0".getBytes()));
    }
}
