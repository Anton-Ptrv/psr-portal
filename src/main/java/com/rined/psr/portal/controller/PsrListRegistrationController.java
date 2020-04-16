package com.rined.psr.portal.controller;

import com.rined.psr.portal.model.converters.PsrListRegistrationConverter;
import com.rined.psr.portal.model.dto.brief.PsrListRegistrationBrief;
import com.rined.psr.portal.model.dto.fully.PsrListRegistrationDto;
import com.rined.psr.portal.model.PsrListRegistration;
import com.rined.psr.portal.repositories.PsrListRegistrationRepository;
import com.rined.psr.portal.services.PsrListRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Лист регистрации
@RestController
@RequestMapping("/psr/api/psr-list-registration")
public class PsrListRegistrationController extends BaseController<PsrListRegistrationDto, PsrListRegistrationBrief,
        PsrListRegistration, Long, PsrListRegistrationRepository, PsrListRegistrationConverter,
        PsrListRegistrationService> {

    public PsrListRegistrationController(PsrListRegistrationService service) {
        super(service);
    }

}