package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.FullyConverter;
import com.rined.psr.portal.dto.brief.PsrListRegistrationBriefDto;
import com.rined.psr.portal.dto.fully.PsrListRegistrationDto;
import com.rined.psr.portal.exception.NotFoundException;
import com.rined.psr.portal.model.PsrListRegistration;
import com.rined.psr.portal.repositories.PsrListRegistrationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PsrListRegistrationServiceImpl implements PsrListRegistrationService {
    private final PsrListRegistrationRepository psrListRegistrationRepository;
    private final FullyConverter<PsrListRegistration, PsrListRegistrationDto, PsrListRegistrationBriefDto> converter;

    @Override
    public void addPsrListRegistration(PsrListRegistrationBriefDto brief) {
        log.trace("Add psr list registration {}", brief);
        psrListRegistrationRepository.save(converter.briefToBase(brief));
    }

    @Override
    public List<PsrListRegistrationDto> getAllPsrListRegistrations() {
        log.trace("Get all psr list registrations");
        return converter.baseToDtoList(psrListRegistrationRepository.findAll());
    }

    @Override
    public void updatePsrListRegistration(long id, PsrListRegistrationDto dto) {
        log.trace("Update psr list registration {} with id {}", dto, id);
        PsrListRegistration psrListRegistration = psrListRegistrationRepository.findPsrListRegistrationById(id)
                .orElseThrow(() -> new NotFoundException("Psr list registration with id '%d' not found!", id));
        psrListRegistrationRepository.save(psrListRegistration);
    }

    @Override
    public PsrListRegistrationDto getPsrListRegistrationById(long id) {
        log.trace("Get psr list registration by id {}", id);
        return psrListRegistrationRepository.findPsrListRegistrationById(id)
                .map(converter::baseToDto)
                .orElseThrow(() -> new NotFoundException("Psr list registration with id '%d' not found!", id));
    }
}
