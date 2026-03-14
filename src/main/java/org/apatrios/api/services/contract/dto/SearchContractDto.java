package org.apatrios.api.services.contract.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.services.ContactStatus;

import java.util.UUID;

@Schema(description = "DTO поиска контрактов")
public record SearchContractDto(
        @Schema(description = "Фильтр по рекруту")
        UUID recruitId,

        @Schema(description = "Статус контракта (Подписан, На согласовании)")
        ContactStatus status
) {}