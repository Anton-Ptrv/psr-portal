package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.ShuttleDataConverter;
import com.rined.psr.portal.dto.brief.ShuttleDataBrief;
import com.rined.psr.portal.dto.fully.ShuttleDataDto;
import com.rined.psr.portal.model.ShuttleData;
import com.rined.psr.portal.repositories.ShuttleDataRepository;
import org.springframework.stereotype.Service;

@Service
public class ShuttleDataService extends BaseService<ShuttleDataDto, ShuttleDataBrief, ShuttleData, Long,
        ShuttleDataRepository, ShuttleDataConverter> {

    public ShuttleDataService(ShuttleDataConverter converter, ShuttleDataRepository repository) {
        super(converter, repository);
    }

}
