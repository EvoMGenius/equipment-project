package org.apatrios.api.services.recruit.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для создания записи о наборе")
public class CreateRecruitDto {

    @NotNull
    @Schema(description = "ID клиента", example = "222e8400-e29b-41d4-a716-446655440000", required = true)
    UUID clientId;
}
