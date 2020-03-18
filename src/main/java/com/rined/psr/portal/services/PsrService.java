package com.rined.psr.portal.services;

import com.rined.psr.portal.dto.brief.PsrBrief;
import com.rined.psr.portal.dto.fully.PsrDto;

import java.util.List;

public interface PsrService {

    void addPsr(PsrBrief psrBrief);

    List<PsrDto> getAllPsrs();

    void updatePsr(long id, PsrDto dto);

    PsrDto getPsrById(long id);

    void deletePsrById(long id);

}
