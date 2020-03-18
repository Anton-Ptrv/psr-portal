package com.rined.psr.portal.converters;

import com.rined.psr.portal.dto.brief.ClassificationBrief;
import com.rined.psr.portal.dto.fully.ClassificationDto;
import com.rined.psr.portal.exception.IdMismatchException;
import com.rined.psr.portal.model.Classification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ClassificationConverter implements BaseConverter<Classification, ClassificationDto, ClassificationBrief> {

    @Override
    public ClassificationDto baseToDto(Classification volunteer) {
        if(Objects.isNull(volunteer))
            return null;
        return new ClassificationDto(volunteer.getId(), volunteer.getName());
    }

    @Override
    public List<ClassificationDto> baseToDtoList(List<Classification> volunteer) {
        return volunteer.stream().map(this::baseToDto).collect(Collectors.toList());
    }

    @Override
    public Classification dtoToBase(ClassificationDto classificationFullyDto) {
        return new Classification(classificationFullyDto.getId(), classificationFullyDto.getName());
    }

    @Override
    public Classification briefToBase(ClassificationBrief classificationBrief) {
        return new Classification(classificationBrief.getName());
    }

    @Override
    public Classification mergeDtoAndBase(Classification base, ClassificationDto classificationDto) {
        if (base.getId() != classificationDto.getId()) {
            throw new IdMismatchException("Path variable id and query object id mismatch!");
        }
        return dtoToBase(classificationDto);
    }
}
