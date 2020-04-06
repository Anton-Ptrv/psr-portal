package com.rined.psr.portal.controller;

import com.rined.psr.portal.converters.ShuttleDataConverter;
import com.rined.psr.portal.dto.brief.ShuttleDataBrief;
import com.rined.psr.portal.dto.fully.ShuttleDataDto;
import com.rined.psr.portal.model.ShuttleData;
import com.rined.psr.portal.repositories.ShuttleDataRepository;
import com.rined.psr.portal.services.ShuttleDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/psr/api/shuttle-data")
public class ShuttleDataController extends BaseController<ShuttleDataDto, ShuttleDataBrief, ShuttleData, Long,
        ShuttleDataRepository, ShuttleDataConverter, ShuttleDataService> {

    public ShuttleDataController(ShuttleDataService service) {
        super(service);
    }

}