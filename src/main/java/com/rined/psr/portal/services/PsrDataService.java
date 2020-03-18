package com.rined.psr.portal.services;

import com.rined.psr.portal.dto.brief.PsrDataBrief;
import com.rined.psr.portal.dto.fully.PsrDataDto;

import java.util.List;

public interface PsrDataService {

    void addPsrData(PsrDataBrief psrDataBrief);

    List<PsrDataDto> getAllPsrsData();

    void updatePsrData(long id, PsrDataDto dto);

    PsrDataDto getPsrDataById(long id);

    void deletePsrDataById(long id);

}
