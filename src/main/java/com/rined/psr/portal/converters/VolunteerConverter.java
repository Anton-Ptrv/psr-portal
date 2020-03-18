package com.rined.psr.portal.converters;

import com.rined.psr.portal.dto.brief.ClassificationBrief;
import com.rined.psr.portal.dto.brief.VolunteerBrief;
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
public class VolunteerConverter implements BaseConverter<Volunteer, VolunteerDto, VolunteerBrief> {

    private final BaseConverter<Classification, ClassificationDto, ClassificationBrief> classificationConverter;

    @Override
    public VolunteerDto baseToDto(Volunteer volunteer) {
        if (Objects.isNull(volunteer))
            return null;
        return VolunteerDto.builder()
                .id(volunteer.getId())
                .fio(volunteer.getFio())
                .sex(volunteer.getSex())
                .phone(volunteer.getPhone())
                .login(volunteer.getTelegramLogin())
                .classification(classificationConverter.baseToDto(volunteer.getClassification()))
                .equipment(volunteer.getEquipment())
                .psrListDesc(volunteer.getPsrListDesc())
                .comment(volunteer.getComment())
                .build();
    }

    @Override
    public List<VolunteerDto> baseToDtoList(List<Volunteer> volunteers) {
        return volunteers.stream().filter(Objects::nonNull).map(this::baseToDto).collect(Collectors.toList());
    }

    @Override
    public Volunteer dtoToBase(VolunteerDto dto) {
        return new Volunteer(
                dto.getId(),
                dto.getFio(),
                dto.getSex(),
                dto.getPhone(),
                dto.getLogin(),
                classificationConverter.dtoToBase(dto.getClassification()),
                dto.getEquipment(),
                dto.getPsrListDesc(),
                dto.getComment()
        );
    }

    @Override
    public Volunteer briefToBase(VolunteerBrief volunteerBrief) {
        return new Volunteer(
                volunteerBrief.getFio(),
                volunteerBrief.getSex(),
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
