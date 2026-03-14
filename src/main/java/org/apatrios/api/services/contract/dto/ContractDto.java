package org.apatrios.api.services.contract.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.api.management.doc.dto.DocumentDto;
import org.apatrios.api.services.recruit.dto.RecruitDto;
import org.apatrios.model.services.ContactStatus;

import java.util.UUID;

@Schema(description = "DTO контракта")
public record ContractDto(
        UUID id,

        @Schema(description = "Информация о рекрутинговой кампании")
        RecruitDto recruit,

        @Schema(description = "Метаданные документа контракта")
        DocumentDto doc,

        @Schema(description = "Статус контракта (Подписан, На согласовании)")
        ContactStatus status
) {}