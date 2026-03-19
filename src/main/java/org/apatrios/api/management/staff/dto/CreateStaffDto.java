package org.apatrios.api.management.staff.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.api.management.company.dto.CompanyDto;
import org.apatrios.model.management.StaffStatus;
import javax.validation.constraints.*;

@Schema(description = "Запрос на создание нового сотрудника")
public record CreateStaffDto(

        @Schema(description = "Фамилия", required = true)
        @NotBlank
        String surname,

        @Schema(description = "Имя", required = true)
        @NotBlank
        String name,

        @Schema(description = "Должность", required = true)
        @NotBlank
        String position,

        @Schema(description = "компания", required = true)
        @NotNull
        CompanyDto company,

        @Schema(description = "Телефон в формате +7/8...")
        String phone,

        @Schema(description = "Email")
        @Email
        String email,

        @Schema(description = "Начальный статус", required = true)
        @NotNull
        StaffStatus status
) {}