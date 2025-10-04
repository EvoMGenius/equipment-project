package org.apatrios.action.management.user.password;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.service.management.user.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ResetPasswordAction {

    private final UserService userService;
    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String from;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void execute(@NonNull String username) {
        UUID code = userService.createResetCode(username);

        String emailTemplate = loadTemplate();
        String htmlContent = String.format(emailTemplate, code);

        sendEmail(username, "Ваш код для сброса пароля", htmlContent);
    }

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

    private String loadTemplate() {
        try {
            ClassPathResource resource = new ClassPathResource("templates/reset-password-email.html");
            InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new EntityNotFoundException("Ошибка при отправке email");
        }
    }
}
