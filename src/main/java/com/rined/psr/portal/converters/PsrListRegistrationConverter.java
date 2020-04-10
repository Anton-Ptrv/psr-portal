package com.rined.psr.portal.converters;

import com.rined.psr.portal.dto.brief.PsrBrief;
import com.rined.psr.portal.dto.brief.PsrListRegistrationBrief;
import com.rined.psr.portal.dto.brief.VolunteerBrief;
import com.rined.psr.portal.dto.brief.VolunteerStatusBrief;
import com.rined.psr.portal.dto.fully.PsrDto;
import com.rined.psr.portal.dto.fully.PsrListRegistrationDto;
import com.rined.psr.portal.dto.fully.VolunteerDto;
import com.rined.psr.portal.dto.fully.VolunteerStatusDto;
import com.rined.psr.portal.exception.IdMismatchException;
import com.rined.psr.portal.model.Psr;
import com.rined.psr.portal.model.PsrListRegistration;
import com.rined.psr.portal.model.Volunteer;
import com.rined.psr.portal.model.VolunteerStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PsrListRegistrationConverter implements BaseConverter<PsrListRegistration, PsrListRegistrationDto, PsrListRegistrationBrief> {

    private final BaseConverter<Psr, PsrDto, PsrBrief> psrConverter;
    private final BaseConverter<Volunteer, VolunteerDto, VolunteerBrief> volunteerConverter;
    private final BaseConverter<VolunteerStatus, VolunteerStatusDto, VolunteerStatusBrief> volunteerStatusConverter;

    @Override
    public PsrListRegistration briefToBase(PsrListRegistrationBrief brief) {
        return new PsrListRegistration(
                brief.getId(),
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
