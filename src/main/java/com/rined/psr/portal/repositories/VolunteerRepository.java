package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.Volunteer;

public interface VolunteerRepository extends BaseRepository<Volunteer, Long> {

    boolean existsByPhone(String phone);

    boolean existsByTelegramLogin(String telegramLogin);

}
