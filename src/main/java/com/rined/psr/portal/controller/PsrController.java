package com.rined.psr.portal.controller;

import com.rined.psr.portal.model.Psr;
import com.rined.psr.portal.model.converters.PsrConverter;
import com.rined.psr.portal.model.dto.brief.PsrBrief;
import com.rined.psr.portal.model.dto.fully.PsrDto;
import com.rined.psr.portal.repositories.PsrRepository;
import com.rined.psr.portal.services.PsrService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Список спасательных работ. Главная страница
@RestController
@RequestMapping("/psr/api/psr")
public class PsrController extends BaseController<PsrDto, PsrBrief, Psr, Long, PsrRepository, PsrConverter, PsrService> {

    public PsrController(PsrService service) {
        super(service);
    }
}