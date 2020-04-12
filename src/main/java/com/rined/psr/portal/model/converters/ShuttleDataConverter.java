package com.rined.psr.portal.model.converters;

import com.rined.psr.portal.model.dto.brief.ShuttleBrief;
import com.rined.psr.portal.model.dto.brief.ShuttleDataBrief;
import com.rined.psr.portal.model.dto.brief.VolunteerBrief;
import com.rined.psr.portal.model.dto.fully.ShuttleDataDto;
import com.rined.psr.portal.model.dto.fully.ShuttleDto;
import com.rined.psr.portal.model.dto.fully.VolunteerDto;
import com.rined.psr.portal.model.Shuttle;
import com.rined.psr.portal.model.ShuttleData;
import com.rined.psr.portal.model.Volunteer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ShuttleDataConverter implements BaseConverter<ShuttleData, ShuttleDataDto, ShuttleDataBrief> {

    private final BaseConverter<Shuttle, ShuttleDto, ShuttleBrief> shuttleConverter;
    private final BaseConverter<Volunteer, VolunteerDto, VolunteerBrief> volunteerConverter;

    @Override
    public ShuttleData briefToBase(ShuttleDataBrief brief) {
        return new ShuttleData(
                shuttleConverter.dtoToBase(brief.getShuttle()),
                volunteerConverter.dtoToBase(brief.getShuttleOwner()),
                brief.getDriver()
        );
    }

    @Override
    public ShuttleData mergeDtoAndBase(ShuttleData shuttleData, ShuttleDataDto dto) {
        return new ShuttleData(
                dto.getId(),
                shuttleConverter.dtoToBase(dto.getShuttle()),
                volunteerConverter.dtoToBase(dto.getShuttleOwner()),
                dto.getDriver()
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
                dto.getDriver()
        );
    }
}
