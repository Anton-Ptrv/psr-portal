package com.rined.psr.portal.controller;

import com.rined.psr.portal.dto.brief.PsrStateBrief;
import com.rined.psr.portal.dto.fully.PsrStateDto;
import com.rined.psr.portal.services.PsrStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PsrStateController {
    private final PsrStateService psrStateService;

    @PostMapping("/psr-state")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPsrState(@Valid @RequestBody PsrStateBrief psrStateBrief) {
        psrStateService.addPsrState(psrStateBrief);
    }

    @GetMapping("/psr-state")
    @ResponseStatus(HttpStatus.OK)
    public List<PsrStateDto> getAllPsrStates() {
        return psrStateService.getAllPsrStates();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/psr-state/{id}")
    public void updatePsrState(@PathVariable("id") long id, @Valid @RequestBody PsrStateDto psrStateDto) {
        psrStateService.updatePsrState(id, psrStateDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/psr-state/{id}")
    public PsrStateDto getPsrStateById(@PathVariable("id") long id) {
        return psrStateService.getPsrStateById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/psr-state/{id}")
    public void deletePsrStateById(@PathVariable("id") long id) {
        psrStateService.deletePsrStateById(id);
    }
}
