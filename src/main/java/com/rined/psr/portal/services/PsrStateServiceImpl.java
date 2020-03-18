package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.BaseConverter;
import com.rined.psr.portal.dto.brief.PsrStateBrief;
import com.rined.psr.portal.dto.fully.PsrStateDto;
import com.rined.psr.portal.exception.NotFoundException;
import com.rined.psr.portal.model.PsrState;
import com.rined.psr.portal.repositories.PsrStateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PsrStateServiceImpl implements PsrStateService {
    private final PsrStateRepository psrStateRepository;
    private final BaseConverter<PsrState, PsrStateDto, PsrStateBrief> converter;

    @Override
    public void addPsrState(PsrStateBrief psrStateBrief) {
        log.trace("Create new psr state {}", psrStateBrief);
        psrStateRepository.save(converter.briefToBase(psrStateBrief));
    }

    @Override
    public List<PsrStateDto> getAllPsrStates() {
        log.trace("All available psr states");
        return converter.baseToDtoList(psrStateRepository.findAll());
    }

    @Override
    public void updatePsrState(long id, PsrStateDto psrStateDto) {
        log.trace("Update psr state {} with id {}", psrStateDto, id);
        PsrState psrState = psrStateRepository.findPsrStateById(id)
                .orElseThrow(() -> new NotFoundException("Psr state with id '%d' not found!", id));
        psrStateRepository.save(converter.mergeDtoAndBase(psrState, psrStateDto));
    }

    @Override
    public PsrStateDto getPsrStateById(long id) {
        log.trace("Get psr state by id {}", id);
        return psrStateRepository.findPsrStateById(id)
                .map(converter::baseToDto)
                .orElseThrow(() -> new NotFoundException("Psr state with id '%d' not found!", id));
    }

    @Override
    public void deletePsrStateById(long id) {
        log.trace("Delete psr state by id {}", id);
        if (!psrStateRepository.existsById(id))
            throw new NotFoundException("Classification with id '%d' not found!", id);
        psrStateRepository.deleteById(id);
    }
}
