package com.rined.psr.portal.services;

import com.rined.psr.portal.dto.brief.PsrBriefDto;
import com.rined.psr.portal.dto.fully.PsrDto;

import java.util.List;

public interface PsrService {

    void addPsr(PsrBriefDto psrBriefDto);

    List<PsrDto> getAllPsrs();

    void updatePsr(long id, PsrDto dto);

    PsrDto getPsrById(long id);

}
