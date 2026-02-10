package org.apatrios.service.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.util.TemplateLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class SendNotificationService {

    private final JavaMailSender mailSender;
    private final TemplateLoader loader;
    @Value("${spring.mail.username}")
    private String from;

    /**
     * Отправляет код подтверждения учетной записи
     */
    public void sendAuthenticationCode(String email, String code) {
        String htmlContent = loader.loadTemplate("templates/authentication-code.html");
        String content = String.format(htmlContent, code);
        sendEmail(email, "Код для подтверждения учетной записи", content);
    }

    /**
     * Базовый метод для отправки email
     */
    private void sendEmail(String to, String subject, String htmlContent) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, StandardCharsets.UTF_8.name());

            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent, true);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new EntityNotFoundException("Ошибка при отправке email");
        }
    }
}
