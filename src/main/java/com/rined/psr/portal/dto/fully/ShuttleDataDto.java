package com.rined.psr.portal.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShuttleDataDto {

    @JsonProperty("id")
    @NotNull(message = "Id is mandatory!")
    private Long id;

    @Column(name = "shuttle")
    @NotNull(message = "Shuttle is mandatory!")
    private ShuttleDto shuttle;

    @Column(name = "volunteer")
    @NotNull(message = "Volunteer is mandatory!")
    private VolunteerDto shuttleOwner;

    @Column(name = "driver")
    private Boolean driver;

}
