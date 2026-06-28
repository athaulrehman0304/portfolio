package com.athaul.portfolio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.List;

/**
 * Inbound payload for creating or updating a portfolio project.
 *
 * <p>Validation mirrors the persistence constraints defined on the
 * {@code projects} and {@code project_tags} tables.</p>
 */
public record ProjectRequest(

        @NotBlank(message = "Title is required")
        @Size(max = 200, message = "Title must not exceed 200 characters")
        String title,

        @NotBlank(message = "Description is required")
        @Size(max = 2000, message = "Description must not exceed 2000 characters")
        String description,

        @Size(max = 500, message = "Repository URL must not exceed 500 characters")
        String repositoryUrl,

        @Size(max = 500, message = "Live URL must not exceed 500 characters")
        String liveUrl,

        @Size(max = 500, message = "Image URL must not exceed 500 characters")
        String imageUrl,

        List<@NotBlank(message = "Tag must not be blank")
             @Size(max = 50, message = "Tag must not exceed 50 characters") String> tags,

        @NotNull(message = "Featured flag is required")
        Boolean featured,

        @NotNull(message = "Display order is required")
        @PositiveOrZero(message = "Display order must be zero or positive")
        Integer displayOrder
) {
}
