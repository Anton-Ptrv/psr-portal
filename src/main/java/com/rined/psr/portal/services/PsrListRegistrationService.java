package com.rined.psr.portal.services;

import com.rined.psr.portal.dto.brief.PsrListRegistrationBrief;
import com.rined.psr.portal.dto.fully.PsrListRegistrationDto;

import java.util.List;

public interface PsrListRegistrationService {

    void addPsrListRegistration(PsrListRegistrationBrief brief);

    List<PsrListRegistrationDto> getAllPsrListRegistrations();

    void updatePsrListRegistration(long id, PsrListRegistrationDto dto);

    PsrListRegistrationDto getPsrListRegistrationById(long id);

    void deletePsrListRegistrationById(long id);

}
