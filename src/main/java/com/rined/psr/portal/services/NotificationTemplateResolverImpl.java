package com.rined.psr.portal.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rined.psr.portal.model.dto.request.NotificationRequest;
import com.rined.psr.portal.model.notifications.PreparedConsumeNotification;
import com.rined.psr.portal.properties.NotificationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class NotificationTemplateResolverImpl implements NotificationTemplateResolver {
    private final ObjectMapper objectMapper;
    private final NotificationProperties notificationData;

    @Override
    public PreparedConsumeNotification resolve(NotificationRequest notification) {
        Map<String, Object> params = new HashMap<>();

        params.put("botToken", notificationData.getToken());
        params.put("text", notification.getMessage());

        jsonOptional(notification.getReplyMarkup())
                .ifPresent((markup) -> params.put("markup", format(notificationData.getMarkupTemplate(), markup)));

        String template = notification.getReplyMarkup() == null
                ? notificationData.getUrlTemplate()
                : notificationData.getUrlTemplateMarkup();

        return new PreparedConsumeNotification(template, (chatId) -> params.put("chatId", chatId), params);
    }

    private Optional<String> jsonOptional(Object obj) {
        try {
            return obj == null ? Optional.empty() : Optional.of(objectMapper.writeValueAsString(obj));
        } catch (JsonProcessingException ignored) {
            return Optional.empty();
        }
    }
}
