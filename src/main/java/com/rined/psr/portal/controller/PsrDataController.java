package com.rined.psr.portal.controller;

import com.rined.psr.portal.services.PsrDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PsrDataController {
    private final PsrDataService psrDataService;

}
