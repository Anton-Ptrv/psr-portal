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
                stateConverter.fullyDtoToBase(psrBriefDto.getPsrState()),
                psrBriefDto.getComment()
        );
    }

    @Override
    public Psr mergeDtoAndBase(Psr base, PsrDto psrDto) {
        if (base.getId() != psrDto.getId()) {
            throw new IdMismatchException("Path variable id and query object id mismatch!");
        }
        return fullyDtoToBase(psrDto);
    }

    @Override
    public PsrDto convertToFullyDto(Psr psr) {
        return new PsrDto(
                psr.getId(),
                psr.getName(),
                psr.getStartDate(),
                psr.getEndDate(),
                stateConverter.convertToFullyDto(psr.getPsrState()),
                psr.getComment()
        );
    }

    @Override
    public List<PsrDto> convertToFullyDto(List<Psr> psrs) {
        return psrs.stream().map(this::convertToFullyDto).collect(Collectors.toList());
    }

    @Override
    public Psr fullyDtoToBase(PsrDto psrDto) {
        return new Psr(
                psrDto.getId(),
                psrDto.getName(),
                psrDto.getStartDate(),
                psrDto.getEndDate(),
                stateConverter.fullyDtoToBase(psrDto.getPsrState()),
                psrDto.getComment()
        );
    }
}
