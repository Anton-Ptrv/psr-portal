package com.rined.psr.portal.dto.brief;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShuttleDataBrief {

    @NotNull(message = "Shuttle is mandatory!")
    private ShuttleBrief shuttle;

    @NotNull(message = "Shuttle owner is mandatory!")
    private VolunteerBrief shuttleOwner;

    private Boolean driver;

}
