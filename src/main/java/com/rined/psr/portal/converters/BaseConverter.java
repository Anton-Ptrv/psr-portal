package com.rined.psr.portal.converters;

import java.util.List;

public interface BaseConverter<Base, Dto, Brief> {

    Base briefToBase(Brief briefDto);

    Base mergeDtoAndBase(Base base, Dto fullyDto);

    Dto baseToDto(Base baseType);

    List<Dto> baseToDtoList(List<Base> baseTypeList);

    Base dtoToBase(Dto fullyDto);

}
