package org.apatrios.api.management.user.profile.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apatrios.model.management.UserProfile;
import org.apatrios.model.management.UserStatus;
import org.apatrios.model.services.Photo;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Schema(description = "DTO профиля пользователя")
public record UserProfileDto(

        @Schema(description = "ID")
        UUID id,

        @Schema(description = "Профиль пользователя")
        UserProfile userProfile,

        @Schema(description = "Email пользователя")
        String email,

        @Schema(description = "Номер телефона пользователя")
        String phoneNumber,

        @Schema(description = "Дата и время создания записи")
        LocalDateTime createDate,

        @Schema(description = "Дата и время обновления записи")
        LocalDateTime updateDate,

        @Schema(description = "Признак удаления")
        Boolean isDeleted,

        @Schema(description = "Признак верификации пользователя")
        Boolean isVerified,

        @Schema(description = "Список ролей и прав пользователя")
        Set<String> authorities,

        @Schema(description = "Статус пользователя")
        UserStatus status,

        @Schema(description = "Аватар пользователя")
        Photo avatar
) {}