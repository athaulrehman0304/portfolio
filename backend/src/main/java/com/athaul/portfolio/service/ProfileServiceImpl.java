package com.athaul.portfolio.service;

import com.athaul.portfolio.dto.ProfileResponse;
import com.athaul.portfolio.exception.ResourceNotFoundException;
import com.athaul.portfolio.mapper.ProfileMapper;
import com.athaul.portfolio.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public ProfileServiceImpl(ProfileRepository profileRepository,
                              ProfileMapper profileMapper) {
        this.profileRepository = profileRepository;
        this.profileMapper = profileMapper;
    }

    @Override
    public ProfileResponse getProfile() {
        return profileRepository.findById(1L)
                .map(profileMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
    }
}