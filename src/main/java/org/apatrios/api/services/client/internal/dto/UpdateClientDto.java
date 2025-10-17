package org.apatrios.api.services.client.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.services.ClientProfile;

import javax.validation.constraints.NotNull;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для обновления клиента")
public class UpdateClientDto {

    @NotNull
    @Schema(description = "Идентификатор клиента", example = "550e8400-e29b-41d4-a716-446655440000")
    UUID id;

    @NotNull
    @Schema(description = "Контактная информация клиента")
    ClientProfile clientProfile;

    @NotNull
    @Schema(description = "ID Компании (франчайзи)")
    UUID franchiseeId;
}
