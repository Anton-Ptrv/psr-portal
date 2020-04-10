package com.rined.psr.portal.dto.brief;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id")
    private Long id;

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
