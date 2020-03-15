package com.rined.psr.portal.converters;

import com.rined.psr.portal.dto.brief.PsrBriefDto;
import com.rined.psr.portal.dto.fully.PsrDto;
import com.rined.psr.portal.exception.IdMismatchException;
import com.rined.psr.portal.model.Psr;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PsrConverter implements FullyConverter<Psr, PsrDto, PsrBriefDto> {
    private final PsrStateConverter stateConverter;

    @Override
    public Psr briefToBase(PsrBriefDto psrBriefDto) {
        return new Psr(
                psrBriefDto.getName(),
                psrBriefDto.getStartDate(),
                psrBriefDto.getEndDate(),
                stateConverter.dtoToBase(psrBriefDto.getPsrState()),
                psrBriefDto.getComment()
        );
    }

    @Override
    public Psr mergeDtoAndBase(Psr base, PsrDto psrDto) {
        if (base.getId() != psrDto.getId()) {
            throw new IdMismatchException("Path variable id and query object id mismatch!");
        }
        return dtoToBase(psrDto);
    }

    @Override
    public PsrDto baseToDto(Psr psr) {
        return new PsrDto(
                psr.getId(),
                psr.getName(),
                psr.getStartDate(),
                psr.getEndDate(),
                stateConverter.baseToDto(psr.getPsrState()),
                psr.getComment()
        );
    }

    @Override
    public List<PsrDto> baseToDtoList(List<Psr> psrs) {
        return psrs.stream().map(this::baseToDto).collect(Collectors.toList());
    }

    @Override
    public Psr dtoToBase(PsrDto psrDto) {
        return new Psr(
                psrDto.getId(),
                psrDto.getName(),
                psrDto.getStartDate(),
                psrDto.getEndDate(),
                stateConverter.dtoToBase(psrDto.getPsrState()),
                psrDto.getComment()
        );
    }
}
