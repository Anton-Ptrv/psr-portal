package com.rined.psr.portal.controller;

import com.rined.psr.portal.dto.brief.PsrListRegistrationBrief;
import com.rined.psr.portal.dto.fully.PsrListRegistrationDto;
import com.rined.psr.portal.services.PsrListRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PsrListRegistrationController {
    private final PsrListRegistrationService psrListRegistrationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/psr-list-registration")
    public void addPsrListRegistration(@Valid @RequestBody PsrListRegistrationBrief brief) {
        psrListRegistrationService.addPsrListRegistration(brief);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/psr-list-registration")
    public List<PsrListRegistrationDto> getAllPsrListRegistrations() {
        return psrListRegistrationService.getAllPsrListRegistrations();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/psr-list-registration/{id}")
    public void updatePsrListRegistration(@PathVariable("id") long id, PsrListRegistrationDto dto) {
        psrListRegistrationService.updatePsrListRegistration(id, dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/psr-list-registration/{id}")
    public PsrListRegistrationDto getPsrListRegistrationById(@PathVariable("id") long id) {
        return psrListRegistrationService.getPsrListRegistrationById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/psr-list-registration/{id}")
    public void deletePsrListRegistrationById(@PathVariable("id") long id) {
        psrListRegistrationService.deletePsrListRegistrationById(id);
    }

}
