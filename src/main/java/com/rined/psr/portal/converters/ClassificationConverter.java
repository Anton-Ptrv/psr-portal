package com.rined.psr.portal.converters;

import com.rined.psr.portal.dto.fully.ClassificationDto;
import com.rined.psr.portal.model.Classification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ClassificationConverter implements BaseDtoConverter<Classification, ClassificationDto> {

    @Override
    public ClassificationDto convertToFullyDto(Classification volunteer) {
        if(Objects.isNull(volunteer))
            return null;
        return new ClassificationDto(volunteer.getId(), volunteer.getName());
    }

    @Override
    public List<ClassificationDto> convertToFullyDto(List<Classification> volunteer) {
        return volunteer.stream().map(this::convertToFullyDto).collect(Collectors.toList());
    }

    @Override
    public Classification fullyDtoToBase(ClassificationDto classificationFullyDto) {
        return new Classification(classificationFullyDto.getId(), classificationFullyDto.getName());
    }

}
