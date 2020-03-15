package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.PsrState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PsrStateRepository extends JpaRepository<PsrState, Long> {

    Optional<PsrState> findPsrStateById(long id);

}
