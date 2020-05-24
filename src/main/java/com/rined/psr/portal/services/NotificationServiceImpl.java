package com.rined.psr.portal.services;

import com.rined.psr.portal.exception.NotFoundException;
import com.rined.psr.portal.model.dto.TelegramResponse;
import com.rined.psr.portal.model.dto.request.NotificationRequest;
import com.rined.psr.portal.model.notifications.PreparedConsumeNotification;
import com.rined.psr.portal.repositories.VolunteerRepository;
import com.rined.psr.portal.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final RestTemplate restTemplate;
    private final VolunteerRepository repository;
    private final NotificationTemplateResolver notificationTemplateResolver;

    @Override
    public List<TelegramResponse> notify(NotificationRequest notificationRequest) {
        List<Long> ids = notificationRequest.getIds();

        List<Long> chatIds = repository.findVolunteersChatIdsByIdIn(ids)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if (!Utils.isSameSize(ids, chatIds)) {
            throw new NotFoundException("Not all volunteers were found!");
        }

        PreparedConsumeNotification preparedConsumeNotification = notificationTemplateResolver.resolve(notificationRequest);

        return chatIds.stream()
                .map(chatId -> restTemplate.getForObject(
                        preparedConsumeNotification.getUrl(),
                        TelegramResponse.class,
                        preparedConsumeNotification.prepareAndBuild(chatId)
                )).collect(Collectors.toList());
    }
}
