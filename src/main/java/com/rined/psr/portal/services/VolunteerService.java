package com.rined.psr.portal.services;

import com.rined.psr.portal.dto.brief.VolunteerBriefDto;
import com.rined.psr.portal.dto.fully.VolunteerFullyDto;

import java.util.List;

public interface VolunteerService {

    boolean isVolunteerExistsByPhone(String phone);

    boolean isVolunteerExistsByTelegram(String login);

    List<VolunteerFullyDto> getAllVolunteers();

    void addVolunteer(VolunteerBriefDto volunteerBrief);

    void deleteVolunteer(long id);

    VolunteerFullyDto getVolunteerById(long id);

    void updateVolunteer(long id, VolunteerFullyDto volunteer);

    void addVolunteer(VolunteerFullyDto volunteer);
}
