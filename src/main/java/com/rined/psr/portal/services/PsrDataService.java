package com.rined.psr.portal.services;

import com.rined.psr.portal.dto.brief.PsrDataBriefDto;
import com.rined.psr.portal.dto.fully.PsrDataDto;

import java.util.List;

public interface PsrDataService {

    void addPsrData(PsrDataBriefDto psrDataBriefDto);

    List<PsrDataDto> getAllPsrsData();

    void updatePsrData(long id, PsrDataDto dto);

    PsrDataDto getPsrDataById(long id);

}
