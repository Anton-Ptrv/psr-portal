package com.rined.psr.portal.model.converters;

import com.rined.psr.portal.model.dto.brief.PsrBrief;
import com.rined.psr.portal.model.dto.brief.PsrListRegistrationBrief;
import com.rined.psr.portal.model.dto.brief.VolunteerBrief;
import com.rined.psr.portal.model.dto.brief.VolunteerStatusBrief;
import com.rined.psr.portal.model.dto.fully.PsrDto;
import com.rined.psr.portal.model.dto.fully.PsrListRegistrationDto;
import com.rined.psr.portal.model.dto.fully.VolunteerDto;
import com.rined.psr.portal.model.dto.fully.VolunteerStatusDto;
import com.rined.psr.portal.exception.IdMismatchException;
import com.rined.psr.portal.model.Psr;
import com.rined.psr.portal.model.PsrListRegistration;
import com.rined.psr.portal.model.Volunteer;
import com.rined.psr.portal.model.VolunteerStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
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
                Objects.isNull(brief.getPsr())
                        ? null
                        : psrConverter.dtoToBase(brief.getPsr()),
                Objects.isNull(brief.getVolunteer())
                        ? null
                        : volunteerConverter.dtoToBase(brief.getVolunteer()),
                Objects.isNull(brief.getVolunteerStatus())
                        ? null
                        : volunteerStatusConverter.dtoToBase(brief.getVolunteerStatus()),
                brief.getShuttleNum(),
                brief.getDepartureAddress(),
                brief.getStartVolunteerTime(),
                brief.getEndVolunteerTime()
        );
    }

    @Override
    public PsrListRegistration mergeDtoAndBase(PsrListRegistration base, PsrListRegistrationDto dto) {
        if (!base.getId().equals(dto.getId())) {
            throw new IdMismatchException("Path variable id and query object id mismatch!");
        }
        return dtoToBase(dto);
    }

    @Override
    public PsrListRegistrationDto baseToDto(PsrListRegistration base) {
        return new PsrListRegistrationDto(
                base.getId(),
                Objects.isNull(base.getPsr())
                        ? null
                        : psrConverter.baseToDto(base.getPsr()),
                Objects.isNull(base.getVolunteer())
                        ? null
                        : volunteerConverter.baseToDto(base.getVolunteer()),
                Objects.isNull(base.getVolunteerStatus())
                        ? null
                        : volunteerStatusConverter.baseToDto(base.getVolunteerStatus()),
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
                Objects.isNull(dto.getPsr())
                        ? null
                        : psrConverter.dtoToBase(dto.getPsr()),
                Objects.isNull(dto.getVolunteer())
                        ? null
                        : volunteerConverter.dtoToBase(dto.getVolunteer()),
                Objects.isNull(dto.getVolunteerStatus())
                        ? null
                        : volunteerStatusConverter.dtoToBase(dto.getVolunteerStatus()),
                dto.getShuttleNum(),
                dto.getDepartureAddress(),
                dto.getStartVolunteerTime(),
                dto.getEndVolunteerTime()
        );
    }
}
