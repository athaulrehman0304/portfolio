package com.athaul.portfolio.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * Builds the {@link CorsConfigurationSource} from externalized
 * {@link CorsProperties}, so allowed origins are never hardcoded.
 */
@Configuration
@EnableConfigurationProperties(CorsProperties.class)
public class CorsConfig {

    private final CorsProperties properties;

    public CorsConfig(CorsProperties properties) {
        this.properties = properties;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        if (!properties.getAllowedOrigins().isEmpty()) {
            configuration.setAllowedOriginPatterns(properties.getAllowedOrigins());
        }
        if (!properties.getAllowedMethods().isEmpty()) {
            configuration.setAllowedMethods(properties.getAllowedMethods());
        }
        if (!properties.getAllowedHeaders().isEmpty()) {
            configuration.setAllowedHeaders(properties.getAllowedHeaders());
        }
        configuration.setAllowCredentials(properties.isAllowCredentials());
        configuration.setMaxAge(properties.getMaxAge());

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
