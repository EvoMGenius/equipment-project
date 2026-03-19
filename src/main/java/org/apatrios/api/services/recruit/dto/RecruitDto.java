package org.apatrios.api.services.recruit.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.services.RecruitStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "DTO с информацией о наборе (рекруте)")
public record RecruitDto(

        @Schema(description = "ID записи набора")
        UUID id,

        @Schema(description = "Название компании, в которую хочет устроиться пользователь")
        String recruitCompanyName,

        @Schema(description = "Дата и время создания заявки")
        LocalDateTime createDate,

        @Schema(description = "Текущий статус процесса найма")
        RecruitStatus status
) {}