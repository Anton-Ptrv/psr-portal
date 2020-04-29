package com.rined.psr.portal.services;

import com.rined.psr.portal.model.Volunteer;
import com.rined.psr.portal.model.dto.TelegramResponse;
import com.rined.psr.portal.model.dto.request.NotificationRequest;
import com.rined.psr.portal.properties.NotificationProperties;
import com.rined.psr.portal.repositories.VolunteerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationProperties notificationProperties;
    private final VolunteerRepository repository;
    private final RestTemplate restTemplate;

    @Override
    public List<TelegramResponse> notify(NotificationRequest notification) {
        List<TelegramResponse> result = new ArrayList<>();
        String notificationMessage = notification.getMessage();

        List<Volunteer> volunteersForNotify = repository.findVolunteersByIdIn(notification.getIds());
        for (Volunteer volunteer : volunteersForNotify) {
            String url = formatRequest(volunteer, notificationMessage);
            result.add(restTemplate.postForObject(url, null, TelegramResponse.class));
        }
        return result;
    }

    private String formatRequest(Volunteer volunteer, String message) {
        return String.format(
                notificationProperties.getUrlTemplate(),
                notificationProperties.getToken(),
                volunteer.getChatId(),
                message
        );
    }
}
