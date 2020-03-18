package com.rined.psr.portal.controller;

import com.rined.psr.portal.dto.brief.ClassificationBriefDto;
import com.rined.psr.portal.dto.fully.ClassificationDto;
import com.rined.psr.portal.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
public abstract class BaseController<Dto, Brief, ID, Service extends BaseService<Dto, Brief, ID>> {
    private final Service service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addClassification(@Valid @RequestBody Brief brief) {
        service.add(brief);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Dto> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateClassification(@PathVariable("id") ID id,
                                     @Valid @RequestBody Dto classificationDto) {
        service.update(id, classificationDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dto getClassificationById(@PathVariable("id") ID id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClassificationById(@PathVariable("id") ID id){
        service.deleteById(id);
    }

}
