package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.FullyConverter;
import com.rined.psr.portal.dto.brief.VolunteerStatusBriefDto;
import com.rined.psr.portal.dto.fully.VolunteerStatusDto;
import com.rined.psr.portal.exception.NotFoundException;
import com.rined.psr.portal.model.VolunteerStatus;
import com.rined.psr.portal.repositories.VolunteerStatusRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class VolunteerStatusServiceImpl implements VolunteerStatusService {
    private final VolunteerStatusRepository volunteerStatusRepository;
    private final FullyConverter<VolunteerStatus, VolunteerStatusDto, VolunteerStatusBriefDto> converter;

    @Override
    public void addVolunteerStatus(VolunteerStatusBriefDto volunteerStatus) {
        log.trace("Create new volunteer status {}", volunteerStatus);
        volunteerStatusRepository.save(converter.briefToBase(volunteerStatus));
    }

    @Override
    public List<VolunteerStatusDto> getAllVolunteerStatuses() {
        log.trace("All available volunteer statuses");
        return converter.bastToDtoList(volunteerStatusRepository.findAll());
    }

    @Override
    public void updateVolunteerStatus(long id, VolunteerStatusDto dto) {
        log.trace("Update volunteer {} with id {}", dto, id);
        VolunteerStatus volunteerStatus = volunteerStatusRepository.findVolunteerStatusById(id)
                .orElseThrow(() -> new NotFoundException("VolunteerStatus with id '%d' not found!", id));
        volunteerStatusRepository.save(converter.mergeDtoAndBase(volunteerStatus, dto));
    }

    @Override
    public VolunteerStatusDto getVolunteerStatusById(long id) {
        log.trace("Get volunteer status by id {}", id);
        return volunteerStatusRepository.findVolunteerStatusById(id)
                .map(converter::baseToDto)
                .orElseThrow(() -> new NotFoundException("VolunteerStatus with id '%d' not found!", id));
    }

}
