package org.apatrios.api.management.doc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.dict.dto.DictDto;
import org.apatrios.api.equipment.status.dto.StatusDto;
import org.apatrios.model.management.File;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO с полной информацией о документе")
public class DocumentDto {

    @Schema(description = "ID документа")
    UUID id;

    @Schema(description = "Название документа (с расширением)", example = "contract_123.pdf")
    String name;

    @Schema(description = "Тип документа (Договор, Справка и т.д.)")
    DictDto docType;

    @Schema(description = "Текущий статус документа")
    StatusDto status;

    @Schema(description = "Метаданные файла (размер, mime-type)")
    File file;
}