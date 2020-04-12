package com.rined.psr.portal.services;

import com.rined.psr.portal.model.converters.PsrStateConverter;
import com.rined.psr.portal.model.dto.brief.PsrStateBrief;
import com.rined.psr.portal.model.dto.fully.PsrStateDto;
import com.rined.psr.portal.model.PsrState;
import com.rined.psr.portal.repositories.PsrStateRepository;
import org.springframework.stereotype.Service;

@Service
public class PsrStateService extends BaseService<PsrStateDto, PsrStateBrief, PsrState, Long, PsrStateRepository,
        PsrStateConverter> {

    public PsrStateService(PsrStateConverter converter, PsrStateRepository repository) {
        super(converter, repository);
    }

}
