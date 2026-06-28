package com.athaul.portfolio.exception;

/**
 * Thrown when a {@code Project} with the given identifier does not exist.
 */
public class ProjectNotFoundException extends ResourceNotFoundException {

    public ProjectNotFoundException(Long id) {
        super("Project not found with id: " + id);
    }
}
