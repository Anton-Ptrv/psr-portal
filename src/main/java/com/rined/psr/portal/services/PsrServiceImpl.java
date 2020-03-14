package com.rined.psr.portal.services;

import com.rined.psr.portal.repositories.PsrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PsrServiceImpl implements PsrService {
    private final PsrRepository psrRepository;
}
