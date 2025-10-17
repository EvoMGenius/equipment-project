package org.apatrios.util;

import org.apatrios.exception.EntityNotFoundException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Component
public class TemplateLoader {

    /**
     * Загружает шаблон из resources по указанному пути
     *
     * @param templatePath путь к шаблону относительно resources (например, "templates/email.html")
     * @return содержимое шаблона
     * @throws EntityNotFoundException если шаблон не найден или произошла ошибка чтения
     */
    public String loadTemplate(String templatePath) {
        try {
            ClassPathResource resource = new ClassPathResource(templatePath);
            InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new EntityNotFoundException("Не удалось загрузить шаблон: " + templatePath);
        }
    }
}