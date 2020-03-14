package com.rined.psr.portal.dto.request.brief;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VolunteerBrief {

    @NotNull
    @NotBlank(message = "Fio is mandatory")
    private String fio;

    @NotNull
    @NotBlank(message = "Phone is mandatory")
    private String phone;

    @NotNull
    @NotBlank(message = "Login is mandatory")
    private String login;

    private boolean sex;

}
