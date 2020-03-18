package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.User;

public interface UserRepository extends BaseRepository<User, Long> {

    boolean existsByLogin(String login);

}
