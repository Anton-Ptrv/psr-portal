package com.rined.psr.portal.model.converters;

import com.rined.psr.portal.model.dto.brief.VolunteerStatusBrief;
import com.rined.psr.portal.model.dto.fully.VolunteerStatusDto;
import com.rined.psr.portal.exception.IdMismatchException;
import com.rined.psr.portal.model.VolunteerStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VolunteerStatusConverter implements BaseConverter<VolunteerStatus, VolunteerStatusDto, VolunteerStatusBrief> {

    @Override
    public VolunteerStatusDto baseToDto(VolunteerStatus volunteerStatus) {
        return new VolunteerStatusDto(volunteerStatus.getId(), volunteerStatus.getName());
    }

    @Override
    public List<VolunteerStatusDto> baseToDtoList(List<VolunteerStatus> volunteerStatuses) {
        return volunteerStatuses.stream().map(this::baseToDto).collect(Collectors.toList());
    }

    @Override
    public VolunteerStatus dtoToBase(VolunteerStatusDto volunteerStatusDto) {
        return new VolunteerStatus(volunteerStatusDto.getId(), volunteerStatusDto.getName());
    }

    @Override
    public VolunteerStatus briefToBase(VolunteerStatusBrief volunteerStatusBrief) {
        return new VolunteerStatus(volunteerStatusBrief.getName());
    }

    @Override
    public VolunteerStatus mergeDtoAndBase(VolunteerStatus base, VolunteerStatusDto dto) {
        if (!base.getId().equals(dto.getId())) {
            throw new IdMismatchException("Path variable id and query object id mismatch!");
        }
        return dtoToBase(dto);
    }
}
