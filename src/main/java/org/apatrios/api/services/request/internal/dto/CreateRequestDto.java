package org.apatrios.api.services.request.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.services.RequestProfile;

import javax.validation.constraints.NotNull;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для создания запроса на услугу")
public class CreateRequestDto {

    @NotNull
    @Schema(description = "Контактная информация клиента")
    RequestProfile requestProfile;

    @NotNull
    @Schema(description = "ID типа услуги", example = "111e8400-e29b-41d4-a716-446655440000")
    UUID serviceTypeId;

    @Schema(description = "ID модели велосипеда", example = "222e8400-e29b-41d4-a716-446655440000")
    UUID modelBikeId;

    @Schema(description = "Комментарий к запросу", example = "Срочный ремонт")
    String note;

    @NotNull
    @Schema(description = "ID клиента", example = "333e8400-e29b-41d4-a716-446655440000")
    UUID clientId;
}
