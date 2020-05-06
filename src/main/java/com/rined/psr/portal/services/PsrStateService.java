package com.rined.psr.portal.services;

import com.rined.psr.portal.model.converters.PsrStateConverter;
import com.rined.psr.portal.model.dto.brief.PsrStateBrief;
import com.rined.psr.portal.model.dto.fully.PsrStateDto;
import com.rined.psr.portal.model.PsrState;
import com.rined.psr.portal.repositories.PsrStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PsrStateService extends BaseService<PsrStateDto, PsrStateBrief, PsrState, Long, PsrStateRepository,
        PsrStateConverter> {

    @Autowired
    public PsrStateService(PsrStateConverter converter, PsrStateRepository repository) {
        super(converter, repository);
    }

    @Override
    public PsrState cascadeSave(PsrState psrState) {
        if (Objects.nonNull(psrState) && Objects.isNull(psrState.getId()))
            return repository.save(psrState);
        return psrState;
    }
}
