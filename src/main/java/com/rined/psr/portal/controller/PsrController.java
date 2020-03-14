package com.rined.psr.portal.controller;

import com.rined.psr.portal.services.PsrService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PsrController {
    private final PsrService psrService;

}
