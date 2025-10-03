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
@Schema(description = "DTO для создания клиента")
public class CreateClientDto {

    @NotNull
    @Schema(description = "Контактная информация клиента")
    ClientProfile clientProfile;

    @NotNull
    @Schema(description = "ID Компании (франчайзи)")
    UUID franchiseeId;
}
