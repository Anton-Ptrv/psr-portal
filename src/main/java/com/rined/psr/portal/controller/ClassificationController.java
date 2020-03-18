package com.rined.psr.portal.controller;

import com.rined.psr.portal.dto.brief.ClassificationBriefDto;
import com.rined.psr.portal.dto.fully.ClassificationDto;
import com.rined.psr.portal.services.ClassificationServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classification")
public class ClassificationController extends BaseController<ClassificationDto, ClassificationBriefDto, Long, ClassificationServiceImpl> {
    public ClassificationController(ClassificationServiceImpl service) {
        super(service);
    }
}
