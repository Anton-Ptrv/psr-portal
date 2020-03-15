package com.rined.psr.portal.converters;

import com.rined.psr.portal.dto.brief.VolunteerStatusBriefDto;
import com.rined.psr.portal.dto.fully.VolunteerStatusDto;
import com.rined.psr.portal.exception.IdMismatchException;
import com.rined.psr.portal.model.VolunteerStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VolunteerStatusConverter implements FullyConverter<VolunteerStatus, VolunteerStatusDto, VolunteerStatusBriefDto> {

    @Override
    public VolunteerStatusDto convertToFullyDto(VolunteerStatus volunteerStatus) {
        return new VolunteerStatusDto(volunteerStatus.getId(), volunteerStatus.getName());
    }

    @Override
    public List<VolunteerStatusDto> convertToFullyDto(List<VolunteerStatus> volunteerStatuses) {
        return volunteerStatuses.stream().map(this::convertToFullyDto).collect(Collectors.toList());
    }

    @Override
    public VolunteerStatus fullyDtoToBase(VolunteerStatusDto volunteerStatusDto) {
        return new VolunteerStatus(volunteerStatusDto.getId(), volunteerStatusDto.getName());
    }

    @Override
    public VolunteerStatus briefToBase(VolunteerStatusBriefDto volunteerStatusBriefDto) {
        return new VolunteerStatus(volunteerStatusBriefDto.getName());
    }

    @Override
    public VolunteerStatus mergeDtoAndBase(VolunteerStatus base, VolunteerStatusDto dto) {
        if (base.getId() != dto.getId()) {
            throw new IdMismatchException("Path variable id and query object id mismatch!");
        }
        return fullyDtoToBase(dto);
    }
}
