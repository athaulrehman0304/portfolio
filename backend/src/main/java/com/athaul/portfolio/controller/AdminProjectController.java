package com.athaul.portfolio.controller;

import com.athaul.portfolio.dto.ProjectRequest;
import com.athaul.portfolio.dto.ProjectResponse;
import com.athaul.portfolio.service.ProjectService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Administrative REST API for managing portfolio projects.
 *
 * <p>This controller is intentionally isolated under the {@code /api/v1/admin}
 * path prefix. The endpoints are currently public, but the dedicated prefix and
 * controller allow Spring Security/JWT to later protect every administrative
 * operation by securing a single URL pattern, with no changes to this class.</p>
 */
@RestController
@RequestMapping("/api/v1/admin/projects")
@Validated
public class AdminProjectController {

    private final ProjectService projectService;

    public AdminProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> create(
            @Valid @RequestBody ProjectRequest request,
            UriComponentsBuilder uriBuilder) {
        ProjectResponse created = projectService.createProject(request);
        URI location = uriBuilder.path("/api/v1/projects/{id}")
                .buildAndExpand(created.id())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> update(
            @PathVariable @Positive Long id,
            @Valid @RequestBody ProjectRequest request) {
        return ResponseEntity.ok(projectService.updateProject(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Positive Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
