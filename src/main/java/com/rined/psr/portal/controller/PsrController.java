package com.rined.psr.portal.controller;

import com.rined.psr.portal.dto.brief.PsrBriefDto;
import com.rined.psr.portal.dto.fully.PsrDto;
import com.rined.psr.portal.services.PsrService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PsrController {
    private final PsrService psrService;

    @PostMapping("/psrs")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPsr(@Valid @RequestBody PsrBriefDto psrBriefDto) {
        psrService.addPsr(psrBriefDto);
    }

    @GetMapping("/psrs")
    @ResponseStatus(HttpStatus.OK)
    public List<PsrDto> getAllPsrs() {
        return psrService.getAllPsrs();
    }

    @PutMapping("/psrs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePsr(@PathVariable("id") long id, @Valid @RequestBody PsrDto dto) {
        psrService.updatePsr(id, dto);
    }

    @GetMapping("/psrs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PsrDto getPsrById(@PathVariable("id") long id){
        return psrService.getPsrById(id);
    }

}