package com.rined.psr.portal.controller;

import com.rined.psr.portal.services.ClassificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClassificationController {
    private final ClassificationService classificationService;
    
}
