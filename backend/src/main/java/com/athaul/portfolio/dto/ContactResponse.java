package com.athaul.portfolio.dto;

import java.time.Instant;

/**
 * Response returned after a contact message is successfully accepted.
 */
public record ContactResponse(
        Long id,
        String status,
        Instant createdAt
) {
}
