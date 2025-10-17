package org.apatrios.api.services.rent_compose.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для обновления состава аренды")
public class UpdateRentComposeDto {

    @NotNull
    @Schema(description = "Уникальный идентификатор", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID id;

    @NotNull
    @Schema(description = "Количество объектов в аренде", example = "5")
    Integer amount;

    @NotNull
    @Schema(description = "ID велосипеда, экипировки или запчасти", example = "333e8400-e29b-41d4-a716-446655440000")
    UUID objectId;

    @NotNull
    @Schema(description = "ID аренды", example = "111e8400-e29b-41d4-a716-446655440000")
    UUID rentId;
}
