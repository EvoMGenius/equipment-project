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
@Schema(description = "DTO для регистрации фото в системе")
public class CreatePhotoDto {
    @Schema(description = "Имя файла")
    String fileName;

    @Schema(description = "URL или путь к файлу в хранилище")
    String fileUrl;
}