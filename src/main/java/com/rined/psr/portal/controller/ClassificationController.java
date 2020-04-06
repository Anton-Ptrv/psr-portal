package com.rined.psr.portal.controller;

import com.rined.psr.portal.converters.ClassificationConverter;
import com.rined.psr.portal.dto.brief.ClassificationBrief;
import com.rined.psr.portal.dto.fully.ClassificationDto;
import com.rined.psr.portal.model.Classification;
import com.rined.psr.portal.repositories.ClassificationRepository;
import com.rined.psr.portal.services.ClassificationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/psr/api/classification")
public class ClassificationController extends BaseController<ClassificationDto, ClassificationBrief, Classification,
        Long, ClassificationRepository, ClassificationConverter, ClassificationService> {

    public ClassificationController(ClassificationService service) {
        super(service);
    }

}