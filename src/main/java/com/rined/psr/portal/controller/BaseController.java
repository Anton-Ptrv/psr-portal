package com.rined.psr.portal.controller;

import com.rined.psr.portal.model.converters.BaseConverter;
import com.rined.psr.portal.model.viewgroup.ViewGroup;
import com.rined.psr.portal.repositories.BaseRepository;
import com.rined.psr.portal.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
public abstract class BaseController<Dto, Brief, Bean, ID,
        Repository extends BaseRepository<Bean, ID>,
        Converter extends BaseConverter<Bean, Dto, Brief>,
        Service extends BaseService<Dto, Brief, Bean, ID, Repository, Converter>> {

    final Service service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@Valid @RequestBody Brief brief) {
        service.create(brief);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Dto> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") ID id,
                       @Validated(ViewGroup.UseExisting.class) @RequestBody Dto dto) {
        service.update(id, dto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dto getById(@PathVariable("id") ID id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") ID id) {
        service.deleteById(id);
    }

}