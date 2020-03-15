package com.rined.psr.portal.converters;

public interface FullyConverter<BaseType, FullyDto, BriefDto> extends BaseDtoConverter<BaseType, FullyDto> {

    BaseType briefToBase(BriefDto briefDto);

    BaseType mergeDtoAndBase(BaseType base, FullyDto fullyDto);

}
