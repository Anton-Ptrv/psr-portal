package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.FullyConverter;
import com.rined.psr.portal.dto.request.brief.VolunteerBrief;
import com.rined.psr.portal.dto.response.fully.VolunteerFullyResponse;
import com.rined.psr.portal.model.Volunteer;
import com.rined.psr.portal.repositories.VolunteerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class VolunteerServiceImpl implements VolunteerService {
    private final VolunteerRepository volunteerRepository;
    private final FullyConverter<Volunteer, VolunteerFullyResponse, VolunteerBrief> converter;

    @Override
    public boolean isVolunteerExistsByPhone(String phone) {
        log.trace("Check is volunteer exists with phone {}", phone);
        boolean existsResult = volunteerRepository.existsByPhone(phone);
        log.trace("Volunteer with phone '{}' check exists result is '{}'", phone, existsResult);
        return existsResult;
    }

    @Override
    public boolean isVolunteerExistsByTelegram(String login) {
        log.trace("Check is volunteer exists with login {}", login);
        boolean existsResult = volunteerRepository.existsByTelegramLogin(login);
        log.trace("Volunteer with login '{}' check exists result is '{}'", login, existsResult);
        return existsResult;
    }

    @Override
    public List<VolunteerFullyResponse> getAllVolunteers() {
        log.trace("All volunteers call");
        List<Volunteer> volunteers = volunteerRepository.findAll();
        return converter.convertToFullyDto(volunteers);
    }

    @Override
    public void addVolunteer(VolunteerBrief volunteerBrief) {
        log.trace("New volunteer {}", volunteerBrief);
        Volunteer volunteer = converter.briefToBase(volunteerBrief);
        volunteerRepository.save(volunteer);
    }
}
