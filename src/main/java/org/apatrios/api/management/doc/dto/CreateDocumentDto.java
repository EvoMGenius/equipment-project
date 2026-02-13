package org.apatrios.api.management.doc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для создания новой записи о документе")
public class CreateDocumentDto {

    @Schema(description = "Название документа", requiredMode = Schema.RequiredMode.REQUIRED)
    String name;

    @Schema(description = "ID типа документа из справочника Dict")
    UUID docTypeId;

    @Schema(description = "ID начального статуса")
    UUID statusId;
}