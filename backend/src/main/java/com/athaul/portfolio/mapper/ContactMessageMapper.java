package com.athaul.portfolio.mapper;

import com.athaul.portfolio.domain.ContactMessage;
import com.athaul.portfolio.dto.ContactRequest;
import com.athaul.portfolio.dto.ContactResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Maps between {@link ContactMessage} entities and their API representations.
 */
@Mapper(componentModel = "spring")
public interface ContactMessageMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    ContactMessage toEntity(ContactRequest request);

    @Mapping(target = "status", constant = "RECEIVED")
    ContactResponse toResponse(ContactMessage contactMessage);
}
