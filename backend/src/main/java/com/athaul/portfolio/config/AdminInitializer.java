package com.athaul.portfolio.config;

import com.athaul.portfolio.domain.Role;
import com.athaul.portfolio.domain.User;
import com.athaul.portfolio.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Seeds a single {@code ADMIN} account for local development.
 *
 * <p>Active only under the {@code dev} profile, so it never runs in production.
 * The account is created only when no user with the configured email exists,
 * making startup idempotent.</p>
 */
@Component
@Profile("dev")
@EnableConfigurationProperties(AdminProperties.class)
public class AdminInitializer implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(AdminInitializer.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminProperties adminProperties;

    public AdminInitializer(UserRepository userRepository,
                            PasswordEncoder passwordEncoder,
                            AdminProperties adminProperties) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.adminProperties = adminProperties;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
        final String email = adminProperties.getEmail();

        if (userRepository.findByEmail(email).isPresent()) {
            log.info("[dev] Admin account '{}' already exists; skipping seed.", email);
            return;
        }

        User admin = new User();
        admin.setEmail(email);
        admin.setPasswordHash(passwordEncoder.encode(adminProperties.getPassword()));
        admin.setRole(Role.ADMIN);
        admin.setEnabled(true);
        userRepository.save(admin);

        log.warn("[dev] Seeded development admin account '{}'. Do not use in production.", email);
    }
}
