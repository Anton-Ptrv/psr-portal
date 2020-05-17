package com.rined.psr.portal.services;

import com.rined.psr.portal.exception.NotFoundException;
import com.rined.psr.portal.model.Volunteer;
import com.rined.psr.portal.model.converters.VolunteerConverter;
import com.rined.psr.portal.model.dto.brief.VolunteerBrief;
import com.rined.psr.portal.model.dto.fully.VolunteerDto;
import com.rined.psr.portal.repositories.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class VolunteerService extends BaseService<VolunteerDto, VolunteerBrief, Volunteer, Long,
        VolunteerRepository, VolunteerConverter> {
    private final ClassificationService classificationService;

    @Autowired
    public VolunteerService(VolunteerConverter converter,
                            VolunteerRepository repository,
                            ClassificationService classificationService) {
        super(converter, repository);
        this.classificationService = classificationService;
    }

    public boolean isVolunteerExistsByPhone(String phone) {
        return repository.existsByPhone(phone);
    }

    public Long getVolunteerIdByLogin(String login) {
        return Optional.ofNullable(repository.getVolunteerIdByLogin(login))
                .orElseThrow(() -> new NotFoundException("Volunteer with login %s not found", login));
    }

    public boolean isVolunteerExistsByTelegram(String login) {
        return repository.existsByTelegramLogin(login);
    }

    @Override
    public Volunteer cascadeSave(Volunteer volunteer) {
        if (Objects.nonNull(volunteer) && Objects.isNull(volunteer.getId())) {
            classificationService.cascadeSave(volunteer.getClassification());
            return repository.save(volunteer);
        }
        return volunteer;
    }
}