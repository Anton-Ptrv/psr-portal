package com.rined.psr.portal.controller;

import com.rined.psr.portal.converters.VolunteerStatusConverter;
import com.rined.psr.portal.dto.brief.VolunteerStatusBrief;
import com.rined.psr.portal.dto.fully.VolunteerStatusDto;
import com.rined.psr.portal.model.VolunteerStatus;
import com.rined.psr.portal.repositories.VolunteerStatusRepository;
import com.rined.psr.portal.services.VolunteerStatusService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/volunteer-status")
public class VolunteerStatusController extends BaseController<VolunteerStatusDto, VolunteerStatusBrief, VolunteerStatus,
        Long, VolunteerStatusRepository, VolunteerStatusConverter, VolunteerStatusService> {
    public VolunteerStatusController(VolunteerStatusService service) {
        super(service);
    }
}
