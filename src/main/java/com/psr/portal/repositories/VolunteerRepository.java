package com.psr.portal.repositories;

import com.psr.portal.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Long, Volunteer> {
}
