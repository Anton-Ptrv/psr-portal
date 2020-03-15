package com.rined.psr.portal.dto.brief;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PsrDataBriefDto {

    @JsonProperty("psr")
    private PsrBriefDto psr;

    @JsonProperty("station")
    private String station;

    @JsonProperty("psrLeader")
    private UserBriefDto psrLeader;

    @JsonProperty("psrRegistration")
    private UserBriefDto psrRegisteredUser;

    @JsonProperty("objectInfo")
    private String objectInfo;

    @JsonProperty("content")
    private String content;

    @JsonProperty("photo")
    private byte[] photo;

}
