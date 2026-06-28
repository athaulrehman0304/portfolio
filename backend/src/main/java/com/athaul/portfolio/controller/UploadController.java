package com.athaul.portfolio.controller;

import com.athaul.portfolio.dto.UploadResponse;
import com.athaul.portfolio.service.FileStorageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Administrative endpoint for uploading project images. Protected by the
 * {@code /api/v1/admin/**} security rule (ADMIN only).
 */
@RestController
@RequestMapping("/api/v1/admin/uploads")
@Tag(name = "Uploads", description = "Administrator image uploads")
@SecurityRequirement(name = "bearerAuth")
public class UploadController {

    private final FileStorageService fileStorageService;

    public UploadController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @Operation(
            summary = "Upload an image",
            description = "Accepts a single image file (JPEG, PNG, GIF or WebP) up to 5 MB and returns its public URL.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "File stored successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid or oversized file", content = @io.swagger.v3.oas.annotations.media.Content),
            @ApiResponse(responseCode = "401", description = "Authentication required", content = @io.swagger.v3.oas.annotations.media.Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @io.swagger.v3.oas.annotations.media.Content)
    })
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<UploadResponse> upload(@RequestParam("file") MultipartFile file) {
        FileStorageService.StoredFile stored = fileStorageService.store(file);
        return ResponseEntity
                .status(201)
                .body(new UploadResponse(stored.url(), stored.filename()));
    }
}
