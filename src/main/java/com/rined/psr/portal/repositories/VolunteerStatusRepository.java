package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.VolunteerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VolunteerStatusRepository extends JpaRepository<VolunteerStatus, Long> {

    Optional<VolunteerStatus> findVolunteerStatusById(long id);

}
