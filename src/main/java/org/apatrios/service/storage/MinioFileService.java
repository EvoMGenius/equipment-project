package org.apatrios.service.storage;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class MinioFileService {

    private final MinioClient minioClient;

    @Value("${minio.bucket-name}")
    String bucketName;

    @Value("${minio.public-url}")
    String publicUrl;

    public String upload(MultipartFile file, String folder, String fileName) {
        String objectName = folder + "/" + fileName;

        try {
            minioClient.putObject(PutObjectArgs.builder()
                                               .bucket(bucketName)
                                               .object(objectName)
                                               .stream(file.getInputStream(), file.getSize(), -1)
                                               .contentType(file.getContentType())
                                               .build());
        } catch (Exception e) {
            throw new EntityNotFoundException("MinIo.upload.error");
        }

        return objectName;
    }

    public void delete(String path) {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder()
                                                     .bucket(bucketName)
                                                     .object(path)
                                                     .build());
        } catch (Exception e) {
            throw new EntityNotFoundException("MinIo.delete.error");
        }
    }

    public String getFullUrl(String path) {
        if (!StringUtils.hasText(path)) return null;
        return String.format("%s/%s/%s", publicUrl, bucketName, path);
    }

    public String getExtension(String fileName) {
        return StringUtils.getFilenameExtension(fileName);
    }
}
