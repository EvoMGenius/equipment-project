package org.apatrios.api.management.doc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.api.dictionary.doc_type.dto.DocTypeDto;
import org.apatrios.model.management.DocumentStatus;
import org.apatrios.model.management.File;

import java.util.UUID;

@Schema(description = "DTO с полной информацией о документе")
public record DocumentDto(
        @Schema(description = "ID документа")
        UUID id,

        @Schema(description = "Название документа (с расширением)", example = "contract_123.pdf")
        String name,

        @Schema(description = "Тип документа (Договор, Справка и т.д.)")
        DocTypeDto docType,

        @Schema(description = "Статус")
        DocumentStatus status,

        @Schema(description = "Метаданные файла")
        File file
) {}