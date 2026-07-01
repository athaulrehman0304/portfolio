package com.athaul.portfolio.dto;

public record EducationResponse(

        Long id,

        String institution,

        String degree,

        String year,

        String description,

        Integer displayOrder

) {
}
