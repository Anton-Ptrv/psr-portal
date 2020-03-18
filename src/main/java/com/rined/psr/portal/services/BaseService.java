package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.BaseConverter;
import com.rined.psr.portal.exception.NotFoundException;
import com.rined.psr.portal.repositories.BaseRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseService<Dto, Brief, Bean, ID,
        Repository extends BaseRepository<Bean, ID>,
        Converter extends BaseConverter<Bean, Dto, Brief>> {
    private final Converter converter;
    private final Repository repository;

    public void add(Brief brief) {
        repository.save(converter.briefToBase(brief));
    }

    public List<Dto> getAll() {
        return converter.baseToDtoList(repository.findAll());
    }

    public void update(ID id, Dto dto) {
        Bean bean = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Classification with id '%d' not found!", id));
        repository.save(converter.mergeDtoAndBase(bean, dto));
    }

    public Dto getById(ID id) {
        return repository.findById(id)
                .map(converter::baseToDto)
                .orElseThrow(() -> new NotFoundException("Classification with id '%d' not found!", id));
    }

    public void deleteById(ID id) {
        if (!repository.existsById(id))
            throw new NotFoundException("Classification with id '%d' not found!", id);
        repository.deleteById(id);
    }
}
