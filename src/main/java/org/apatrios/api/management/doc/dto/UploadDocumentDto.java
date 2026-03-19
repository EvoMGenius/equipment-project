package org.apatrios.api.management.doc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NonNull;
import javax.validation.constraints.NotBlank;

import java.util.UUID;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public record UploadDocumentDto(
        @Schema(description = "Наименование", requiredMode = REQUIRED)
        @NotBlank
        String name,

        @NonNull
        @Schema(description = "Тип документа ID", requiredMode = REQUIRED)
        UUID docTypeId
) {}
