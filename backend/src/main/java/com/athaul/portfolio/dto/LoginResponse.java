package com.athaul.portfolio.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Successful authentication response containing a bearer access token.
 */
@Schema(description = "Issued access token")
public record LoginResponse(

        @Schema(description = "Signed JWT access token")
        String accessToken,

        @Schema(description = "Token scheme to use in the Authorization header", example = "Bearer")
        String tokenType,

        @Schema(description = "Token lifetime in milliseconds", example = "86400000")
        long expiresIn
) {

    public static LoginResponse bearer(String accessToken, long expiresIn) {
        return new LoginResponse(accessToken, "Bearer", expiresIn);
    }
}
