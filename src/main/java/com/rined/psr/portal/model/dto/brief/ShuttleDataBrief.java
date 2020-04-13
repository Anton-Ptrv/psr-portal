package com.rined.psr.portal.model.dto.brief;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rined.psr.portal.model.dto.fully.ShuttleDto;
import com.rined.psr.portal.model.dto.fully.VolunteerDto;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShuttleDataBrief {

    @JsonProperty("shuttle")
    @NotNull(message = "Shuttle is mandatory!")
    private ShuttleDto shuttle;

    @JsonProperty("shuttleOwner")
    @NotNull(message = "Shuttle owner is mandatory!")
    private VolunteerDto shuttleOwner;

    @JsonProperty("driver")
    private Boolean driver;

}
