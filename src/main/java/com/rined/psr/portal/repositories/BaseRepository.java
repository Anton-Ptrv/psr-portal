package com.rined.psr.portal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<Bean, ID> extends JpaRepository<Bean, ID> {

    Optional<Bean> findById(ID id);

}
