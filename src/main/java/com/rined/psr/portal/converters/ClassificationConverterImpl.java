package com.rined.psr.portal.converters;

import com.rined.psr.portal.dto.fully.ClassificationFullyDto;
import com.rined.psr.portal.model.Classification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ClassificationConverterImpl implements BaseDtoConverter<Classification, ClassificationFullyDto> {

    @Override
    public ClassificationFullyDto convertToFullyDto(Classification volunteer) {
        if(Objects.isNull(volunteer))
            return null;
        return new ClassificationFullyDto(volunteer.getId(), volunteer.getName());
    }

    @Override
    public List<ClassificationFullyDto> convertToFullyDto(List<Classification> volunteer) {
        return volunteer.stream().map(this::convertToFullyDto).collect(Collectors.toList());
    }

    @Override
    public Classification fullyDtoToBase(ClassificationFullyDto classificationFullyDto) {
        return new Classification(classificationFullyDto.getId(), classificationFullyDto.getName());
    }

}
