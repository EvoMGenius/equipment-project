package org.apatrios.api.services.recruit.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для поиска и фильтрации заявок набора")
public class SearchRecruitDto {

    @Schema(description = "Поиск по названию компании (частичное совпадение)")
    String recruitCompanyName;

    @Schema(description = "Фильтр по статусу")
    UUID statusId;

    @Schema(description = "Фильтр по дате создания (С)")
    LocalDateTime createDateFrom;

    @Schema(description = "Фильтр по дате создания (ПО)")
    LocalDateTime createDateTo;
}