package com.rined.psr.portal.model.converters;

import com.rined.psr.portal.model.dto.brief.PsrBrief;
import com.rined.psr.portal.model.dto.brief.PsrStateBrief;
import com.rined.psr.portal.model.dto.fully.PsrDto;
import com.rined.psr.portal.model.dto.fully.PsrStateDto;
import com.rined.psr.portal.exception.IdMismatchException;
import com.rined.psr.portal.model.Psr;
import com.rined.psr.portal.model.PsrState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PsrConverter implements BaseConverter<Psr, PsrDto, PsrBrief> {

    private final BaseConverter<PsrState, PsrStateDto, PsrStateBrief> stateConverter;

    @Override
    public Psr briefToBase(PsrBrief psrBrief) {
        return new Psr(
                psrBrief.getName(),
                psrBrief.getStartDate(),
                psrBrief.getEndDate(),
                stateConverter.dtoToBase(psrBrief.getPsrState()),
                psrBrief.getComment()
        );
    }

    @Override
    public Psr mergeDtoAndBase(Psr base, PsrDto psrDto) {
        if (!base.getId().equals(psrDto.getId())) {
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
