package com.rined.psr.portal.services;

import com.rined.psr.portal.model.converters.ShuttleConverter;
import com.rined.psr.portal.model.dto.brief.ShuttleBrief;
import com.rined.psr.portal.model.dto.fully.ShuttleDto;
import com.rined.psr.portal.model.Shuttle;
import com.rined.psr.portal.repositories.ShuttleRepository;
import org.springframework.stereotype.Service;

@Service
public class ShuttleService extends BaseService<ShuttleDto, ShuttleBrief, Shuttle, Long, ShuttleRepository,
        ShuttleConverter> {

    public ShuttleService(ShuttleConverter converter, ShuttleRepository repository) {
        super(converter, repository);
    }

}
