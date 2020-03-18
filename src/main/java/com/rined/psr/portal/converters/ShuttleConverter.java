package com.rined.psr.portal.converters;

import com.rined.psr.portal.dto.brief.ShuttleBrief;
import com.rined.psr.portal.dto.fully.ShuttleDto;
import com.rined.psr.portal.model.Shuttle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ShuttleConverter implements BaseConverter<Shuttle, ShuttleDto, ShuttleBrief> {
    private final PsrConverter psrConverter;

    @Override
    public Shuttle briefToBase(ShuttleBrief brief) {
        return new Shuttle(
                psrConverter.briefToBase(brief.getRegisteredOnPsr()),
                brief.getAuto()
        );
    }

    @Override
    public Shuttle mergeDtoAndBase(Shuttle shuttle, ShuttleDto dto) {
        return new Shuttle(
                dto.getId(),
                psrConverter.dtoToBase(dto.getRegisteredOnPsr()),
                dto.getAuto()
        );
    }

    @Override
    public ShuttleDto baseToDto(Shuttle base) {
        return new ShuttleDto(
                base.getId(),
                psrConverter.baseToDto(base.getRegisteredOnPsr()),
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
                psrConverter.dtoToBase(dto.getRegisteredOnPsr()),
                dto.getAuto()
        );
    }
}
