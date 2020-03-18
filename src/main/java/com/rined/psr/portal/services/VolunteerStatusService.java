package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.VolunteerStatusConverter;
import com.rined.psr.portal.dto.brief.VolunteerStatusBrief;
import com.rined.psr.portal.dto.fully.VolunteerStatusDto;
import com.rined.psr.portal.model.VolunteerStatus;
import com.rined.psr.portal.repositories.VolunteerStatusRepository;
import org.springframework.stereotype.Service;

@Service
public class VolunteerStatusService extends BaseService<VolunteerStatusDto, VolunteerStatusBrief, VolunteerStatus,
        Long, VolunteerStatusRepository, VolunteerStatusConverter> {

    public VolunteerStatusService(VolunteerStatusConverter converter, VolunteerStatusRepository repository) {
        super(converter, repository);
    }

}
