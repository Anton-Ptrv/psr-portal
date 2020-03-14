package com.rined.psr.portal.controller;

import com.rined.psr.portal.services.ShuttleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShuttleController {
    private final ShuttleService shuttleService;

}
