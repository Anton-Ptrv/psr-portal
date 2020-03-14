package com.rined.psr.portal.controller;

import com.rined.psr.portal.services.PsrListRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PsrListRegistrationController {
    private final PsrListRegistrationService psrListRegistrationService;

}
