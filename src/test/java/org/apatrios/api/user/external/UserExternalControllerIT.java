package org.apatrios.api.user.external;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.jupiter.tools.spring.test.postgres.annotation.meta.EnablePostgresIntegrationTest;
import org.apatrios.api.management.user.external.dto.CreateUserExternalDto;
import org.apatrios.api.management.user.external.dto.ResetPasswordByCodeExternalDto;
import org.apatrios.api.management.user.external.dto.UpdatePasswordByCodeExternalDto;
import org.apatrios.model.management.UserProfile;
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
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@EnablePostgresIntegrationTest
@ExtendWith(SoftAssertionsExtension.class)
class UserExternalControllerIT {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private SendNotificationService notificationService;

    @Test
    @DataSet(value = "datasets/api/user/external/login.json", cleanBefore = true, cleanAfter = true)
    @ExpectedDataSet(value = "datasets/api/user/external/login__expected.json")
    void login(SoftAssertions assertions) {
        // Arrange
        CreateUserExternalDto createBody = CreateUserExternalDto.builder()
                                                                .username("username")
                                                                .password("password")
                                                                .userProfile(UserProfile.builder()
                                                                                        .firstName("first-name")
                                                                                        .middleName("middle-name")
                                                                                        .lastName("last-name")
                                                                                        .build())
                                                                .build();

        // Act
        OAuth2AccessToken response = webTestClient.post()
                                                  .uri(uriBuilder -> uriBuilder.path("external/user/login")
                                                                               .queryParam("scope", "web")
                                                                               .queryParam("client_id", "web")
                                                                               .queryParam("client_secret", "client_secret")
                                                                               .build())
                                                  .bodyValue(createBody)
                                                  .exchange()
                                                  .expectStatus()
                                                  .isOk()
                                                  .expectBody(OAuth2AccessToken.class)
                                                  .returnResult()
                                                  .getResponseBody();

        // Assert
        assertions.assertThat(response)
                  .extracting(OAuth2AccessToken::getValue)
                  .isNotNull();
    }

    @Test
    @DataSet(value = "datasets/api/user/external/update_password_by_code.json", cleanBefore = true, cleanAfter = true)
    @ExpectedDataSet(value = "datasets/api/user/external/update_password_by_code__expected.json")
    void changePassword(SoftAssertions assertions) {
        // Arrange #1
        ResetPasswordByCodeExternalDto resetBody = ResetPasswordByCodeExternalDto.builder()
                                                                                 .username("username")
                                                                                 .build();

        // Act #1
        webTestClient.post()
                     .uri(uriBuilder -> uriBuilder.path("external/user/reset-password-by-code")
                                                  .queryParam("scope", "web")
                                                  .queryParam("client_id", "web")
                                                  .queryParam("client_secret", "client_secret")
                                                  .build())
                     .bodyValue(resetBody)
                     .exchange()
                     .expectStatus()
                     .isOk();

        // Assert #1
        ArgumentCaptor<String> codeCaptor = ArgumentCaptor.forClass(String.class);
        verify(notificationService, times(1)).sendPasswordResetCode(eq("username"), codeCaptor.capture());

        String generatedCode = codeCaptor.getValue();
        assertions.assertThat(generatedCode)
                  .hasSize(6)
                  .matches("\\d{6}");

        // Arrange #2
        UpdatePasswordByCodeExternalDto updateBody = UpdatePasswordByCodeExternalDto.builder()
                                                                                    .code(generatedCode)
                                                                                    .password("new-password")
                                                                                    .build();

        // Act #2
        OAuth2AccessToken response = webTestClient.post()
                                                  .uri(uriBuilder -> uriBuilder.path("external/user/update-password-by-code")
                                                                               .queryParam("scope", "web")
                                                                               .queryParam("client_id", "web")
                                                                               .queryParam("client_secret", "client_secret")
                                                                               .build())
                                                  .bodyValue(updateBody)
                                                  .exchange()
                                                  .expectStatus()
                                                  .isOk()
                                                  .expectBody(OAuth2AccessToken.class)
                                                  .returnResult()
                                                  .getResponseBody();

        // Assert #2
        assertions.assertThat(response)
                  .extracting(OAuth2AccessToken::getValue)
                  .isNotNull();
    }
}
