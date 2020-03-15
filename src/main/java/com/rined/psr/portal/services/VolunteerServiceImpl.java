package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.FullyConverter;
import com.rined.psr.portal.dto.brief.VolunteerBriefDto;
import com.rined.psr.portal.dto.fully.VolunteerFullyDto;
import com.rined.psr.portal.exception.NotFoundException;
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
    private final FullyConverter<Volunteer, VolunteerFullyDto, VolunteerBriefDto> converter;

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
    public List<VolunteerFullyDto> getAllVolunteers() {
        log.trace("All volunteers call");
        List<Volunteer> volunteers = volunteerRepository.findAll();
        return converter.convertToFullyDto(volunteers);
    }

    @Override
    public void addVolunteer(VolunteerBriefDto volunteerBrief) {
        log.trace("New volunteer {}", volunteerBrief);
        Volunteer volunteer = converter.briefToBase(volunteerBrief);
        volunteerRepository.save(volunteer);
    }

    @Override
    public void deleteVolunteer(long id) {
        log.trace("Delete volunteer with id {}", id);
        boolean isVolunteerExists = volunteerRepository.existsById(id);
        if (!isVolunteerExists) {
            throw new NotFoundException("Volunteer with id '%d' not found!", id);
        }
        volunteerRepository.deleteById(id);
    }

    @Override
    public VolunteerFullyDto getVolunteerById(long id) {
        log.trace("Find volunteer by id {}", id);
        return volunteerRepository.findVolunteerById(id)
                .map(converter::convertToFullyDto)
                .orElseThrow(() -> new NotFoundException("Volunteer with id '%d' not found!", id));
    }

    @Override
    public void updateVolunteer(long id, VolunteerFullyDto volunteerDto) {
        log.trace("Update volunteer by id {}", id);
        Volunteer volunteer = volunteerRepository.findVolunteerById(id)
                .orElseThrow(() -> new NotFoundException("Volunteer with id '%d' not found!", id));
        volunteerRepository.save(converter.mergeDtoAndBase(volunteer, volunteerDto));
    }

    @Override
    public void addVolunteer(VolunteerFullyDto volunteerDto) {
        log.trace("New volunteer {}", volunteerDto);
        volunteerRepository.save(converter.fullyDtoToBase(volunteerDto));
    }
}
