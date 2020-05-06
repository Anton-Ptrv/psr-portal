package com.rined.psr.portal.services;

import com.rined.psr.portal.model.ShuttleData;
import com.rined.psr.portal.model.converters.ShuttleDataConverter;
import com.rined.psr.portal.model.dto.brief.ShuttleDataBrief;
import com.rined.psr.portal.model.dto.fully.ShuttleDataDto;
import com.rined.psr.portal.repositories.ShuttleDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ShuttleDataService extends BaseService<ShuttleDataDto, ShuttleDataBrief, ShuttleData, Long,
        ShuttleDataRepository, ShuttleDataConverter> {
    private final ShuttleService shuttleService;
    private final VolunteerService volunteerService;

    @Autowired
    public ShuttleDataService(ShuttleDataConverter converter,
                              ShuttleDataRepository repository,
                              ShuttleService shuttleService,
                              VolunteerService volunteerService) {
        super(converter, repository);
        this.shuttleService = shuttleService;
        this.volunteerService = volunteerService;
    }

    @Override
    public ShuttleData cascadeSave(ShuttleData shuttleData) {
        if (Objects.nonNull(shuttleData) && Objects.isNull(shuttleData.getId())) {
            shuttleService.cascadeSave(shuttleData.getShuttle());
            volunteerService.cascadeSave(shuttleData.getShuttleOwner());

            return repository.save(shuttleData);
        }
        return shuttleData;
    }
}
