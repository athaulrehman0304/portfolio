package com.athaul.portfolio.service;

import com.athaul.portfolio.dto.SkillResponse;
import com.athaul.portfolio.mapper.SkillMapper;
import com.athaul.portfolio.repository.SkillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    public SkillServiceImpl(SkillRepository skillRepository,
                            SkillMapper skillMapper) {
        this.skillRepository = skillRepository;
        this.skillMapper = skillMapper;
    }

    @Override
    public List<SkillResponse> getSkills() {
        return skillRepository.findAllByOrderByDisplayOrderAsc()
                .stream()
                .map(skillMapper::toResponse)
                .toList();
    }
}