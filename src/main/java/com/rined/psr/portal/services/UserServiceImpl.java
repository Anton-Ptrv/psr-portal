package com.rined.psr.portal.services;

import com.rined.psr.portal.converters.BaseConverter;
import com.rined.psr.portal.dto.brief.UserBrief;
import com.rined.psr.portal.dto.fully.UserDto;
import com.rined.psr.portal.exception.AlreadyExistsException;
import com.rined.psr.portal.exception.NotFoundException;
import com.rined.psr.portal.model.User;
import com.rined.psr.portal.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BaseConverter<User, UserDto, UserBrief> converter;

    @Override
    public void addUser(UserBrief briefDto) {
        log.trace("Add user {}", userRepository);
        String login = briefDto.getLogin();
        if (userRepository.existsByLogin(login)) {
            throw new AlreadyExistsException("User with login '{}' already exists", login);
        }
        userRepository.save(converter.briefToBase(briefDto));
    }

    @Override
    public List<UserDto> getAllUsers() {
        log.trace("All available users");
        return converter.baseToDtoList(userRepository.findAll());
    }

    @Override
    public void updateUser(long id, UserDto dto) {
        log.trace("Update user {} with id {}", dto, id);
        User user = userRepository.findUserById(id)
                .orElseThrow(() -> new NotFoundException("User with id '%d' not found!", id));
        userRepository.save(converter.mergeDtoAndBase(user, dto));
    }

    @Override
    public UserDto getUserById(long id) {
        log.trace("Get volunteer status by id {}", id);
        return userRepository.findUserById(id)
                .map(converter::baseToDto)
                .orElseThrow(() -> new NotFoundException("User with id '%d' not found!", id));
    }

    @Override
    public void deleteUserById(long id) {
        log.trace("Delete user by id {}", id);
        if (!userRepository.existsById(id))
            throw new NotFoundException("User with id '%d' not found!", id);
        userRepository.deleteById(id);
    }
}
