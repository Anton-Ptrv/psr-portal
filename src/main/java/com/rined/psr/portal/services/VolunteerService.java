package com.rined.psr.portal.services;

import com.rined.psr.portal.dto.brief.VolunteerBrief;
import com.rined.psr.portal.dto.fully.VolunteerDto;

import java.util.List;

public interface VolunteerService {

    boolean isVolunteerExistsByPhone(String phone);

    boolean isVolunteerExistsByTelegram(String login);

    List<VolunteerDto> getAllVolunteers();

    void addVolunteer(VolunteerBrief volunteerBrief);

    void deleteVolunteer(long id);

    VolunteerDto getVolunteerById(long id);

    void updateVolunteer(long id, VolunteerDto volunteer);

    void addVolunteer(VolunteerDto volunteer);
}
