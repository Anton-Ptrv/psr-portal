package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.VolunteerConverter;
import com.rined.psr.portal.dto.brief.VolunteerBrief;
import com.rined.psr.portal.dto.fully.VolunteerDto;
import com.rined.psr.portal.model.Volunteer;
import com.rined.psr.portal.repositories.VolunteerRepository;
import org.springframework.stereotype.Service;

@Service
public class VolunteerService extends BaseService<VolunteerDto, VolunteerBrief, Volunteer, Long,
        VolunteerRepository, VolunteerConverter> {

    public VolunteerService(VolunteerConverter converter, VolunteerRepository repository) {
        super(converter, repository);
    }

    public boolean isVolunteerExistsByPhone(String phone) {
        return repository.existsByPhone(phone);
    }

    public boolean isVolunteerExistsByTelegram(String login) {
        return repository.existsByTelegramLogin(login);
    }
}