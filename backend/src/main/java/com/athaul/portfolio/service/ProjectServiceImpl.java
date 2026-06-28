package com.athaul.portfolio.service;

import com.athaul.portfolio.domain.Project;
import com.athaul.portfolio.dto.ProjectRequest;
import com.athaul.portfolio.dto.ProjectResponse;
import com.athaul.portfolio.exception.ProjectNotFoundException;
import com.athaul.portfolio.mapper.ProjectMapper;
import com.athaul.portfolio.repository.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public Page<ProjectResponse> getProjects(Pageable pageable) {
        return projectRepository.findAll(pageable)
                .map(projectMapper::toResponse);
    }

    @Override
    public ProjectResponse getProjectById(Long id) {
        return projectRepository.findById(id)
                .map(projectMapper::toResponse)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }

    @Override
    @Transactional
    public ProjectResponse createProject(ProjectRequest request) {
        Project project = projectMapper.toEntity(request);
        project.setTags(sanitizeTags(request.tags()));
        Project saved = projectRepository.save(project);
        return projectMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public ProjectResponse updateProject(Long id, ProjectRequest request) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));

        projectMapper.updateEntity(request, project);
        replaceTags(project, sanitizeTags(request.tags()));

        Project saved = projectRepository.save(project);
        return projectMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new ProjectNotFoundException(id);
        }
        projectRepository.deleteById(id);
    }

    private List<String> sanitizeTags(List<String> tags) {
        if (tags == null) {
            return new ArrayList<>();
        }
        List<String> sanitized = new ArrayList<>(tags.size());
        for (String tag : tags) {
            if (tag != null && !tag.isBlank()) {
                sanitized.add(tag.trim());
            }
        }
        return sanitized;
    }

    /**
     * Mutates the managed collection in place so Hibernate tracks orphan removal
     * rather than replacing the collection reference.
     */
    private void replaceTags(Project project, List<String> tags) {
        project.getTags().clear();
        project.getTags().addAll(tags);
    }
}
