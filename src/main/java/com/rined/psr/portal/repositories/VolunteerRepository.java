package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

}
