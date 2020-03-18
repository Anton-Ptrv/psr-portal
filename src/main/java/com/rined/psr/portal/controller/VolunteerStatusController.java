package com.rined.psr.portal.controller;

import com.rined.psr.portal.dto.brief.VolunteerStatusBrief;
import com.rined.psr.portal.dto.fully.VolunteerStatusDto;
import com.rined.psr.portal.services.VolunteerStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class VolunteerStatusController {
    private final VolunteerStatusService volunteerStatusService;

    @PostMapping("/volunteer-status")
    @ResponseStatus(HttpStatus.CREATED)
    public void addVolunteerStatus(@Valid @RequestBody VolunteerStatusBrief volunteerStatusBrief) {
        volunteerStatusService.addVolunteerStatus(volunteerStatusBrief);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/volunteer-status")
    public List<VolunteerStatusDto> getAllVolunteerStatuses() {
        return volunteerStatusService.getAllVolunteerStatuses();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/volunteer-status/{id}")
    public void updateVolunteerStatus(@PathVariable("id") long id, @Valid @RequestBody VolunteerStatusDto dto) {
        volunteerStatusService.updateVolunteerStatus(id, dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/volunteer-status/{id}")
    public VolunteerStatusDto getVolunteerStatusById(@PathVariable("id") long id){
        return volunteerStatusService.getVolunteerStatusById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/volunteer-status/{id}")
    public void deleteVolunteerStatusById(@PathVariable("id") long id){
        volunteerStatusService.deleteVolunteerStatusById(id);
    }

}
