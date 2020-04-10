package com.rined.psr.portal.dto.brief;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PsrListRegistrationBrief {
    // mandatory fields?
    @JsonProperty("id")
    private Long id;

    @JsonProperty("psr")
    private PsrBrief psr;

    @JsonProperty("volunteer")
    private VolunteerBrief volunteer;

    @JsonProperty("volunteerStatus")
    private VolunteerStatusBrief volunteerStatus;

    @JsonProperty("shuttleNum")
    private String shuttleNum;

    @JsonProperty("departureAddress")
    private String departureAddress;

    @JsonProperty("startVolunteerTime")
    private LocalDateTime startVolunteerTime;

    @JsonProperty("endVolunteerTime")
    private LocalDateTime endVolunteerTime;

}
