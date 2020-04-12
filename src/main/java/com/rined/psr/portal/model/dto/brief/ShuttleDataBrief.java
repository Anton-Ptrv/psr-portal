package com.rined.psr.portal.model.dto.brief;

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

    @NotNull(message = "Shuttle is mandatory!")
    private ShuttleDto shuttle;

    @NotNull(message = "Shuttle owner is mandatory!")
    private VolunteerDto shuttleOwner;

    private Boolean driver;

}
