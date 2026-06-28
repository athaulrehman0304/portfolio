package com.athaul.portfolio.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

/**
 * Creates and validates signed JWT access tokens. Token lifetime and signing
 * key are sourced from {@link JwtProperties}.
 */
@Service
public class JwtService {

    private final JwtProperties properties;
    private final SecretKey signingKey;

    public JwtService(JwtProperties properties) {
        this.properties = properties;
        this.signingKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(properties.getSecret()));
    }

    /**
     * Issues a signed access token for the given subject (email).
     */
    public String generateToken(String subject) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + properties.getExpiration());
        return Jwts.builder()
                .subject(subject)
                .issuer(properties.getIssuer())
                .issuedAt(now)
                .expiration(expiry)
                .signWith(signingKey)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, String expectedUsername) {
        final String username = extractUsername(token);
        return username != null
                && username.equals(expectedUsername)
                && !isTokenExpired(token);
    }

    public long getExpirationMillis() {
        return properties.getExpiration();
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    private <T> T extractClaim(String token, Function<Claims, T> resolver) {
        Claims claims = Jwts.parser()
                .verifyWith(signingKey)
                .requireIssuer(properties.getIssuer())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return resolver.apply(claims);
    }
}
