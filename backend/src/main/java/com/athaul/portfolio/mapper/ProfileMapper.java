package com.athaul.portfolio.mapper;

import com.athaul.portfolio.domain.Profile;
import com.athaul.portfolio.dto.ProfileResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileResponse toResponse(Profile profile);

}