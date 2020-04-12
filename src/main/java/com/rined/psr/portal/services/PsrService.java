package com.rined.psr.portal.services;

import com.rined.psr.portal.model.converters.PsrConverter;
import com.rined.psr.portal.model.dto.brief.PsrBrief;
import com.rined.psr.portal.model.dto.fully.PsrDto;
import com.rined.psr.portal.model.Psr;
import com.rined.psr.portal.repositories.PsrRepository;
import org.springframework.stereotype.Service;

@Service
public class PsrService extends BaseService<PsrDto, PsrBrief, Psr, Long, PsrRepository, PsrConverter> {

    public PsrService(PsrConverter converter, PsrRepository repository) {
        super(converter, repository);
    }

}