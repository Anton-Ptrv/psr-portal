package com.rined.psr.portal.model.dto.fully;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rined.psr.portal.model.viewgroup.ViewGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PsrListRegistrationDto {

    @JsonProperty("id")
    @NotNull(message = "Id is mandatory!", groups = {ViewGroup.UseExisting.class})
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startVolunteerTime;

    @JsonProperty("endVolunteerTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endVolunteerTime;

}
