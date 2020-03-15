package com.rined.psr.portal.converters;

import java.util.List;

public interface BaseDtoConverter<Base, Dto> {

    Dto baseToDto(Base baseType);

    List<Dto> bastToDtoList(List<Base> baseTypeList);

    Base dtoToBase(Dto fullyDto);

}
