package com.rined.psr.portal.converters;

public interface FullyConverter<Base, Dto, Brief> extends BaseDtoConverter<Base, Dto> {

    Base briefToBase(Brief briefDto);

    Base mergeDtoAndBase(Base base, Dto fullyDto);

}
