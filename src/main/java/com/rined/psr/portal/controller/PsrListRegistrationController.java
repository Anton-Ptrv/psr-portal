package com.rined.psr.portal.controller;

import com.rined.psr.portal.model.converters.PsrListRegistrationConverter;
import com.rined.psr.portal.model.dto.brief.PsrListRegistrationBrief;
import com.rined.psr.portal.model.dto.fully.PsrListRegistrationDto;
import com.rined.psr.portal.model.PsrListRegistration;
import com.rined.psr.portal.model.dto.request.PsrListRegistrationVolunteersStatus;
import com.rined.psr.portal.model.viewgroup.ViewGroup;
import com.rined.psr.portal.repositories.PsrListRegistrationRepository;
import com.rined.psr.portal.services.PsrListRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/psr/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<PsrListRegistrationDto> getPsrListForPsr(@PathVariable("id") Long id) {
        return service.getPsrListRegistrationsByPsr(id);
    }

    @PutMapping("/volunteer-status")
    @ResponseStatus(HttpStatus.OK)
    public void changeVolunteerStatusForPsrListRegistrations(
            @Validated(ViewGroup.UseExisting.class) @RequestBody PsrListRegistrationVolunteersStatus newStatus) {
        service.changeVolunteerStatusForPsrListRegistrations(newStatus);
    }
}