package com.rined.psr.portal.dto.response.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@ToString
@Builder
public class VolunteerFullyResponse {

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
    private ClassificationFullyResponse classification;

    @JsonProperty("equipment")
    private String equipment;

    @JsonProperty("psrListDesc")
    private String psrListDesc;

    @JsonProperty("comment")
    private String comment;

}
