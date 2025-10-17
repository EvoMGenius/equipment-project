package org.apatrios.api.services.rent_compose.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.services.rent.internal.dto.RentDto;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO состава аренды")
public class RentComposeDto {

    @Schema(description = "Уникальный идентификатор", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID id;

    @Schema(description = "Аренда")
    RentDto rent;

    @Schema(description = "Количество объектов в аренде", example = "3")
    Integer amount;

    @Schema(description = "ID велосипеда, экипировки или запчасти", example = "222e8400-e29b-41d4-a716-446655440000")
    UUID objectId;

    @Schema(description = "Дата создания записи", example = "2025-10-01T10:00:00")
    LocalDateTime createDate;

    @Schema(description = "Дата обновления записи", example = "2025-10-02T15:30:00")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления", example = "false")
    boolean isDeleted;
}
