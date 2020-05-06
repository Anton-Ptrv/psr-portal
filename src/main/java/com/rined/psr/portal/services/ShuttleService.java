package com.rined.psr.portal.services;

import com.rined.psr.portal.model.converters.ShuttleConverter;
import com.rined.psr.portal.model.dto.brief.ShuttleBrief;
import com.rined.psr.portal.model.dto.fully.ShuttleDto;
import com.rined.psr.portal.model.Shuttle;
import com.rined.psr.portal.repositories.ShuttleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ShuttleService extends BaseService<ShuttleDto, ShuttleBrief, Shuttle, Long, ShuttleRepository,
        ShuttleConverter> {
    private final PsrService psrService;

    @Autowired
    public ShuttleService(ShuttleConverter converter,
                          ShuttleRepository repository,
                          PsrService psrService) {
        super(converter, repository);
        this.psrService = psrService;
    }

    @Override
    public Shuttle cascadeSave(Shuttle shuttle) {
        if (Objects.nonNull(shuttle) && Objects.isNull(shuttle.getId())) {
            psrService.cascadeSave(shuttle.getRegisteredOnPsr());

            return repository.save(shuttle);
        }
        return shuttle;
    }
}
