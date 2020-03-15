package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByLogin(String login);

    Optional<User> findUserById(long id);
}
