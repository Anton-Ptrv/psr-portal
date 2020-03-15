package com.rined.psr.portal.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class VolunteerDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("fio")
    private String fio;

    @JsonProperty("sex")
    private boolean sex;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("login")
    private String login;

    @JsonProperty("classification")
    private ClassificationDto classification;

    @JsonProperty("equipment")
    private String equipment;

    @JsonProperty("psrListDesc")
    private String psrListDesc;

    @JsonProperty("comment")
    private String comment;

}
