package com.athaul.portfolio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Inbound payload for submitting a contact message.
 */
public record ContactRequest(

        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
        String name,

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be a valid email address")
        @Size(max = 254, message = "Email must not exceed 254 characters")
        String email,

        @NotBlank(message = "Subject is required")
        @Size(max = 150, message = "Subject must not exceed 150 characters")
        String subject,

        @NotBlank(message = "Message is required")
        @Size(min = 10, max = 5000, message = "Message must be between 10 and 5000 characters")
        String message
) {
}
