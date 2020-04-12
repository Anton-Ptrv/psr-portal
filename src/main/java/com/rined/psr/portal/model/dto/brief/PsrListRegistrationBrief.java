package com.rined.psr.portal.model.dto.brief;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rined.psr.portal.model.dto.fully.PsrDto;
import com.rined.psr.portal.model.dto.fully.VolunteerDto;
import com.rined.psr.portal.model.dto.fully.VolunteerStatusDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PsrListRegistrationBrief {

    @JsonProperty("psr")
    private PsrDto psr;

    @JsonProperty("volunteer")
    private VolunteerDto volunteer;

    @JsonProperty("volunteerStatus")
    private VolunteerStatusDto volunteerStatus;

    @JsonProperty("shuttleNum")
    private String shuttleNum;

    @JsonProperty("departureAddress")
    private String departureAddress;

    @JsonProperty("startVolunteerTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startVolunteerTime;

    @JsonProperty("endVolunteerTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endVolunteerTime;

}
