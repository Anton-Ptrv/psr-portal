package com.rined.psr.portal.controller;

import com.rined.psr.portal.model.converters.UserConverter;
import com.rined.psr.portal.model.dto.brief.UserBrief;
import com.rined.psr.portal.model.dto.fully.UserDto;
import com.rined.psr.portal.model.User;
import com.rined.psr.portal.repositories.UserRepository;
import com.rined.psr.portal.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/psr/api/users")
public class UserController extends BaseController<UserDto, UserBrief, User, Long, UserRepository, UserConverter,
        UserService> {

    public UserController(UserService service) {
        super(service);
    }

}