package com.rined.psr.portal.model.dto.brief;

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

    @NotNull
    @JsonProperty("fio")
    @NotBlank(message = "Fio is mandatory!")
    private String fio;

    @NotNull
    @JsonProperty("phone")
    @NotBlank(message = "Phone is mandatory")
    @PhoneNumber(message = "Invalid volunteer phone number!")
    private String phone;

    @JsonProperty("login")
    @NotNull(message = "Login is mandatory!")
    @NotBlank(message = "Login is mandatory!")
    private String login;

    @JsonProperty("sex")
    private Boolean sex;

    @JsonProperty("chatId")
    private Long chatId;

    @JsonProperty("userId")
    private Long userId;

}
