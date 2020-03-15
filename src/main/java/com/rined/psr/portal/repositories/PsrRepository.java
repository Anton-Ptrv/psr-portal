package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.Psr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PsrRepository extends JpaRepository<Psr, Long> {

    Optional<Psr> findPsrById(long id);

}
