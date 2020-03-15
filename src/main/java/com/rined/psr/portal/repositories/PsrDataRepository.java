package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.PsrData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PsrDataRepository extends JpaRepository<PsrData, Long> {

    Optional<PsrData> getPsrDataById(long id);

}
