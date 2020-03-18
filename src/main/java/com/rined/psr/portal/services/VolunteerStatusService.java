package com.rined.psr.portal.services;

import com.rined.psr.portal.dto.brief.VolunteerStatusBrief;
import com.rined.psr.portal.dto.fully.VolunteerStatusDto;

import java.util.List;

public interface VolunteerStatusService {

    void addVolunteerStatus(VolunteerStatusBrief volunteerStatus);

    List<VolunteerStatusDto> getAllVolunteerStatuses();

    void updateVolunteerStatus(long id, VolunteerStatusDto dto);

    VolunteerStatusDto getVolunteerStatusById(long id);

    void deleteVolunteerStatusById(long id);

}
