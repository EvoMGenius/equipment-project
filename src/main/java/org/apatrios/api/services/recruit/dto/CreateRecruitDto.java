package org.apatrios.api.services.recruit.dto;

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
@Schema(description = "DTO для создания новой заявки на набор")
public class CreateRecruitDto {

    @Schema(description = "Название компании", requiredMode = Schema.RequiredMode.REQUIRED)
    String recruitCompanyName;

    @Schema(description = "ID начального статуса набора")
    UUID statusId;
}