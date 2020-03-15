package com.rined.psr.portal.converters;

import com.rined.psr.portal.dto.brief.PsrListRegistrationBriefDto;
import com.rined.psr.portal.dto.fully.PsrListRegistrationDto;
import com.rined.psr.portal.exception.IdMismatchException;
import com.rined.psr.portal.model.PsrListRegistration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PsrListRegistrationConverter implements FullyConverter<PsrListRegistration, PsrListRegistrationDto, PsrListRegistrationBriefDto> {
    private final PsrConverter psrConverter;
    private final VolunteerConverter volunteerConverter;
    private final VolunteerStatusConverter volunteerStatusConverter;

    @Override
    public PsrListRegistration briefToBase(PsrListRegistrationBriefDto brief) {
        return new PsrListRegistration(
                psrConverter.briefToBase(brief.getPsr()),
                volunteerConverter.briefToBase(brief.getVolunteer()),
                volunteerStatusConverter.briefToBase(brief.getVolunteerStatus()),
                brief.getShuttleNum(),
                brief.getDepartureAddress(),
                brief.getStartVolunteerTime(),
                brief.getEndVolunteerTime()
        );
    }

    @Override
    public PsrListRegistration mergeDtoAndBase(PsrListRegistration base, PsrListRegistrationDto dto) {
        if (base.getId() != dto.getId()) {
            throw new IdMismatchException("Path variable id and query object id mismatch!");
        }
        return dtoToBase(dto);
    }

    @Override
    public PsrListRegistrationDto baseToDto(PsrListRegistration base) {
        return new PsrListRegistrationDto(
                base.getId(),
                psrConverter.baseToDto(base.getPsr()),
                volunteerConverter.baseToDto(base.getVolunteer()),
                volunteerStatusConverter.baseToDto(base.getVolunteerStatus()),
                base.getShuttleNum(),
                base.getDepartureAddress(),
                base.getStartVolunteerTime(),
                base.getEndVolunteerTime()
        );
    }

    @Override
    public List<PsrListRegistrationDto> baseToDtoList(List<PsrListRegistration> baseTypeList) {
        return baseTypeList.stream().map(this::baseToDto).collect(Collectors.toList());
    }

    @Override
    public PsrListRegistration dtoToBase(PsrListRegistrationDto dto) {
        return new PsrListRegistration(
                dto.getId(),
                psrConverter.dtoToBase(dto.getPsr()),
                volunteerConverter.dtoToBase(dto.getVolunteer()),
                volunteerStatusConverter.dtoToBase(dto.getVolunteerStatus()),
                dto.getShuttleNum(),
                dto.getDepartureAddress(),
                dto.getStartVolunteerTime(),
                dto.getEndVolunteerTime()
        );
    }
}
