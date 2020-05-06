package com.rined.psr.portal.controller;

import com.rined.psr.portal.model.converters.ShuttleConverter;
import com.rined.psr.portal.model.dto.brief.ShuttleBrief;
import com.rined.psr.portal.model.dto.fully.ShuttleDto;
import com.rined.psr.portal.model.Shuttle;
import com.rined.psr.portal.repositories.ShuttleRepository;
import com.rined.psr.portal.services.ShuttleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/psr/api/shuttle")
public class ShuttleController extends BaseController<ShuttleDto, ShuttleBrief, Shuttle, Long, ShuttleRepository,
        ShuttleConverter, ShuttleService> {

    public ShuttleController(ShuttleService service) {
        super(service);
    }

}