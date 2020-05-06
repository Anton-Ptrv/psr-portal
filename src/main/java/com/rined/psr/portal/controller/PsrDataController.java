package com.rined.psr.portal.controller;

import com.rined.psr.portal.model.PsrData;
import com.rined.psr.portal.model.User;
import com.rined.psr.portal.model.converters.PsrDataConverter;
import com.rined.psr.portal.model.dto.brief.PsrDataBrief;
import com.rined.psr.portal.model.dto.fully.PsrDataDto;
import com.rined.psr.portal.repositories.PsrDataRepository;
import com.rined.psr.portal.services.PsrDataService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

// Карточка ПСР
@RestController
@RequestMapping("/psr/api/psr-data")
public class PsrDataController extends BaseController<PsrDataDto, PsrDataBrief, PsrData, Long, PsrDataRepository,
        PsrDataConverter, PsrDataService> {

    public PsrDataController(PsrDataService service) {
        super(service);
    }

    @Override
    public void add(@RequestBody @Valid PsrDataBrief psrDataBrief) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        service.create(user, psrDataBrief);
    }
}