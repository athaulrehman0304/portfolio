package com.athaul.portfolio.service;

import com.athaul.portfolio.dto.ProjectRequest;
import com.athaul.portfolio.dto.ProjectResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Application service exposing read and administrative operations for
 * portfolio projects.
 */
public interface ProjectService {

    /**
     * Returns a page of projects.
     *
     * @param pageable pagination and sorting information
     * @return a page of {@link ProjectResponse}
     */
    Page<ProjectResponse> getProjects(Pageable pageable);

    /**
     * Returns a single project by its identifier.
     *
     * @param id the project identifier
     * @return the matching {@link ProjectResponse}
     * @throws com.athaul.portfolio.exception.ProjectNotFoundException if no project exists for the id
     */
    ProjectResponse getProjectById(Long id);

    /**
     * Creates a new project.
     *
     * @param request the project details
     * @return the persisted {@link ProjectResponse}
     */
    ProjectResponse createProject(ProjectRequest request);

    /**
     * Fully updates an existing project.
     *
     * @param id      the project identifier
     * @param request the new project details
     * @return the updated {@link ProjectResponse}
     * @throws com.athaul.portfolio.exception.ProjectNotFoundException if no project exists for the id
     */
    ProjectResponse updateProject(Long id, ProjectRequest request);

    /**
     * Deletes an existing project.
     *
     * @param id the project identifier
     * @throws com.athaul.portfolio.exception.ProjectNotFoundException if no project exists for the id
     */
    void deleteProject(Long id);
}
