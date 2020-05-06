package com.rined.psr.portal.model.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rined.psr.portal.model.viewgroup.ViewGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PsrDataDto {

    @JsonProperty("id")
    @NotNull(message = "Id is mandatory!", groups = {ViewGroup.UseExisting.class})
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
