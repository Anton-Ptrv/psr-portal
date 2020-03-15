package com.rined.psr.portal.controller;

import com.rined.psr.portal.dto.brief.PsrDataBriefDto;
import com.rined.psr.portal.dto.fully.PsrDataDto;
import com.rined.psr.portal.services.PsrDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PsrDataController {
    private final PsrDataService psrDataService;

    @PostMapping("/psr-data")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPsrData(@Valid @RequestBody PsrDataBriefDto psrDataBriefDto) {
        psrDataService.addPsrData(psrDataBriefDto);
    }

    @GetMapping("/psr-data")
    @ResponseStatus(HttpStatus.OK)
    public List<PsrDataDto> getAllPsrsData() {
        return psrDataService.getAllPsrsData();
    }

    @PutMapping("/psr-data/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePsrData(@PathVariable("id") long id, @Valid @RequestBody PsrDataDto dto) {
        psrDataService.updatePsrData(id, dto);
    }

    @GetMapping("/psr-data/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PsrDataDto getPsrDataById(@PathVariable("id") long id) {
        return psrDataService.getPsrDataById(id);
    }

    @DeleteMapping("/psr-data/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePsrDataById(@PathVariable("id") long id) {
         psrDataService.deletePsrDataById(id);
    }

}
