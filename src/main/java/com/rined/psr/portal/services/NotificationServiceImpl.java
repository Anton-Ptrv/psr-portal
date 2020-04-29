package com.rined.psr.portal.services;

import com.rined.psr.portal.model.Volunteer;
import com.rined.psr.portal.model.dto.request.NotificationRequest;
import com.rined.psr.portal.repositories.VolunteerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private static final String QUERY_TEMPLATE = "https://api.telegram.org/botToken/sendMessage?chat_id=[telegram_chat]&text=[text]";

    private final VolunteerRepository repository;
    private final RestTemplate restTemplate;

    @Override
    public void notify(NotificationRequest notification) {
        List<Long> ids = notification.getIds();
        List<Volunteer> volunteersByIdIn = repository.findVolunteersByIdIn(ids);
    }
}
