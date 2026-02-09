package org.apatrios.action.management.user.profile.avatar;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.management.User;
import org.apatrios.service.management.user.UserService;
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
    MinioFileService fileService;

    @Transactional
    public User execute(@NonNull UUID userId, @NonNull MultipartFile file) {
        User user = userService.getExisting(userId);

        if (StringUtils.hasText(user.getAvatarPath())) fileService.delete(user.getAvatarPath());

        String extension = fileService.getExtension(file.getOriginalFilename());
        String fileName = String.format("%s_%d.%s", user.getId(), System.currentTimeMillis(), extension);

        String path = fileService.upload(file, "avatars", fileName);
        return userService.setAvatarPath(userId, path);
    }
}
