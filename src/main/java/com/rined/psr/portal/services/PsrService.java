package com.rined.psr.portal.services;

import com.rined.psr.portal.model.Psr;
import com.rined.psr.portal.model.converters.PsrConverter;
import com.rined.psr.portal.model.dto.brief.PsrBrief;
import com.rined.psr.portal.model.dto.fully.PsrDto;
import com.rined.psr.portal.repositories.PsrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PsrService extends BaseService<PsrDto, PsrBrief, Psr, Long, PsrRepository, PsrConverter> {
    private final PsrStateService psrStateService;

    @Autowired
    public PsrService(PsrConverter converter, PsrRepository repository, PsrStateService psrStateService) {
        super(converter, repository);
        this.psrStateService = psrStateService;
    }

    @Override
    public Psr cascadeSave(Psr psr) {
        if (Objects.nonNull(psr) && Objects.isNull(psr.getId())) {
            psrStateService.cascadeSave(psr.getPsrState());

            return repository.save(psr);
        }
        return psr;
    }
}