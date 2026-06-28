package com.athaul.portfolio.service;

import com.athaul.portfolio.config.StorageProperties;
import com.athaul.portfolio.exception.InvalidFileException;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.UUID;

/**
 * Stores uploaded images on the local filesystem in a configurable directory.
 *
 * <p>Validates that the file is a supported image type and within the size
 * limit, generates a collision-free filename, and guards against path
 * traversal by resolving every write against the configured root.</p>
 */
@Service
public class LocalFileStorageService implements FileStorageService {

    private static final Logger log = LoggerFactory.getLogger(LocalFileStorageService.class);

    /**
     * Allowed image MIME types mapped to their canonical file extension.
     */
    private static final Map<String, String> ALLOWED_TYPES = Map.of(
            "image/jpeg", "jpg",
            "image/png", "png",
            "image/gif", "gif",
            "image/webp", "webp"
    );

    private final StorageProperties properties;
    private Path rootLocation;

    public LocalFileStorageService(StorageProperties properties) {
        this.properties = properties;
    }

    @PostConstruct
    void init() {
        this.rootLocation = Paths.get(properties.getLocation()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(rootLocation);
            log.info("Upload storage directory ready at {}", rootLocation);
        } catch (IOException ex) {
            throw new UncheckedIOException("Could not initialize storage directory: " + rootLocation, ex);
        }
    }

    @Override
    public StoredFile store(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new InvalidFileException("Uploaded file must not be empty");
        }
        if (file.getSize() > properties.getMaxFileSizeBytes()) {
            throw new InvalidFileException(
                    "File exceeds the maximum allowed size of " + properties.getMaxFileSizeBytes() + " bytes");
        }

        String contentType = file.getContentType();
        String extension = ALLOWED_TYPES.get(contentType);
        if (extension == null) {
            throw new InvalidFileException(
                    "Unsupported file type. Allowed types: " + String.join(", ", ALLOWED_TYPES.keySet()));
        }

        String filename = UUID.randomUUID() + "." + extension;
        Path destination = rootLocation.resolve(filename).normalize();

        // Defense-in-depth: ensure the resolved path stays within the root.
        if (!destination.getParent().equals(rootLocation)) {
            throw new InvalidFileException("Invalid file destination");
        }

        try {
            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new UncheckedIOException("Failed to store uploaded file", ex);
        }

        String url = buildPublicUrl(filename);
        return new StoredFile(url, filename);
    }

    private String buildPublicUrl(String filename) {
        String prefix = properties.getPublicUrlPrefix();
        String normalizedPrefix = StringUtils.trimTrailingCharacter(prefix, '/');
        return normalizedPrefix + "/" + filename;
    }
}
