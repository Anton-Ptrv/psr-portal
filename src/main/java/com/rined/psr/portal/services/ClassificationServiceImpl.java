package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.FullyConverter;
import com.rined.psr.portal.dto.brief.ClassificationBriefDto;
import com.rined.psr.portal.dto.fully.ClassificationDto;
import com.rined.psr.portal.exception.NotFoundException;
import com.rined.psr.portal.model.Classification;
import com.rined.psr.portal.repositories.ClassificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationRepository classificationRepository;
    private final FullyConverter<Classification, ClassificationDto, ClassificationBriefDto> converter;

    @Override
    public void addClassification(ClassificationBriefDto classificationBriefDto) {
        log.trace("Create new classification {}", classificationBriefDto);
        classificationRepository.save(converter.briefToBase(classificationBriefDto));
    }

    @Override
    public List<ClassificationDto> getAllClassifications() {
        log.trace("Get all classifications");
        return converter.convertToFullyDto(classificationRepository.findAll());
    }

    @Override
    public void updateClassification(long id, ClassificationDto classificationDto) {
        log.trace("Update classification {} with id {}", classificationDto, id);
        Classification classification = classificationRepository.findClassificationById(id)
                .orElseThrow(() -> new NotFoundException("Classification with id '%d' not found!", id));
        classificationRepository.save(converter.mergeDtoAndBase(classification, classificationDto));
    }

    @Override
    public ClassificationDto getClassificationById(long id) {
        log.trace("Get classification by id {}", id);
        return classificationRepository.findClassificationById(id)
                .map(converter::convertToFullyDto)
                .orElseThrow(() -> new NotFoundException("VolunteerStatus with id '%d' not found!", id));
    }
}
