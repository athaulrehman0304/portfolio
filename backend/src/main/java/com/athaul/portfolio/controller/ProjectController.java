package com.athaul.portfolio.controller;

import com.athaul.portfolio.dto.PageResponse;
import com.athaul.portfolio.dto.ProjectResponse;
import com.athaul.portfolio.service.ProjectService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Positive;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Public read-only REST API for portfolio projects.
 */
@RestController
@RequestMapping("/api/v1/projects")
@Validated
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<PageResponse<ProjectResponse>> getProjects(

            @ParameterObject
            @Parameter(hidden = true)
            @PageableDefault(
                    size = 20,
                    sort = {"displayOrder", "createdAt"},
                    direction = Sort.Direction.ASC
            )
            Pageable pageable) {

        Page<ProjectResponse> page = projectService.getProjects(pageable);
        return ResponseEntity.ok(PageResponse.from(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(
            @PathVariable
            @Positive
            Long id) {

        return ResponseEntity.ok(projectService.getProjectById(id));
    }
}