package org.apatrios.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Component
public class FileUrlSerializer extends JsonSerializer<String> {

    private static String bucketName;
    private static String minioPublicUrl;

    @Value("${minio.bucket-name}")
    public void setBucketName(String bucketName) {FileUrlSerializer.bucketName = bucketName;}

    @Value("${minio.public-url}")
    public void setMinioPublicUrl(String minioPublicUrl) {FileUrlSerializer.minioPublicUrl = minioPublicUrl;}

    public String getFullUrl(String path) {
        return String.format("%s/%s/%s", minioPublicUrl, bucketName, path);
    }

    public String getExtension(String fileName) {
        return StringUtils.getFilenameExtension(fileName);
    }

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String fullUrl = getFullUrl(value);
        if (fullUrl != null) gen.writeString(fullUrl);
        else gen.writeNull();
    }
}
