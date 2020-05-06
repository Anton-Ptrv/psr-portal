package com.rined.psr.portal.model.converters;

import com.rined.psr.portal.model.dto.brief.PsrStateBrief;
import com.rined.psr.portal.model.dto.fully.PsrStateDto;
import com.rined.psr.portal.exception.IdMismatchException;
import com.rined.psr.portal.model.PsrState;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PsrStateConverter implements BaseConverter<PsrState, PsrStateDto, PsrStateBrief> {

    @Override
    public PsrState briefToBase(PsrStateBrief psrStateBrief) {
        return new PsrState(psrStateBrief.getName());
    }

    @Override
    public PsrState mergeDtoAndBase(PsrState base, PsrStateDto psrStateDto) {
        if (!base.getId().equals(psrStateDto.getId())) {
            throw new IdMismatchException("Path variable id and query object id mismatch!");
        }
        return dtoToBase(psrStateDto);
    }

    @Override
    public PsrStateDto baseToDto(PsrState psrState) {
        return new PsrStateDto(psrState.getId(), psrState.getName());
    }

    @Override
    public List<PsrStateDto> baseToDtoList(List<PsrState> psrStates) {
        return psrStates.stream().map(this::baseToDto).collect(Collectors.toList());
    }

    @Override
    public PsrState dtoToBase(PsrStateDto psrStateDto) {
        return new PsrState(psrStateDto.getId(), psrStateDto.getName());
    }
}
