package org.apatrios.api.services.contract.dto;

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
@Schema(description = "DTO поиска контрактов")
public class SearchContractDto {
    @Schema(description = "Фильтр по рекруту")
    UUID recruitId;

    @Schema(description = "Фильтр по статусу")
    UUID statusId;
}