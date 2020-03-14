package com.rined.psr.portal.controller;

import com.rined.psr.portal.services.ShuttleDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShuttleDataController {
    private final ShuttleDataService shuttleDataService;

}
