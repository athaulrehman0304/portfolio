package com.athaul.portfolio.dto;

import java.time.Instant;
import java.util.List;

/**
 * Read model exposed by the public Project REST API.
 */
public record ProjectResponse(
        Long id,
        String title,
        String description,
        String repositoryUrl,
        String liveUrl,
        String imageUrl,
        List<String> tags,
        boolean featured,
        int displayOrder,
        Instant createdAt,
        Instant updatedAt
) {
}
