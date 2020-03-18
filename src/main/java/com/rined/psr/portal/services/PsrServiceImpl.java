package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.BaseConverter;
import com.rined.psr.portal.dto.brief.PsrBrief;
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
    private final BaseConverter<Psr, PsrDto, PsrBrief> converter;

    @Override
    public void addPsr(PsrBrief psrBrief) {
        log.trace("Add psr {}", psrBrief);
        psrRepository.save(converter.briefToBase(psrBrief));
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
                .orElseThrow(() -> new NotFoundException("Psr with id '%d' not found!", id));
    }

    @Override
    public void deletePsrById(long id) {
        log.trace("Delete psr by id");
        if(!psrRepository.existsById(id)){
            throw new NotFoundException("Psr with id '%d' not found!", id);
        }
    }
}
