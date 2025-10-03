package org.apatrios.api.management.franchisee.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.FranchiseeProfile;
import org.apatrios.model.management.FranchiseeStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для обновления данных франчайзи")
public class UpdateFranchiseeDto {

    @NotNull
    @Schema(description = "Уникальный идентификатор")
    UUID id;

    @NotBlank
    @Schema(description = "Идентификационный номер налогоплательщика", example = "7701234567", required = true)
    String inn;

    @NotNull
    @Schema(description = "Контактная информация франчайзи", required = true)
    FranchiseeProfile franchiseeProfile;

    @Schema(description = "Статус франчайзи", example = "ACTIVE", required = true)
    FranchiseeStatus status;
}
