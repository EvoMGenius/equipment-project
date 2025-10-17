package org.apatrios.api.services.claim.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.services.ClaimStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO претензии")
public class ClaimDto {

    @Schema(description = "ID претензии")
    UUID id;

    @Schema(description = "ID родительской аренды")
    UUID parentRentId;

    @Schema(description = "ID типа претензии")
    UUID claimTypeId;

    @Schema(description = "Дата и время начала претензии")
    LocalDateTime startDate;

    @Schema(description = "Дата решения")
    LocalDateTime endDate;

    @Schema(description = "Статус претензии")
    ClaimStatus status;

    @Schema(description = "Комментарий")
    String note;

    @Schema(description = "Дата и время создания")
    LocalDateTime createDate;

    @Schema(description = "Дата и время обновления")
    LocalDateTime updateDate;

    @Schema(description = "Признак удаления")
    boolean isDeleted;
}
