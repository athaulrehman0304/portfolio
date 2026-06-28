package com.athaul.portfolio.security;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * Externalized JWT configuration bound from the {@code app.security.jwt} prefix.
 */
@Validated
@ConfigurationProperties(prefix = "app.security.jwt")
public class JwtProperties {

    /**
     * Base64-encoded HMAC secret used to sign tokens.
     */
    @NotNull
    private String secret;

    /**
     * Token time-to-live in milliseconds.
     */
    @Positive
    private long expiration;

    /**
     * Token issuer claim.
     */
    @NotNull
    private String issuer;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}
