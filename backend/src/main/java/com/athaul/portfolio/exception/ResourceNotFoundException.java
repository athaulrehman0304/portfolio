package com.athaul.portfolio.exception;

/**
 * Thrown when a requested resource cannot be found. Mapped to HTTP 404 by the
 * {@link GlobalExceptionHandler}.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
