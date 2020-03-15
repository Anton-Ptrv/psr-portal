package com.rined.psr.portal.converters;

import com.rined.psr.portal.dto.brief.VolunteerBriefDto;
import com.rined.psr.portal.dto.fully.ClassificationDto;
import com.rined.psr.portal.dto.fully.VolunteerDto;
import com.rined.psr.portal.exception.IdMismatchException;
import com.rined.psr.portal.model.Classification;
import com.rined.psr.portal.model.Volunteer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class VolunteerConverter implements FullyConverter<Volunteer, VolunteerDto, VolunteerBriefDto> {
    private final BaseDtoConverter<Classification, ClassificationDto> classificationConverter;

    @Override
    public VolunteerDto baseToDto(Volunteer volunteer) {
        if (Objects.isNull(volunteer))
            return null;
        return VolunteerDto.builder()
                .id(volunteer.getId())
                .fio(volunteer.getFio())
                .sex(volunteer.isSex())
                .phone(volunteer.getPhone())
                .login(volunteer.getTelegramLogin())
                .classification(classificationConverter.baseToDto(volunteer.getClassification()))
                .equipment(volunteer.getEquipment())
                .psrListDesc(volunteer.getPsrListDesc())
                .comment(volunteer.getComment())
                .build();
    }

    @Override
    public List<VolunteerDto> bastToDtoList(List<Volunteer> volunteers) {
        return volunteers.stream().filter(Objects::nonNull).map(this::baseToDto).collect(Collectors.toList());
    }

    @Override
    public Volunteer dtoToBase(VolunteerDto dto) {
        return new Volunteer(
                dto.getId(),
                dto.getFio(),
                dto.isSex(),
                dto.getPhone(),
                dto.getLogin(),
                classificationConverter.dtoToBase(dto.getClassification()),
                dto.getEquipment(),
                dto.getPsrListDesc(),
                dto.getComment()
        );
    }

    @Override
    public Volunteer briefToBase(VolunteerBriefDto volunteerBrief) {
        return new Volunteer(
                volunteerBrief.getFio(),
                volunteerBrief.isSex(),
                volunteerBrief.getPhone(),
                volunteerBrief.getLogin(),
                new Classification(1)
        );
    }

    @Override
    public Volunteer mergeDtoAndBase(Volunteer base, VolunteerDto dto) {
        if (base.getId() != dto.getId()) {
            throw new IdMismatchException("Path variable id and query object id mismatch!");
        }
        return dtoToBase(dto);
    }
}
