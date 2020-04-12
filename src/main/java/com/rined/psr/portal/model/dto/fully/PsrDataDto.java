package com.rined.psr.portal.model.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PsrDataDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("psr")
    private PsrDto psr;

    @JsonProperty("station")
    private String station;

    @JsonProperty("psrLeader")
    private UserDto psrLeader;

    @JsonProperty("psrRegisteredUser")
    private UserDto psrRegisteredUser;

    @JsonProperty("objectInfo")
    private String objectInfo;

    @JsonProperty("content")
    private String content;

    @JsonProperty("photo")
    private byte[] photo;
}
