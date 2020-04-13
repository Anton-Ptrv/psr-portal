package com.rined.psr.portal.services;

import com.rined.psr.portal.model.converters.VolunteerStatusConverter;
import com.rined.psr.portal.model.dto.brief.VolunteerStatusBrief;
import com.rined.psr.portal.model.dto.fully.VolunteerStatusDto;
import com.rined.psr.portal.model.VolunteerStatus;
import com.rined.psr.portal.repositories.VolunteerStatusRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class VolunteerStatusService extends BaseService<VolunteerStatusDto, VolunteerStatusBrief, VolunteerStatus,
        Long, VolunteerStatusRepository, VolunteerStatusConverter> {

    public VolunteerStatusService(VolunteerStatusConverter converter, VolunteerStatusRepository repository) {
        super(converter, repository);
    }

    @Override
    public VolunteerStatus cascadeSave(VolunteerStatus volunteerStatus) {
        if (Objects.nonNull(volunteerStatus) && Objects.isNull(volunteerStatus.getId()))
            return repository.save(volunteerStatus);
        return volunteerStatus;
    }
}
