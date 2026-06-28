package com.athaul.portfolio.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Serves uploaded files as static resources from the configured storage
 * directory under the configured public URL prefix, so uploaded images are
 * publicly accessible without going through a controller.
 */
@Configuration
@EnableConfigurationProperties(StorageProperties.class)
public class StaticResourceConfig implements WebMvcConfigurer {

    private final StorageProperties properties;

    public StaticResourceConfig(StorageProperties properties) {
        this.properties = properties;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path location = Paths.get(properties.getLocation()).toAbsolutePath().normalize();
        String resourceLocation = location.toUri().toString();

        String prefix = StringUtils.trimTrailingCharacter(properties.getPublicUrlPrefix(), '/');
        String pattern = prefix + "/**";

        registry.addResourceHandler(pattern)
                .addResourceLocations(resourceLocation);
    }
}
