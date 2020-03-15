package com.rined.psr.portal.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @JsonProperty("id")
    @NotNull(message = "Id is mandatory!")
    private long id;

    @Column(name = "login")
    @NotNull(message = "Login is mandatory!")
    @NotEmpty(message = "Login is mandatory!")
    private String login;

    @Column(name = "password")
    @NotNull(message = "Password is mandatory!")
    @NotEmpty(message = "Password is mandatory!")
    private String password;

    @Column(name = "fio")
    @NotNull(message = "FIO is mandatory!")
    @NotEmpty(message = "FIO is mandatory!")
    private String fio;

}
