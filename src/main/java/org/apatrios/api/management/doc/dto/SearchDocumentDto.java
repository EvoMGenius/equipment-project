package org.apatrios.api.management.doc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.DocumentStatus;
import org.apatrios.model.management.File;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для поиска документов")
public class SearchDocumentDto {

    @Schema(description = "Поиск по названию (частичное совпадение)")
    String name;

    @Schema(description = "Фильтр по типу документа")
    UUID docTypeId;

    @Schema(description = "Статус")
    DocumentStatus status;

    @Schema(description = "Метаданные файла (размер, mime-type)")
    File file;
}