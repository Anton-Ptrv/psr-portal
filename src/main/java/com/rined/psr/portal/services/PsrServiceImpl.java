package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.FullyConverter;
import com.rined.psr.portal.dto.brief.PsrBriefDto;
import com.rined.psr.portal.dto.fully.PsrDto;
import com.rined.psr.portal.exception.NotFoundException;
import com.rined.psr.portal.model.Psr;
import com.rined.psr.portal.repositories.PsrRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PsrServiceImpl implements PsrService {
    private final PsrRepository psrRepository;
    private final FullyConverter<Psr, PsrDto, PsrBriefDto> converter;

    @Override
    public void addPsr(PsrBriefDto psrBriefDto) {
        log.trace("Add psr {}", psrBriefDto);
        psrRepository.save(converter.briefToBase(psrBriefDto));
    }

    @Override
    public List<PsrDto> getAllPsrs() {
        log.trace("Get all psr dto");
        return converter.baseToDtoList(psrRepository.findAll());
    }

    @Override
    public void updatePsr(long id, PsrDto psrDto) {
        log.trace("Update psr {} with id {}", psrDto, id);
        Psr psr = psrRepository.findPsrById(id)
                .orElseThrow(() -> new NotFoundException("Psr with id '%d' not found!", id));
        psrRepository.save(converter.mergeDtoAndBase(psr, psrDto));
    }

    @Override
    public PsrDto getPsrById(long id) {
        log.trace("Get psr by id {}", id);
        return psrRepository.findPsrById(id)
                .map(converter::baseToDto)
                .orElseThrow(() -> new NotFoundException("User with id '%d' not found!", id));
    }
}
