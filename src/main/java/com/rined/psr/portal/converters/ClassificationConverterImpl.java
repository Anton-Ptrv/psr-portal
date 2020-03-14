package com.rined.psr.portal.converters;

import com.rined.psr.portal.dto.response.fully.ClassificationFullyResponse;
import com.rined.psr.portal.model.Classification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ClassificationConverterImpl implements BaseDtoConverter<Classification, ClassificationFullyResponse> {

    @Override
    public ClassificationFullyResponse convertToFullyDto(Classification volunteer) {
        if(Objects.isNull(volunteer))
            return null;
        return new ClassificationFullyResponse(volunteer.getId(), volunteer.getName());
    }

    @Override
    public List<ClassificationFullyResponse> convertToFullyDto(List<Classification> volunteer) {
        return volunteer.stream().map(this::convertToFullyDto).collect(Collectors.toList());
    }

}
