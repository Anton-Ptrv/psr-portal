package com.rined.psr.portal.services;

import com.rined.psr.portal.model.dto.TelegramResponse;
import com.rined.psr.portal.model.dto.request.NotificationRequest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@SpringBootTest
@PropertySource("classpath:psr.properties")
class NotificationServiceImplTest {

    @Autowired
    private NotificationService service;

    @Test
    public void test() {
        NotificationRequest notificationRequest
                = new NotificationRequest(Collections.singletonList(1L), "TEST");
        List<TelegramResponse> notify = service.notify(notificationRequest);
        for (TelegramResponse telegramResponse : notify) {
            assertThat(telegramResponse.isOk());
        }
    }
}