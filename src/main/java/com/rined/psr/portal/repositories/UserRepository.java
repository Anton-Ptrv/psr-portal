package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User, Long> {

    boolean existsByLogin(String login);

    Optional<User> findByLogin(String login);

}
