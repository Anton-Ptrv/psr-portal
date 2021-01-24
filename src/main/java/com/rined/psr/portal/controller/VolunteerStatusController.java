package com.rined.psr.portal.controller;

import com.rined.psr.portal.model.converters.VolunteerStatusConverter;
import com.rined.psr.portal.model.dto.brief.VolunteerStatusBrief;
import com.rined.psr.portal.model.dto.fully.VolunteerStatusDto;
import com.rined.psr.portal.model.VolunteerStatus;
import com.rined.psr.portal.repositories.VolunteerStatusRepository;
import com.rined.psr.portal.services.VolunteerStatusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/psr/api/volunteer-status")
public class VolunteerStatusController extends BaseController<VolunteerStatusDto, VolunteerStatusBrief, VolunteerStatus, Long, VolunteerStatusRepository, VolunteerStatusConverter, VolunteerStatusService> {

    public VolunteerStatusController(VolunteerStatusService service) {
        super(service);
    }

}