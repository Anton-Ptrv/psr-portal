package com.rined.psr.portal.services;

import java.util.List;

public interface BaseService <Dto, Brief, ID>{

    void add(Brief brief);

    List<Dto> getAll();

    void update(ID id, Dto dto);

    Dto getById(ID id);

    void deleteById(ID id);
}
