package com.rined.psr.portal.controller;

import com.rined.psr.portal.services.VolunteerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VolunteerController {
    private final VolunteerService volunteerService;

}
