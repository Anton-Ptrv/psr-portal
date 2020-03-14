package com.rined.psr.portal.services;

import com.rined.psr.portal.repositories.PsrStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PsrStateServiceImpl implements PsrStateService {
    private final PsrStateRepository psrStateRepository;

}
