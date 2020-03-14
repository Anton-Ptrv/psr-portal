package com.rined.psr.portal.controller;

import com.rined.psr.portal.services.VolunteerStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VolunteerStatusController {
    private final VolunteerStatusService volunteerStatusService;

}
