package com.rined.psr.portal.model.dto.brief;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rined.psr.portal.model.dto.fully.PsrDto;
import com.rined.psr.portal.model.dto.fully.UserDto;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PsrDataBrief {

    @JsonProperty("psr")
    private PsrDto psr;

    @JsonProperty("station")
    private String station;

    @JsonProperty("psrLeader")
    private UserDto psrLeader;

    @JsonProperty("psrRegistration")
    private UserDto psrRegisteredUser;

    @JsonProperty("objectInfo")
    private String objectInfo;

    @JsonProperty("content")
    private String content;

    @JsonProperty("photo")
    private byte[] photo;

}
