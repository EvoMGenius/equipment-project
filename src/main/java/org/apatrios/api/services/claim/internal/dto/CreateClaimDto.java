package org.apatrios.api.services.claim.internal.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Schema(description = "DTO для создания претензии")
public class CreateClaimDto {

    @NotNull
    @Schema(description = "ID родительской аренды", requiredMode = Schema.RequiredMode.REQUIRED)
    UUID parentRentId;

    @Schema(description = "ids франчайзи")
    Set<UUID> franchiseeIds;

    @NotNull
    @Schema(description = "ID типа претензии", requiredMode = Schema.RequiredMode.REQUIRED)
    UUID claimTypeId;

    @Schema(description = "Комментарий")
    String note;
}
