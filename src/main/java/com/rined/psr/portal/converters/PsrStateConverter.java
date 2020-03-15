package com.rined.psr.portal.converters;

import com.rined.psr.portal.dto.brief.PsrStateBriefDto;
import com.rined.psr.portal.dto.fully.PsrStateDto;
import com.rined.psr.portal.exception.IdMismatchException;
import com.rined.psr.portal.model.PsrState;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PsrStateConverter implements FullyConverter<PsrState, PsrStateDto, PsrStateBriefDto> {

    @Override
    public PsrState briefToBase(PsrStateBriefDto psrStateBriefDto) {
        return new PsrState(psrStateBriefDto.getName());
    }

    @Override
    public PsrState mergeDtoAndBase(PsrState base, PsrStateDto psrStateDto) {
        if (base.getId() != psrStateDto.getId()) {
            throw new IdMismatchException("Path variable id and query object id mismatch!");
        }
        return fullyDtoToBase(psrStateDto);
    }

    @Override
    public PsrStateDto convertToFullyDto(PsrState psrState) {
        return new PsrStateDto(psrState.getId(), psrState.getName());
    }

    @Override
    public List<PsrStateDto> convertToFullyDto(List<PsrState> psrStates) {
        return psrStates.stream().map(this::convertToFullyDto).collect(Collectors.toList());
    }

    @Override
    public PsrState fullyDtoToBase(PsrStateDto psrStateDto) {
        return new PsrState(psrStateDto.getId(), psrStateDto.getName());
    }
}
