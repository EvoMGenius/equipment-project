package org.apatrios.api.services.support.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.services.Photo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Schema(description = "DTO для создания обращения")
public record CreateSupportDto(
        @NotBlank
        @Schema(description = "тип обращения")
        String type,

        @NotBlank
        @Schema(description = "Текст обращения")
        String description,

        @NotNull
        @Schema(description = "Фотки")
        List<Photo> photos,

        @NotNull
        @Schema(description = "ID связанного ремонта")
        UUID childRepairId
) {}