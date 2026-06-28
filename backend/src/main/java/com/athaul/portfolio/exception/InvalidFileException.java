package com.athaul.portfolio.exception;

/**
 * Thrown when an uploaded file fails validation (unsupported type, empty, or
 * oversized). Mapped to HTTP 400 by the {@link GlobalExceptionHandler}.
 */
public class InvalidFileException extends RuntimeException {

    public InvalidFileException(String message) {
        super(message);
    }
}
