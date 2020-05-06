package com.rined.psr.portal.model.converters;

import com.rined.psr.portal.model.dto.brief.PsrBrief;
import com.rined.psr.portal.model.dto.brief.PsrDataBrief;
import com.rined.psr.portal.model.dto.brief.UserBrief;
import com.rined.psr.portal.model.dto.fully.PsrDataDto;
import com.rined.psr.portal.model.dto.fully.PsrDto;
import com.rined.psr.portal.model.dto.fully.UserDto;
import com.rined.psr.portal.model.Psr;
import com.rined.psr.portal.model.PsrData;
import com.rined.psr.portal.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PsrDataConverter implements BaseConverter<PsrData, PsrDataDto, PsrDataBrief> {

    private final BaseConverter<Psr, PsrDto, PsrBrief> psrConverter;
    private final BaseConverter<User, UserDto, UserBrief> userConverter;

    @Override
    public PsrData briefToBase(PsrDataBrief brief) {
        return new PsrData(
                Objects.isNull(brief.getPsr())
                        ? null
                        : psrConverter.dtoToBase(brief.getPsr()),
                brief.getStation(),
                Objects.isNull(brief.getPsrLeader())
                        ? null
                        : userConverter.dtoToBase(brief.getPsrLeader()),
                Objects.isNull(brief.getPsrRegisteredUser())
                        ? null
                        : userConverter.dtoToBase(brief.getPsrRegisteredUser()),
                brief.getObjectInfo(),
                brief.getContent(),
                brief.getPhoto()
        );
    }

    @Override
    public PsrData mergeDtoAndBase(PsrData base, PsrDataDto dto) {
       return dtoToBase(dto);
    }

    @Override
    public PsrDataDto baseToDto(PsrData psrData) {
        return new PsrDataDto(
                psrData.getId(),
                Objects.isNull(psrData.getPsr())
                        ? null
                        : psrConverter.baseToDto(psrData.getPsr()),
                psrData.getStation(),
                Objects.isNull(psrData.getPsrLeader())
                        ? null
                        : userConverter.baseToDto(psrData.getPsrLeader()),
                Objects.isNull(psrData.getPsrRegisteredUser())
                        ? null
                        : userConverter.baseToDto(psrData.getPsrRegisteredUser()),
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
                Objects.isNull(dto.getPsr())
                        ? null
                        : psrConverter.dtoToBase(dto.getPsr()),
                dto.getStation(),
                Objects.isNull(dto.getPsrLeader())
                        ? null
                        : userConverter.dtoToBase(dto.getPsrLeader()),
                Objects.isNull(dto.getPsrRegisteredUser())
                        ? null
                        : userConverter.dtoToBase(dto.getPsrRegisteredUser()),
                dto.getObjectInfo(),
                dto.getContent(),
                dto.getPhoto()
        );
    }
}
