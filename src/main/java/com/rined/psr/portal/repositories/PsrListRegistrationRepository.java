package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.PsrListRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PsrListRegistrationRepository extends JpaRepository<PsrListRegistration, Long> {

    Optional<PsrListRegistration> findPsrListRegistrationById(long id);

}
