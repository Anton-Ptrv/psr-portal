package com.rined.psr.portal.model.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ShuttleDataDto {

    @JsonProperty("id")
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
