package org.apatrios.api.services.contract.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.equipment.status.dto.StatusDto;
import org.apatrios.api.management.doc.dto.DocumentDto;
import org.apatrios.api.services.recruit.dto.RecruitDto;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO контракта")
public class ContractDto {
    UUID id;

    @Schema(description = "Информация о рекрутинговой кампании")
    RecruitDto recruit;

    @Schema(description = "Метаданные документа контракта")
    DocumentDto doc;

    @Schema(description = "Статус контракта (Подписан, На согласовании)")
    StatusDto status;
}