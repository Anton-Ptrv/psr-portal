package com.rined.psr.portal.services;

import com.rined.psr.portal.dto.brief.ClassificationBriefDto;
import com.rined.psr.portal.dto.fully.ClassificationDto;

import java.util.List;

public interface ClassificationService {

    void addClassification(ClassificationBriefDto classificationBriefDto);

    List<ClassificationDto> getAllClassifications();

    void updateClassification(long id, ClassificationDto classificationDto);

    ClassificationDto getClassificationById(long id);

}
