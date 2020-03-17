package com.rined.psr.portal.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PsrListRegistrationDto {

    @JsonProperty("id")
    @NotNull(message = "Id is mandatory!")
    private Long id;

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
    private LocalDateTime startVolunteerTime;

    @JsonProperty("endVolunteerTime")
    private LocalDateTime endVolunteerTime;

}
