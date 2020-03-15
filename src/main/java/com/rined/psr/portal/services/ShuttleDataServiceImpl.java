package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.FullyConverter;
import com.rined.psr.portal.dto.brief.ShuttleDataBriefDto;
import com.rined.psr.portal.dto.fully.ShuttleDataDto;
import com.rined.psr.portal.exception.NotFoundException;
import com.rined.psr.portal.model.ShuttleData;
import com.rined.psr.portal.repositories.ShuttleDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShuttleDataServiceImpl implements ShuttleDataService {
    private final ShuttleDataRepository shuttleDataRepository;
    private final FullyConverter<ShuttleData, ShuttleDataDto, ShuttleDataBriefDto> converter;

    @Override
    public void addShuttleData(ShuttleDataBriefDto brief) {
        log.trace("Add shuttle data {}", brief);
        shuttleDataRepository.save(converter.briefToBase(brief));
    }

    @Override
    public List<ShuttleDataDto> getAllShuttlesData() {
        log.trace("Get all shuttles data");
        return converter.baseToDtoList(shuttleDataRepository.findAll());
    }

    @Override
    public void updateShuttleData(long id, ShuttleDataDto dto) {
        log.trace("Update shuttle data {} with id {}", dto, id);
        ShuttleData shuttleData = shuttleDataRepository.findShuttleById(id)
                .orElseThrow(() -> new NotFoundException("Shuttle data with id '%d' not found!", id));
        shuttleDataRepository.save(converter.mergeDtoAndBase(shuttleData, dto));
    }

    @Override
    public ShuttleDataDto getShuttleById(long id) {
        log.trace("Get shuttle by id");
        return shuttleDataRepository.findShuttleById(id)
                .map(converter::baseToDto)
                .orElseThrow(() -> new NotFoundException("Shuttle data with id '%d' not found!", id));
    }

}
