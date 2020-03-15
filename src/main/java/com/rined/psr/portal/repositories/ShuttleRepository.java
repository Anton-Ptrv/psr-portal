package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.Shuttle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShuttleRepository extends JpaRepository<Shuttle, Long> {

    Optional<Shuttle> findShuttleById(long id);

}
