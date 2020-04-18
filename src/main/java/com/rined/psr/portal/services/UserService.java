package com.rined.psr.portal.services;

import com.rined.psr.portal.model.converters.UserConverter;
import com.rined.psr.portal.model.dto.brief.UserBrief;
import com.rined.psr.portal.model.dto.fully.UserDto;
import com.rined.psr.portal.exception.AlreadyExistsException;
import com.rined.psr.portal.model.User;
import com.rined.psr.portal.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService extends BaseService<UserDto, UserBrief, User, Long, UserRepository, UserConverter>
        implements UserDetailsService {

    public UserService(UserConverter converter, UserRepository repository) {
        super(converter, repository);
    }

    @Override
    public User cascadeSave(User user) {
        if (Objects.nonNull(user) && Objects.isNull(user.getId()))
            return repository.save(user);
        return user;
    }

    @Override
    public void create(UserBrief brief) {
        String login = brief.getLogin();
        if (repository.existsByLogin(login)) {
            throw new AlreadyExistsException("User with login '{}' already exists", login);
        }
        repository.save(converter.briefToBase(brief));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with login %s not found!", username)));
        System.out.println(user);
        return user;
    }
}
