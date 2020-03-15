package com.rined.psr.portal.dto.brief;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShuttleDataBriefDto {

    @NotNull(message = "Shuttle is mandatory!")
    private ShuttleBriefDto shuttle;

    @NotNull(message = "Shuttle owner is mandatory!")
    private VolunteerBriefDto shuttleOwner;

    private boolean driver;

}
