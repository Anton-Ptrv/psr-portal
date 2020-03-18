package com.rined.psr.portal.services;

import com.rined.psr.portal.dto.brief.PsrStateBrief;
import com.rined.psr.portal.dto.fully.PsrStateDto;

import java.util.List;

public interface PsrStateService {

    void addPsrState(PsrStateBrief psrStateBrief);

    List<PsrStateDto> getAllPsrStates();

    void updatePsrState(long id, PsrStateDto psrStateDto);

    PsrStateDto getPsrStateById(long id);

    void deletePsrStateById(long id);

}
