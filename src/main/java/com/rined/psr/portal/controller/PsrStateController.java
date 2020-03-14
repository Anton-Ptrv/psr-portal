package com.rined.psr.portal.controller;

import com.rined.psr.portal.services.PsrStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PsrStateController {
    private final PsrStateService psrStateService;

}
