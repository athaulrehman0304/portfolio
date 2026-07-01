package com.athaul.portfolio.dto;

public record EducationRequest(

        String institution,

        String degree,

        String year,

        String description,

        Integer displayOrder

) {
}