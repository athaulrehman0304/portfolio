package com.athaul.portfolio.repository;

import com.athaul.portfolio.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}