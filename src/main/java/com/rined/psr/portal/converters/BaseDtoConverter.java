package com.rined.psr.portal.converters;

import java.util.List;

public interface BaseDtoConverter<BaseType, FullyDto> {

    FullyDto convertToFullyDto(BaseType baseType);

    List<FullyDto> convertToFullyDto(List<BaseType> baseTypeList);

    BaseType fullyDtoToBase(FullyDto fullyDto);

}
