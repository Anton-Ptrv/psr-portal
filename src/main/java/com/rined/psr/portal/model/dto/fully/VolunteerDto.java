package com.rined.psr.portal.model.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class VolunteerDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("fio")
    private String fio;

    @JsonProperty("sex")
    private Boolean sex;

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
