package org.apatrios.api.services.recruit.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.services.RecruitStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO с информацией о наборе (рекруте)")
public class RecruitDto {

    @Schema(description = "ID записи набора")
    UUID id;

    @Schema(description = "Название компании, в которую хочет устроиться пользователь", example = "ООО 'Яндекс'")
    String recruitCompanyName;

    @Schema(description = "Дата и время создания заявки")
    LocalDateTime createDate;

    @Schema(description = "Текущий статус процесса найма")
    RecruitStatus status;
}