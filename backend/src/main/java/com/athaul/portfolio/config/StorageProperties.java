package com.athaul.portfolio.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * Externalized file-storage configuration bound from the {@code app.storage}
 * prefix. Keeping the upload location and public URL prefix in configuration
 * allows production deployments to point at a persistent, mounted volume.
 */
@Validated
@ConfigurationProperties(prefix = "app.storage")
public class StorageProperties {

    /**
     * Directory where uploaded files are written.
     */
    @NotBlank
    private String location;

    /**
     * Public URL path prefix under which uploaded files are served.
     */
    @NotBlank
    private String publicUrlPrefix;

    /**
     * Maximum accepted file size in bytes.
     */
    @Positive
    private long maxFileSizeBytes;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPublicUrlPrefix() {
        return publicUrlPrefix;
    }

    public void setPublicUrlPrefix(String publicUrlPrefix) {
        this.publicUrlPrefix = publicUrlPrefix;
    }

    public long getMaxFileSizeBytes() {
        return maxFileSizeBytes;
    }

    public void setMaxFileSizeBytes(long maxFileSizeBytes) {
        this.maxFileSizeBytes = maxFileSizeBytes;
    }
}
