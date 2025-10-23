package org.apatrios.api.authentication.internal;

import com.github.database.rider.core.api.dataset.DataSet;
import com.jupiter.tools.spring.test.postgres.annotation.meta.EnablePostgresIntegrationTest;
import org.apatrios.api.authentication.internal.dto.CompleteAuthenticationCodeDto;
import org.apatrios.api.authentication.internal.dto.CreateAuthenticationCodeDto;
import org.apatrios.service.notification.SendNotificationService;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@EnablePostgresIntegrationTest
@ExtendWith(SoftAssertionsExtension.class)
class AuthenticationCodeControllerIT {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private SendNotificationService notificationService;

    @Test
    @DataSet(value = "datasets/api/authentication/internal/authentication_code.json", cleanBefore = true, cleanAfter = true)
    void authenticationCode(SoftAssertions assertions) {
        // Arrange #1
        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);

        // Act #1
        webTestClient.post()
                     .uri(uriBuilder -> uriBuilder.path("/code/init")
                                                  .queryParam("scope", "web")
                                                  .queryParam("client_id", "web")
                                                  .queryParam("client_secret", "client_secret")
                                                  .build())
                     .bodyValue(CreateAuthenticationCodeDto.builder()
                                                           .username("username")
                                                           .password("password")
                                                           .build())
                     .exchange()
                     .expectStatus()
                     .isOk();

        // Assert #1
        ArgumentCaptor<UUID> codeCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(notificationService, times(1)).sendAuthenticationCode(eq("username"), codeCaptor.capture());

        // Act #2
        OAuth2AccessToken token = webTestClient.post()
                                               .uri(uriBuilder -> uriBuilder.path("/code/complete")
                                                                            .queryParam("scope", "web")
                                                                            .queryParam("client_id", "web")
                                                                            .queryParam("client_secret", "client_secret")
                                                                            .build())
                                               .bodyValue(CompleteAuthenticationCodeDto.builder()
                                                                                       .code(codeCaptor.getValue())
                                                                                       .build())
                                               .exchange()
                                               .expectStatus()
                                               .isOk()
                                               .expectBody(OAuth2AccessToken.class)
                                               .returnResult()
                                               .getResponseBody();
        // Assert #2
        assertions.assertThat(token)
                  .extracting(OAuth2AccessToken::getValue)
                  .isNotNull();
    }
}
