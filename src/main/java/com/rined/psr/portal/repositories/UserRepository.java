package com.rined.psr.portal.repositories;

import com.rined.psr.portal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
