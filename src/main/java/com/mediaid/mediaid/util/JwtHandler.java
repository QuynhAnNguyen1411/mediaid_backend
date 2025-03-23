package com.mediaid.mediaid.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtHandler {
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateJWT (String accountID){
        return Jwts.builder()
                .setSubject(accountID) // Payload data
                .setIssuedAt(new Date()) // Issued time
                .setExpiration(new Date(System.currentTimeMillis() + 28800000)) // Expires in 1 hour
                .signWith(SECRET_KEY) // Sign with secret key
                .compact(); // Build token
    }
    public static Claims decodeJWT(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
            return claimsJws.getBody();
        } catch (Exception e) {
            System.out.println("Invalid JWT: " + e.getMessage());
            return null;
        }
    }
}
