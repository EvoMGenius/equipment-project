package org.apatrios.service.storage;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * Сервис для работы с объектным хранилищем MinIO.
 */
@Service
@RequiredArgsConstructor
public class MinioFileService {

    private final MinioClient minioClient;

    @Value("${minio.bucket-name}")
    String bucketName;

    @Value("${minio.public-url}")
    String publicUrl;

    /**
     * Загружает файл в хранилище.
     * * @param file Объект файла из HTTP-запроса.
     * @param folder   Папка внутри бакета (например, 'avatars' или 'contracts').
     * @param fileName Имя, под которым файл будет сохранен.
     * @return Полный путь к объекту внутри бакета (objectName).
     * @throws EntityNotFoundException если не удалось загрузить поток данных в MinIO.
     */
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

    /**
     * Получает поток данных (InputStream) файла по указанному пути.
     * Используется для скачивания файлов.
     * * @param path Путь к файлу в бакете.
     * @return InputStream содержимого файла.
     */
    public InputStream getStream(String path) {
        try {
            return minioClient.getObject(GetObjectArgs.builder()
                                                      .bucket(bucketName)
                                                      .object(path)
                                                      .build());
        } catch (Exception e) {
            throw new EntityNotFoundException("MinIo.download.error");
        }
    }

    /**
     * Удаляет файл из хранилища.
     * * @param path Путь к удаляемому файлу.
     */
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

    /**
     * Формирует абсолютную ссылку на файл для использования на фронтенде.
     * * @param path Путь к файлу внутри бакета.
     * @return Строка вида 'http://storage.url/bucket/folder/file.jpg'.
     */
    public String getFullUrl(String path) {
        if (!StringUtils.hasText(path)) return null;
        return String.format("%s/%s/%s", publicUrl, bucketName, path);
    }

    /**
     * Вспомогательный метод для извлечения расширения файла (например, 'jpg' или 'pdf').
     * * @param fileName Имя файла.
     * @return Расширение файла без точки.
     */
    public String getExtension(String fileName) {
        return StringUtils.getFilenameExtension(fileName);
    }
}
