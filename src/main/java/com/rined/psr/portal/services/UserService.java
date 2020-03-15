package com.rined.psr.portal.services;

import com.rined.psr.portal.dto.brief.UserBriefDto;
import com.rined.psr.portal.dto.fully.UserDto;

import java.util.List;

public interface UserService {

    void addUser(UserBriefDto briefDto);

    List<UserDto> getAllUsers();

    void updateUser(long id, UserDto dto);

    UserDto getUserById(long id);

    void deleteUserById(long id);

}
