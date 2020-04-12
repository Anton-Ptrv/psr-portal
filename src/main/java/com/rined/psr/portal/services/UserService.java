package com.rined.psr.portal.services;

import com.rined.psr.portal.model.converters.UserConverter;
import com.rined.psr.portal.model.dto.brief.UserBrief;
import com.rined.psr.portal.model.dto.fully.UserDto;
import com.rined.psr.portal.exception.AlreadyExistsException;
import com.rined.psr.portal.model.User;
import com.rined.psr.portal.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserDto, UserBrief, User, Long, UserRepository, UserConverter> {

    public UserService(UserConverter converter, UserRepository repository) {
        super(converter, repository);
    }

    @Override
    public void add(UserBrief brief) {
        String login = brief.getLogin();
        if (repository.existsByLogin(login)) {
            throw new AlreadyExistsException("User with login '{}' already exists", login);
        }
        repository.save(converter.briefToBase(brief));
    }

}
