package com.athaul.portfolio.service;

import com.athaul.portfolio.dto.LoginRequest;
import com.athaul.portfolio.dto.LoginResponse;
import com.athaul.portfolio.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Default {@link AuthenticationService} that delegates credential verification
 * to the Spring Security {@link AuthenticationManager} and mints a JWT on
 * success.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password()));

        UserDetails principal = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(principal.getUsername());
        return LoginResponse.bearer(token, jwtService.getExpirationMillis());
    }
}
