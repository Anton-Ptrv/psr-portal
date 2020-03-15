package com.rined.psr.portal.controller;

import com.rined.psr.portal.dto.brief.UserBriefDto;
import com.rined.psr.portal.dto.fully.UserDto;
import com.rined.psr.portal.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@Valid @RequestBody UserBriefDto briefDto) {
        userService.addUser(briefDto);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable("id") long id, @Valid @RequestBody UserDto dto) {
        userService.updateUser(id, dto);
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }


}
