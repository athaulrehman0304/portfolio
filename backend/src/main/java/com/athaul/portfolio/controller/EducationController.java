package com.athaul.portfolio.controller;

import com.athaul.portfolio.dto.EducationResponse;
import com.athaul.portfolio.service.EducationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/education")
public class EducationController {

    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping
    public ResponseEntity<List<EducationResponse>> getEducation() {

        return ResponseEntity.ok(
                educationService.getEducation()
        );

    }

}