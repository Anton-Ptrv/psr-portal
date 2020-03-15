package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.FullyConverter;
import com.rined.psr.portal.dto.brief.ShuttleBriefDto;
import com.rined.psr.portal.dto.fully.ShuttleDto;
import com.rined.psr.portal.exception.NotFoundException;
import com.rined.psr.portal.model.Shuttle;
import com.rined.psr.portal.repositories.ShuttleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShuttleServiceImpl implements ShuttleService {
    private final ShuttleRepository shuttleRepository;
    private final FullyConverter<Shuttle, ShuttleDto, ShuttleBriefDto> converter;

    @Override
    public void addShuttle(ShuttleBriefDto brief) {
        log.trace("Add shuttle {}", brief);
        shuttleRepository.save(converter.briefToBase(brief));
    }

    @Override
    public List<ShuttleDto> getAllShuttles() {
        log.trace("Get all shuttles");
        return converter.baseToDtoList(shuttleRepository.findAll());
    }

    @Override
    public void updateShuttle(long id, ShuttleDto dto) {
        log.trace("Update shuttle {} with id {}", dto, id);
        Shuttle shuttle = shuttleRepository.findShuttleById(id)
                .orElseThrow(() -> new NotFoundException("Shuttle with id '%d' not found!", id));
        shuttleRepository.save(shuttle);
    }

    @Override
    public ShuttleDto getShuttleById(long id) {
        log.trace("Get shuttle by id {}", id);
        return shuttleRepository.findShuttleById(id)
                .map(converter::baseToDto)
                .orElseThrow(() -> new NotFoundException("Shuttle with id '%d' not found!", id));
    }

    @Override
    public void deleteShuttleById(long id) {
        log.trace("Delete shuttle by id {}", id);
        if (shuttleRepository.existsById(id))
            throw new NotFoundException("Shuttle with id '%d' not found!", id);
        shuttleRepository.deleteById(id);
    }
}
