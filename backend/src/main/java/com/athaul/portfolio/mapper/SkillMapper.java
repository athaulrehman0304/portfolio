package com.athaul.portfolio.mapper;

import com.athaul.portfolio.domain.Skill;
import com.athaul.portfolio.dto.SkillResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {

    SkillResponse toResponse(Skill skill);
}