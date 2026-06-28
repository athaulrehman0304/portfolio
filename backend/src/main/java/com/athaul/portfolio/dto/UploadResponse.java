package com.athaul.portfolio.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Response returned after a successful file upload.
 */
@Schema(description = "Result of an image upload")
public record UploadResponse(

        @Schema(description = "Public URL where the uploaded image can be accessed", example = "/uploads/2c1f....png")
        String url,

        @Schema(description = "Generated, collision-free filename", example = "2c1f....png")
        String filename
) {
}
