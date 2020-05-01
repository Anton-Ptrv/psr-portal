package com.rined.psr.portal.services;

import com.rined.psr.portal.exception.NotFoundException;
import com.rined.psr.portal.model.converters.BaseConverter;
import com.rined.psr.portal.repositories.BaseRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseService<Dto, Brief, Bean, ID,
        Repository extends BaseRepository<Bean, ID>,
        Converter extends BaseConverter<Bean, Dto, Brief>> {

    final Converter converter;
    final Repository repository;

    public abstract Bean cascadeSave(Bean bean);

    public void create(Brief brief) {
        cascadeSave(converter.briefToBase(brief));
    }

    public List<Dto> getAll() {
        return converter.baseToDtoList(repository.findAll());
    }

    public void update(ID id, Dto dto) {
        Bean bean = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Object with id '%d' not found!", id));
        Bean entity = converter.mergeDtoAndBase(bean, dto);
        repository.save(entity);
    }

    public Dto getById(ID id) {
        return repository.findById(id)
                .map(converter::baseToDto)
                .orElseThrow(() -> new NotFoundException("Object with id '%d' not found!", id));
    }

    public void deleteById(ID id) {
        if (!repository.existsById(id))
            throw new NotFoundException("Object with id '%d' not found!", id);
        repository.deleteById(id);
    }

}
