package com.rined.psr.portal.services;

import com.rined.psr.portal.repositories.PsrDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PsrDataServiceImpl implements PsrDataService {
    private final PsrDataRepository psrDataRepository;

}
