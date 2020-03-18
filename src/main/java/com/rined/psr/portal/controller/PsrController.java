package com.rined.psr.portal.controller;

import com.rined.psr.portal.dto.brief.PsrBrief;
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

    @PostMapping("/psr")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPsr(@Valid @RequestBody PsrBrief psrBrief) {
        psrService.addPsr(psrBrief);
    }

    @GetMapping("/psr")
    @ResponseStatus(HttpStatus.OK)
    public List<PsrDto> getAllPsrs() {
        return psrService.getAllPsrs();
    }

    @PutMapping("/psr/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePsr(@PathVariable("id") long id, @Valid @RequestBody PsrDto dto) {
        psrService.updatePsr(id, dto);
    }

    @GetMapping("/psr/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PsrDto getPsrById(@PathVariable("id") long id){
        return psrService.getPsrById(id);
    }

    @DeleteMapping("/psr/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePsrById(@PathVariable("id") long id){
        psrService.deletePsrById(id);
    }

}