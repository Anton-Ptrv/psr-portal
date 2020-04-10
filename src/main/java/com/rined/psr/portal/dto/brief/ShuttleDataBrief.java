package com.rined.psr.portal.dto.brief;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShuttleDataBrief {

    @JsonProperty("id")
    private Long id;

    @NotNull(message = "Shuttle is mandatory!")
    private ShuttleBrief shuttle;

    @NotNull(message = "Shuttle owner is mandatory!")
    private VolunteerBrief shuttleOwner;

    private Boolean driver;

}
