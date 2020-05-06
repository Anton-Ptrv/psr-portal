package com.rined.psr.portal.model.converters;

import com.rined.psr.portal.model.dto.brief.PsrBrief;
import com.rined.psr.portal.model.dto.brief.ShuttleBrief;
import com.rined.psr.portal.model.dto.fully.PsrDto;
import com.rined.psr.portal.model.dto.fully.ShuttleDto;
import com.rined.psr.portal.model.Psr;
import com.rined.psr.portal.model.Shuttle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ShuttleConverter implements BaseConverter<Shuttle, ShuttleDto, ShuttleBrief> {

    private final BaseConverter<Psr, PsrDto, PsrBrief> psrConverter;

    @Override
    public Shuttle briefToBase(ShuttleBrief brief) {
        return new Shuttle(
                Objects.isNull(brief.getRegisteredOnPsr())
                        ? null
                        : psrConverter.dtoToBase(brief.getRegisteredOnPsr()),
                brief.getAuto()
        );
    }

    @Override
    public Shuttle mergeDtoAndBase(Shuttle shuttle, ShuttleDto dto) {
        return new Shuttle(
                dto.getId(),
                Objects.isNull(dto.getRegisteredOnPsr())
                        ? null
                        : psrConverter.dtoToBase(dto.getRegisteredOnPsr()),
                dto.getAuto()
        );
    }

    @Override
    public ShuttleDto baseToDto(Shuttle base) {
        return new ShuttleDto(
                base.getId(),
                Objects.isNull(base.getRegisteredOnPsr())
                        ? null
                        : psrConverter.baseToDto(base.getRegisteredOnPsr()),
                base.getAuto()
        );
    }

    @Override
    public List<ShuttleDto> baseToDtoList(List<Shuttle> baseTypeList) {
        return baseTypeList.stream().map(this::baseToDto).collect(Collectors.toList());
    }

    @Override
    public Shuttle dtoToBase(ShuttleDto dto) {
        return new Shuttle(
                dto.getId(),
                Objects.isNull(dto.getRegisteredOnPsr())
                        ? null
                        : psrConverter.dtoToBase(dto.getRegisteredOnPsr()),
                dto.getAuto()
        );
    }
}
