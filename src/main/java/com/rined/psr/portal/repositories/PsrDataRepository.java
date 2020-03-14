package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.PsrData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsrDataRepository extends JpaRepository<PsrData, Long> {
    
}
