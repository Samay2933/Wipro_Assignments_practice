package com.task.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
	/*
	 Generate a token

Extract username from token

Extract ownerId from token

Check if token is valid

Check if token is expired

create, read, and validate JWT tokens for authentication.
	 * */
    
    private static final String SECRET = "mySecretKeyForJWTTokenGenerationPlayStoreApplication12345";
    private static final long EXPIRATION_TIME = 86400000; // 24 hours
    
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }
    
    public String generateToken(String username, Long ownerId) {
        return Jwts.builder()
                .setSubject(username)
                .claim("ownerId", ownerId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }
    
    public Long extractOwnerId(String token) {
        return extractClaims(token).get("ownerId", Long.class);
    }
    
    public boolean validateToken(String token) {
        try {
            extractClaims(token);
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }
    
    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    
    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
}