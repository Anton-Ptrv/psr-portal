package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.FullyConverter;
import com.rined.psr.portal.dto.brief.PsrDataBriefDto;
import com.rined.psr.portal.dto.fully.PsrDataDto;
import com.rined.psr.portal.exception.NotFoundException;
import com.rined.psr.portal.model.PsrData;
import com.rined.psr.portal.repositories.PsrDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PsrDataServiceImpl implements PsrDataService {
    private final PsrDataRepository psrDataRepository;
    private final FullyConverter<PsrData, PsrDataDto, PsrDataBriefDto> converter;

    @Override
    public void addPsrData(PsrDataBriefDto psrDataBriefDto) {
        log.trace("Add psr data {}", psrDataBriefDto);
        psrDataRepository.save(converter.briefToBase(psrDataBriefDto));
    }

    @Override
    public List<PsrDataDto> getAllPsrsData() {
        log.trace("Get available psrs data");
        return converter.baseToDtoList(psrDataRepository.findAll());
    }

    @Override
    public void updatePsrData(long id, PsrDataDto dto) {
        log.trace("Update psr data {} with id {}", dto, id);
        psrDataRepository.save(converter.dtoToBase(dto));
    }

    @Override
    public PsrDataDto getPsrDataById(long id) {
        log.trace("Get psr data by id {}", id);
        return psrDataRepository.getPsrDataById(id)
                .map(converter::baseToDto)
                .orElseThrow(() -> new NotFoundException("Psr data not found by id %d!", id));
    }

    @Override
    public void deletePsrDataById(long id) {
        log.trace("Delete psr data by id {}", id);
        if(!psrDataRepository.existsById(id))
            throw new NotFoundException("Psr data with id '%d' not found!", id);
        psrDataRepository.deleteById(id);
    }
}
