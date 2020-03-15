package com.rined.psr.portal.converters;

import com.rined.psr.portal.dto.brief.ShuttleDataBriefDto;
import com.rined.psr.portal.dto.fully.ShuttleDataDto;
import com.rined.psr.portal.model.ShuttleData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ShuttleDataConverter implements FullyConverter<ShuttleData, ShuttleDataDto, ShuttleDataBriefDto> {
    private final ShuttleConverter shuttleConverter;
    private final VolunteerConverter volunteerConverter;

    @Override
    public ShuttleData briefToBase(ShuttleDataBriefDto brief) {
        return new ShuttleData(
                shuttleConverter.briefToBase(brief.getShuttle()),
                volunteerConverter.briefToBase(brief.getShuttleOwner()),
                brief.isDriver()
        );
    }

    @Override
    public ShuttleData mergeDtoAndBase(ShuttleData shuttleData, ShuttleDataDto dto) {
        return new ShuttleData(
                dto.getId(),
                shuttleConverter.dtoToBase(dto.getShuttle()),
                volunteerConverter.dtoToBase(dto.getShuttleOwner()),
                dto.isDriver()
        );
    }

    @Override
    public ShuttleDataDto baseToDto(ShuttleData base) {
        return new ShuttleDataDto(
                base.getId(),
                shuttleConverter.baseToDto(base.getShuttle()),
                volunteerConverter.baseToDto(base.getShuttleOwner()),
                base.isDriver()
        );
    }

    @Override
    public List<ShuttleDataDto> baseToDtoList(List<ShuttleData> baseTypeList) {
        return baseTypeList.stream().map(this::baseToDto).collect(Collectors.toList());
    }

    @Override
    public ShuttleData dtoToBase(ShuttleDataDto dto) {
        return new ShuttleData(
                dto.getId(),
                shuttleConverter.dtoToBase(dto.getShuttle()),
                volunteerConverter.dtoToBase(dto.getShuttleOwner()),
                dto.isDriver()
        );
    }
}
