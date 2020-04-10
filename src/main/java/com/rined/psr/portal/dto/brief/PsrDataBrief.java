package com.rined.psr.portal.dto.brief;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PsrDataBrief {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("psr")
    private PsrBrief psr;

    @JsonProperty("station")
    private String station;

    @JsonProperty("psrLeader")
    private UserBrief psrLeader;

    @JsonProperty("psrRegistration")
    private UserBrief psrRegisteredUser;

    @JsonProperty("objectInfo")
    private String objectInfo;

    @JsonProperty("content")
    private String content;

    @JsonProperty("photo")
    private byte[] photo;

}
