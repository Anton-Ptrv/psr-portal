package com.rined.psr.portal.controller;

import com.rined.psr.portal.dto.brief.ShuttleDataBriefDto;
import com.rined.psr.portal.dto.fully.ShuttleDataDto;
import com.rined.psr.portal.services.ShuttleDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShuttleDataController {
    private final ShuttleDataService shuttleDataService;

    @PostMapping("/shuttle-data")
    @ResponseStatus(HttpStatus.CREATED)
    public void addShuttleData(@Valid @RequestBody ShuttleDataBriefDto brief) {
        shuttleDataService.addShuttleData(brief);
    }

    @GetMapping("/shuttle-data")
    @ResponseStatus(HttpStatus.OK)
    public List<ShuttleDataDto> getAllShuttlesData() {
        return shuttleDataService.getAllShuttlesData();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/shuttle-data/{id}")
    public void updateShuttleData(@PathVariable("id") long id, @Valid @RequestBody ShuttleDataDto dto) {
        shuttleDataService.updateShuttleData(id, dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/shuttle-data/{id}")
    public ShuttleDataDto getShuttleDataById(@PathVariable("id") long id) {
        return shuttleDataService.getShuttleById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/shuttle-data/{id}")
    public void deleteShuttleDataById(@PathVariable("id") long id) {
        shuttleDataService.deleteShuttleDataById(id);
    }

}
