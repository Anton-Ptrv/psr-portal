package com.rined.psr.portal.converters;

import com.rined.psr.portal.dto.brief.PsrBrief;
import com.rined.psr.portal.dto.brief.PsrDataBrief;
import com.rined.psr.portal.dto.brief.UserBrief;
import com.rined.psr.portal.dto.fully.PsrDataDto;
import com.rined.psr.portal.dto.fully.PsrDto;
import com.rined.psr.portal.dto.fully.UserDto;
import com.rined.psr.portal.model.Psr;
import com.rined.psr.portal.model.PsrData;
import com.rined.psr.portal.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PsrDataConverter implements BaseConverter<PsrData, PsrDataDto, PsrDataBrief> {

    private final BaseConverter<Psr, PsrDto, PsrBrief> psrConverter;
    private final BaseConverter<User, UserDto, UserBrief> userConverter;

    @Override
    public PsrData briefToBase(PsrDataBrief brief) {
        return new PsrData(
                psrConverter.briefToBase(brief.getPsr()),
                brief.getStation(),
                userConverter.briefToBase(brief.getPsrLeader()),
                userConverter.briefToBase(brief.getPsrRegisteredUser()),
                brief.getObjectInfo(),
                brief.getContent(),
                brief.getPhoto()
        );
    }

    @Override
    public PsrData mergeDtoAndBase(PsrData base, PsrDataDto dto) {
        return new PsrData(
                dto.getId(),
                psrConverter.dtoToBase(dto.getPsr()),
                dto.getStation(),
                userConverter.dtoToBase(dto.getPsrLeader()),
                userConverter.dtoToBase(dto.getPsrRegisteredUser()),
                dto.getObjectInfo(),
                dto.getContent(),
                dto.getPhoto()
        );
    }

    @Override
    public PsrDataDto baseToDto(PsrData psrData) {
        return new PsrDataDto(
                psrData.getId(),
                psrConverter.baseToDto(psrData.getPsr()),
                psrData.getStation(),
                userConverter.baseToDto(psrData.getPsrLeader()),
                userConverter.baseToDto(psrData.getPsrRegisteredUser()),
                psrData.getObjectInfo(),
                psrData.getContent(),
                psrData.getPhoto()
        );
    }

    @Override
    public List<PsrDataDto> baseToDtoList(List<PsrData> psrData) {
        return psrData.stream().map(this::baseToDto).collect(Collectors.toList());
    }

    @Override
    public PsrData dtoToBase(PsrDataDto dto) {
        return new PsrData(
                dto.getId(),
                psrConverter.dtoToBase(dto.getPsr()),
                dto.getStation(),
                userConverter.dtoToBase(dto.getPsrLeader()),
                userConverter.dtoToBase(dto.getPsrRegisteredUser()),
                dto.getObjectInfo(),
                dto.getContent(),
                dto.getPhoto()
        );
    }
}
