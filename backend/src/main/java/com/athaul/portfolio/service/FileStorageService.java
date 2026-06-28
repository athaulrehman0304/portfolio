package com.athaul.portfolio.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Stores uploaded files and exposes their public access details.
 */
public interface FileStorageService {

    /**
     * Validates and stores an uploaded image.
     *
     * @param file the uploaded multipart file
     * @return the stored result (public URL and generated filename)
     * @throws com.athaul.portfolio.exception.InvalidFileException if validation fails
     */
    StoredFile store(MultipartFile file);

    /**
     * Result of a successful store operation.
     */
    record StoredFile(String url, String filename) {
    }
}
