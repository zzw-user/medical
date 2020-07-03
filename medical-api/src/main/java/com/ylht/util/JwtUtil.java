
package com.ylht.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private static final long EXPIRE_TIME = 86400000L;
    private static final String TOKEN_SECRET = "f26e587c28064d0e855e72c0a6a0e618";

    public JwtUtil() {
    }

    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("f26e587c28064d0e855e72c0a6a0e618");
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (Exception var4) {
            return false;
        }
    }

    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("loginName").asString();
        } catch (JWTDecodeException var2) {
            return null;
        }
    }

    public static String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asString();
        } catch (JWTDecodeException var2) {
            return null;
        }
    }

    public static String sign(String username, String userId) {
        try {
            Date date = new Date(System.currentTimeMillis() + 86400000L);
            Algorithm algorithm = Algorithm.HMAC256("f26e587c28064d0e855e72c0a6a0e618");
            Map<String, Object> header = new HashMap(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            return JWT.create().withHeader(header).withClaim("loginName", username).withClaim("userId", userId).withExpiresAt(date).sign(algorithm);
        } catch (UnsupportedEncodingException var5) {
            return null;
        }
    }
}
