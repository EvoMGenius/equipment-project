package org.apatrios.api.services.recruit.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.services.RecruitStatus;

import java.time.LocalDateTime;

@Schema(description = "DTO для поиска и фильтрации заявок набора")
public record SearchRecruitDto(

        @Schema(description = "Поиск по названию компании (частичное совпадение)")
        String recruitCompanyName,

        @Schema(description = "Текущий статус процесса найма")
        RecruitStatus status,

        @Schema(description = "Фильтр по дате создания (С)")
        LocalDateTime createDateFrom,

        @Schema(description = "Фильтр по дате создания (ПО)")
        LocalDateTime createDateTo
) {}