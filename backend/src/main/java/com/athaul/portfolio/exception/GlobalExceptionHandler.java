package com.athaul.portfolio.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
<<<<<<<<< Temporary merge branch 1
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

import java.net.URI;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Translates application exceptions into RFC 7807 {@link ProblemDetail}
 * responses, keeping error formatting consistent across the API.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String PROBLEM_BASE = "https://api.portfolio.athaul.com/problems/";

    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handleResourceNotFound(ResourceNotFoundException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problem.setTitle("Resource Not Found");
        problem.setType(URI.create(PROBLEM_BASE + "resource-not-found"));
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    /**
     * Handles bean-validation failures on {@code @Valid @RequestBody} arguments.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> fieldErrors = new TreeMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.putIfAbsent(error.getField(), error.getDefaultMessage());
        }

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST, "Validation failed for one or more fields");
        problem.setTitle("Validation Error");
        problem.setType(URI.create(PROBLEM_BASE + "validation-error"));
        problem.setProperty("timestamp", Instant.now());
        problem.setProperty("errors", fieldErrors);
        return problem;
    }

    /**
     * Handles constraint violations on method parameters (e.g. {@code @PathVariable}).
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ProblemDetail handleConstraintViolation(ConstraintViolationException ex) {
        Map<String, String> violations = new LinkedHashMap<>();
        ex.getConstraintViolations().forEach(violation ->
                violations.put(violation.getPropertyPath().toString(), violation.getMessage()));

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST, "Validation failed for one or more parameters");
        problem.setTitle("Validation Error");
        problem.setType(URI.create(PROBLEM_BASE + "validation-error"));
        problem.setProperty("timestamp", Instant.now());
        problem.setProperty("errors", violations);
        return problem;
    }

    /**
<<<<<<< HEAD
     * Handles failed login attempts (bad credentials, disabled accounts, unknown
     * users). A uniform message avoids disclosing which factor failed.
     */
    @ExceptionHandler({BadCredentialsException.class, DisabledException.class, AuthenticationException.class})
    public ProblemDetail handleAuthentication(AuthenticationException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.UNAUTHORIZED, "Invalid email or password");
        problem.setTitle("Authentication Failed");
        problem.setType(URI.create(PROBLEM_BASE + "authentication-failed"));
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }

    /**
=========
>>>>>>>>> Temporary merge branch 2
     * Fallback for unhandled exceptions, returning a generic 500 without leaking internals.
     */
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleUnexpected(Exception ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred");
        problem.setTitle("Internal Server Error");
        problem.setType(URI.create(PROBLEM_BASE + "internal-error"));
        problem.setProperty("timestamp", Instant.now());
        return problem;
    }
}
