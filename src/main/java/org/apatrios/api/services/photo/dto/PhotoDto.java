package org.apatrios.api.services.photo.dto;

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
@Schema(description = "DTO фотографии")
public class PhotoDto {
    @Schema(description = "ID фотографии")
    UUID id;

    @Schema(description = "Имя файла", example = "damage_001.jpg")
    String fileName;

    @Schema(description = "Публичная ссылка на файл")
    String fileUrl;
}