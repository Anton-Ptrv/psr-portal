package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.Volunteer;

import java.util.List;

public interface VolunteerRepository extends BaseRepository<Volunteer, Long> {

    boolean existsByPhone(String phone);

    boolean existsByTelegramLogin(String telegramLogin);

    List<Volunteer> findVolunteersByIdIn(List<Long> ids);

}
