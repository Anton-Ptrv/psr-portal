package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.PsrDataConverter;
import com.rined.psr.portal.dto.brief.PsrDataBrief;
import com.rined.psr.portal.dto.fully.PsrDataDto;
import com.rined.psr.portal.model.PsrData;
import com.rined.psr.portal.repositories.PsrDataRepository;
import org.springframework.stereotype.Service;

@Service
public class PsrDataService extends BaseService<PsrDataDto, PsrDataBrief, PsrData, Long, PsrDataRepository,
        PsrDataConverter> {
    public PsrDataService(PsrDataConverter converter, PsrDataRepository repository) {
        super(converter, repository);
    }
}
