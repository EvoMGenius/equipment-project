package org.apatrios.api.management.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Schema(description = "Данные для регистрации новой компании")
public record CreateCompanyDto(

        @Schema(description = "Название организации")
        @NotBlank
        String name,

        @Schema(description = "ИНН (10 или 12 цифр)")
        @NotBlank
        String inn,

        @Schema(description = "Юридический адрес")
        @NotBlank
        String address,

        @Schema(description = "Контактный телефон")
        @NotBlank
        String phone,

        @Schema(description = "Электронная почта")
        @NotBlank
        @Email
        String email
) {
}
