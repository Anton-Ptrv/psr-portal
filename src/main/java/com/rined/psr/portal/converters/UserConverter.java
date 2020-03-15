package com.rined.psr.portal.converters;

import com.rined.psr.portal.dto.brief.UserBriefDto;
import com.rined.psr.portal.dto.fully.UserDto;
import com.rined.psr.portal.exception.IdMismatchException;
import com.rined.psr.portal.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter implements FullyConverter<User, UserDto, UserBriefDto> {

    @Override
    public User briefToBase(UserBriefDto briefDto) {
        return new User(briefDto.getLogin(), briefDto.getPassword(), briefDto.getFio());
    }

    @Override
    public User mergeDtoAndBase(User base, UserDto userDto) {
        if (base.getId() != userDto.getId()) {
            throw new IdMismatchException("Path variable id and query object id mismatch!");
        }
        return dtoToBase(userDto);
    }

    @Override
    public UserDto baseToDto(User user) {
        return new UserDto(user.getId(), user.getLogin(), user.getPassword(), user.getFio());
    }

    @Override
    public List<UserDto> bastToDtoList(List<User> users) {
        return users.stream().map(this::baseToDto).collect(Collectors.toList());
    }

    @Override
    public User dtoToBase(UserDto userDto) {
        return new User(userDto.getId(), userDto.getLogin(), userDto.getPassword(), userDto.getFio());
    }
}
