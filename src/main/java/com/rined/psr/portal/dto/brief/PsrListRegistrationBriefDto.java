package com.rined.psr.portal.dto.brief;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PsrListRegistrationBriefDto {
    // mandatory fields?

    @JsonProperty("psr")
    private PsrBriefDto psr;

    @JsonProperty("volunteer")
    private VolunteerBriefDto volunteer;

    @JsonProperty("volunteerStatus")
    private VolunteerStatusBriefDto volunteerStatus;

    @JsonProperty("shuttleNum")
    private String shuttleNum;

    @JsonProperty("departureAddress")
    private String departureAddress;

    @JsonProperty("startVolunteerTime")
    private LocalDateTime startVolunteerTime;

    @JsonProperty("endVolunteerTime")
    private LocalDateTime endVolunteerTime;

}
