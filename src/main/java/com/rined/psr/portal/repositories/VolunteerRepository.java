package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

    boolean existsByPhone(String phone);

    boolean existsByTelegramLogin(String telegramLogin);

    boolean existsById(long id);

    Optional<Volunteer> findVolunteerById(long id);

}
