package com.rined.psr.portal.converters;

import com.rined.psr.portal.dto.request.brief.VolunteerBrief;
import com.rined.psr.portal.dto.response.fully.ClassificationFullyResponse;
import com.rined.psr.portal.dto.response.fully.VolunteerFullyResponse;
import com.rined.psr.portal.model.Classification;
import com.rined.psr.portal.model.Volunteer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class VolunteerConverterImpl implements FullyConverter<Volunteer, VolunteerFullyResponse, VolunteerBrief> {
    private final BaseDtoConverter<Classification, ClassificationFullyResponse> classificationConverter;

    @Override
    public VolunteerFullyResponse convertToFullyDto(Volunteer volunteer) {
        if (Objects.isNull(volunteer))
            return null;
        return VolunteerFullyResponse.builder()
                .id(volunteer.getId())
                .fio(volunteer.getFio())
                .sex(volunteer.isSex())
                .phone(volunteer.getPhone())
                .login(volunteer.getTelegramLogin())
                .classification(classificationConverter.convertToFullyDto(volunteer.getClassification()))
                .equipment(volunteer.getEquipment())
                .psrListDesc(volunteer.getPsrListDesc())
                .comment(volunteer.getComment())
                .build();
    }

    @Override
    public List<VolunteerFullyResponse> convertToFullyDto(List<Volunteer> volunteers) {
        return volunteers.stream().map(this::convertToFullyDto).collect(Collectors.toList());
    }

    @Override
    public Volunteer briefToBase(VolunteerBrief volunteerBrief) {
        return new Volunteer(
                volunteerBrief.getFio(),
                volunteerBrief.isSex(),
                volunteerBrief.getPhone(),
                volunteerBrief.getLogin(),
                new Classification(1)
        );
    }
}
