package com.rined.psr.portal.services;

import com.rined.psr.portal.dto.request.brief.VolunteerBrief;
import com.rined.psr.portal.dto.response.fully.VolunteerFullyResponse;

import java.util.List;

public interface VolunteerService {

    boolean isVolunteerExistsByPhone(String phone);

    boolean isVolunteerExistsByTelegram(String login);

    List<VolunteerFullyResponse> getAllVolunteers();

    void addVolunteer(VolunteerBrief volunteerBrief);
}
