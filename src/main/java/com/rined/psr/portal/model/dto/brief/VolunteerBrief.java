package com.rined.psr.portal.model.dto.brief;

import com.rined.psr.portal.validation.PhoneNumber;
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
    @NotBlank(message = "Fio is mandatory!")
    private String fio;

    @NotNull
    @NotBlank(message = "Phone is mandatory")
    @PhoneNumber(message = "Invalid volunteer phone number!")
    private String phone;

    @NotNull(message = "Login is mandatory!")
    @NotBlank(message = "Login is mandatory!")
    private String login;

    private Boolean sex;

}
