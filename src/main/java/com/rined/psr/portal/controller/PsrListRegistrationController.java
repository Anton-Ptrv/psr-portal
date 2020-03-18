package com.rined.psr.portal.controller;

import com.rined.psr.portal.converters.PsrListRegistrationConverter;
import com.rined.psr.portal.dto.brief.PsrListRegistrationBrief;
import com.rined.psr.portal.dto.fully.PsrListRegistrationDto;
import com.rined.psr.portal.model.PsrListRegistration;
import com.rined.psr.portal.repositories.PsrListRegistrationRepository;
import com.rined.psr.portal.services.PsrListRegistrationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/psr-list-registration")
public class PsrListRegistrationController extends BaseController<PsrListRegistrationDto, PsrListRegistrationBrief,
        PsrListRegistration, Long, PsrListRegistrationRepository, PsrListRegistrationConverter,
        PsrListRegistrationService> {

    public PsrListRegistrationController(PsrListRegistrationService service) {
        super(service);
    }

}