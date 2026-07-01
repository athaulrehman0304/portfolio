package com.athaul.portfolio.mapper;

import com.athaul.portfolio.domain.Education;
import com.athaul.portfolio.dto.EducationResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EducationMapper {

    EducationResponse toResponse(Education education);

}