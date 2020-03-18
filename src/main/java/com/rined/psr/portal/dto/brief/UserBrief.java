package com.rined.psr.portal.dto.brief;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserBrief {

    @NotNull(message = "Login is mandatory!")
    @NotBlank(message = "Login is mandatory!")
    private String login;

    @NotNull(message = "Password is mandatory!")
    @NotBlank(message = "Password is mandatory!")
    private String password;

    @NotNull(message = "FIO is mandatory!")
    @NotBlank(message = "FIO is mandatory!")
    private String fio;

}
