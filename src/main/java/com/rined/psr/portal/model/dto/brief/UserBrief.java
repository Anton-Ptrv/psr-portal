package com.rined.psr.portal.model.dto.brief;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserBrief {

    @JsonProperty("login")
    @NotNull(message = "Login is mandatory!")
    @NotBlank(message = "Login is mandatory!")
    private String login;

    @JsonProperty("password")
    @NotNull(message = "Password is mandatory!")
    @NotBlank(message = "Password is mandatory!")
    private String password;

    @JsonProperty("fio")
    @NotNull(message = "FIO is mandatory!")
    @NotBlank(message = "FIO is mandatory!")
    private String fio;

}
