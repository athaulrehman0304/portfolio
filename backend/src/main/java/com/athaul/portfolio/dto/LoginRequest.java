package com.athaul.portfolio.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Credentials submitted to the login endpoint.
 */
@Schema(description = "Administrator login credentials")
public record LoginRequest(

        @Schema(example = "admin@athaul.com")
        @NotBlank(message = "Email is required")
        @Email(message = "Email must be a valid email address")
        String email,

        @Schema(example = "your-password")
        @NotBlank(message = "Password is required")
        String password
) {
}
