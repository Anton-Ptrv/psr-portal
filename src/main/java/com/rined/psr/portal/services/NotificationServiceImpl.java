package com.rined.psr.portal.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rined.psr.portal.exception.NotFoundException;
import com.rined.psr.portal.model.Volunteer;
import com.rined.psr.portal.model.dto.TelegramResponse;
import com.rined.psr.portal.model.dto.request.NotificationRequest;
import com.rined.psr.portal.properties.NotificationProperties;
import com.rined.psr.portal.repositories.VolunteerRepository;
import com.rined.psr.portal.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;
    private final VolunteerRepository repository;
    private final NotificationProperties notificationProperties;

    @Override
    public List<TelegramResponse> notify(NotificationRequest notification) {
        List<TelegramResponse> result = new ArrayList<>();

        List<Long> ids = notification.getIds();
        String message = notification.getMessage();
        String replyMarkup = null;
        try {
            if (Objects.nonNull(notification.getReplyMarkup()))
                replyMarkup = objectMapper.writeValueAsString(notification.getReplyMarkup());
        } catch (JsonProcessingException ignored) {
        }

        String template = Objects.isNull(replyMarkup)
                ? notificationProperties.getUrlTemplate()
                : notificationProperties.getUrlTemplateMarkup();


        List<Volunteer> volunteersForNotify = repository.findVolunteersByIdIn(ids)
                .stream()
                .filter(volunteer -> Objects.nonNull(volunteer.getChatId()))
                .collect(Collectors.toList());

        if (!Utils.compareSize(ids, volunteersForNotify)) {
            throw new NotFoundException("Not all volunteers were found!");
        }

        for (Volunteer volunteer : volunteersForNotify) {
            String url = formatRequest(template, notificationProperties.getToken(),
                    volunteer.getChatId(), message, replyMarkup);
            log.info("URL FOR TELEGRAM API: {}", url);
            result.add(restTemplate.getForObject(url, TelegramResponse.class));
        }
        return result;
    }

    private String formatRequest(String template, Object... args) {
        return String.format(template, args);
    }
}
