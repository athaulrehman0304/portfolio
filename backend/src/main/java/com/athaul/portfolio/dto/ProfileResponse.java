package com.athaul.portfolio.dto;

import java.time.Instant;

public record ProfileResponse(
        Long id,
        String name,
        String headline,
        String bio,
        String location,
        String email,
        String degree,
        String availability,
        String githubUrl,
        String linkedinUrl,
        String resumeUrl,
        String profileImage,
        Instant createdAt,
        Instant updatedAt
) {
}