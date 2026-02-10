package org.apatrios.config.yookassa;

import feign.RequestTemplate;

/**
 * Интерфейс для конфигурации авторизации ЮКассы
 */
public interface AuthenticationConfigurer {

    /**
     * Применить авторизацию к запросу
     */
    void configure(RequestTemplate template);

    /**
     * Тип запроса
     */
    String getType();
}
