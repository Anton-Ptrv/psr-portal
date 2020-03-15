package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.ShuttleData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShuttleDataRepository extends JpaRepository<ShuttleData, Long> {

    Optional<ShuttleData> findShuttleById(long id);

}
