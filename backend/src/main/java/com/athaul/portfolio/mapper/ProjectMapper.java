package com.athaul.portfolio.mapper;

import com.athaul.portfolio.domain.Project;
import com.athaul.portfolio.dto.ProjectRequest;
import com.athaul.portfolio.dto.ProjectResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Maps {@link Project} entities to and from their API representations.
 */
@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toResponse(Project project);

    /**
     * Builds a new {@link Project} from a create request. Server-managed fields
     * are ignored so they are populated by JPA lifecycle callbacks.
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Project toEntity(ProjectRequest request);

    /**
     * Applies an update request onto an existing managed entity. The {@code tags}
     * collection is handled explicitly in the service to keep Hibernate's
     * orphan-removal behaviour predictable.
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(ProjectRequest request, @MappingTarget Project project);
}
