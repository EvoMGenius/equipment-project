package org.apatrios.api.services.photo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO поиска фото")
public class SearchPhotoDto {
    @Schema(description = "Поиск по имени файла")
    String fileName;

    @Schema(description = "Публичная ссылка на файл")
    String fileUrl;
}