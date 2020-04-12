package com.rined.psr.portal.controller;

import com.rined.psr.portal.model.converters.VolunteerConverter;
import com.rined.psr.portal.model.dto.SimpleRequest;
import com.rined.psr.portal.model.dto.SimpleResponse;
import com.rined.psr.portal.model.dto.brief.VolunteerBrief;
import com.rined.psr.portal.model.dto.fully.VolunteerDto;
import com.rined.psr.portal.model.Volunteer;
import com.rined.psr.portal.repositories.VolunteerRepository;
import com.rined.psr.portal.services.VolunteerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/psr/api/volunteers")
public class VolunteerController extends BaseController<VolunteerDto, VolunteerBrief, Volunteer, Long,
        VolunteerRepository, VolunteerConverter, VolunteerService> {

    public VolunteerController(VolunteerService service) {
        super(service);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/exists/phone")
    public SimpleResponse<Boolean> isVolunteerExistsByPhone(@Valid @RequestBody SimpleRequest<String> phone) {
        return SimpleResponse.of(service.isVolunteerExistsByPhone(phone.getData()));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/exists/telegram")
    public SimpleResponse<Boolean> isVolunteerExistsByTelegram(@Valid @RequestBody SimpleRequest<String> login) {
        return SimpleResponse.of(service.isVolunteerExistsByTelegram(login.getData()));
    }

}