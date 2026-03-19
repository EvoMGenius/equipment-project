package org.apatrios.api.services.recruit.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

@Schema(description = "DTO для создания новой заявки на набор")
public record CreateRecruitDto(

        @NotNull
        @Schema(description = "Название компании", requiredMode = Schema.RequiredMode.REQUIRED)
        String recruitCompanyName
) {}