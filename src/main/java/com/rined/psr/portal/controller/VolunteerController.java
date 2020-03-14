package com.rined.psr.portal.controller;

import com.rined.psr.portal.dto.request.brief.VolunteerBrief;
import com.rined.psr.portal.dto.response.SimpleResponse;
import com.rined.psr.portal.dto.request.SimpleRequest;
import com.rined.psr.portal.dto.response.fully.VolunteerFullyResponse;
import com.rined.psr.portal.services.VolunteerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VolunteerController {
    private final VolunteerService volunteerService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/volunteers/exists/phone")
    public SimpleResponse<Boolean> isVolunteerExistsByPhone(@RequestBody SimpleRequest<String> phone) {
        return SimpleResponse.of(volunteerService.isVolunteerExistsByPhone(phone.getData()));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/volunteers/exists/telegram")
    public SimpleResponse<Boolean> isVolunteerExistsByTelegram(@RequestBody SimpleRequest<String> login) {
        return SimpleResponse.of(volunteerService.isVolunteerExistsByTelegram(login.getData()));
    }

    @GetMapping("/volunteers")
    public List<VolunteerFullyResponse> getAllFullyVolunteers() {
        return volunteerService.getAllVolunteers();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/volunteers")
    public void addVolunteer(@RequestBody VolunteerBrief volunteerBrief) {
        volunteerService.addVolunteer(volunteerBrief);
    }
}
