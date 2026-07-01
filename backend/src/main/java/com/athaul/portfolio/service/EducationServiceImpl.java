package com.athaul.portfolio.service;

import com.athaul.portfolio.dto.EducationResponse;
import com.athaul.portfolio.mapper.EducationMapper;
import com.athaul.portfolio.repository.EducationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;
    private final EducationMapper educationMapper;

    public EducationServiceImpl(EducationRepository educationRepository,
                                EducationMapper educationMapper) {
        this.educationRepository = educationRepository;
        this.educationMapper = educationMapper;
    }

    @Override
    public List<EducationResponse> getEducation() {

        return educationRepository
                .findAllByOrderByDisplayOrderAsc()
                .stream()
                .map(educationMapper::toResponse)
                .toList();

    }
}