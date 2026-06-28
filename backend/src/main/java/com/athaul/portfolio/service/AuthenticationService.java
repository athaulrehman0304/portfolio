package com.athaul.portfolio.service;

import com.athaul.portfolio.dto.LoginRequest;
import com.athaul.portfolio.dto.LoginResponse;

/**
 * Coordinates authentication and access-token issuance.
 */
public interface AuthenticationService {

    /**
     * Authenticates the supplied credentials and issues an access token.
     *
     * @param request the login credentials
     * @return a {@link LoginResponse} containing the bearer token
     * @throws org.springframework.security.core.AuthenticationException if authentication fails
     */
    LoginResponse login(LoginRequest request);
}
