package org.apatrios.api.services.rent_compose.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для создания состава аренды")
public class CreateRentComposeDto {

    @NotNull
    @Schema(description = "ID аренды", example = "111e8400-e29b-41d4-a716-446655440000")
    UUID rentId;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @NotNull
    @Schema(description = "Количество объектов в аренде", example = "2")
    Integer amount;

    @NotNull
    @Schema(description = "ID велосипеда, экипировки или запчасти", example = "222e8400-e29b-41d4-a716-446655440000")
    UUID objectId;
}
