package com.rined.psr.portal.services;

import com.rined.psr.portal.dto.brief.UserBrief;
import com.rined.psr.portal.dto.fully.UserDto;

import java.util.List;

public interface UserService {

    void addUser(UserBrief briefDto);

    List<UserDto> getAllUsers();

    void updateUser(long id, UserDto dto);

    UserDto getUserById(long id);

    void deleteUserById(long id);

}
