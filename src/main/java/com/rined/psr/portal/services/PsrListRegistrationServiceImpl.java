package com.rined.psr.portal.services;

import com.rined.psr.portal.repositories.PsrListRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PsrListRegistrationServiceImpl implements PsrListRegistrationService {
    private final PsrListRegistrationRepository psrListRegistrationRepository;

}
