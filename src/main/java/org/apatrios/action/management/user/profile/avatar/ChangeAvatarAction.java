package org.apatrios.action.management.user.profile.avatar;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.config.properties.DocumentProperties;
import org.apatrios.model.management.User;
import org.apatrios.model.services.Photo;
import org.apatrios.service.management.user.UserService;
import org.apatrios.service.management.user.argument.UpdateUserArgument;
import org.apatrios.service.services.photo.PhotoService;
import org.apatrios.service.storage.MinioFileService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ChangeAvatarAction {

    UserService userService;
    DocumentProperties documentProperties;
    MinioFileService fileService;

    @Transactional
    public User execute(@NonNull UUID userId, @NonNull MultipartFile file) {
        User user = userService.getExisting(userId);

        if (StringUtils.hasText(user.getAvatar().getFileUrl())) fileService.delete(user.getAvatar().getFileUrl());

        String extension = fileService.getExtension(file.getOriginalFilename());
        String fileName = String.format("%s_%d.%s", user.getId(), System.currentTimeMillis(), extension);
        String folder = documentProperties.getAvatarFolder();

        String path = fileService.upload(file, folder, fileName);
        return userService.update(userId, UpdateUserArgument.builder()
                                                            .avatar(Photo.builder()
                                                                         .fileName(fileName)
                                                                         .fileUrl(path)
                                                                         .build())
                                                            .build());
    }
}
