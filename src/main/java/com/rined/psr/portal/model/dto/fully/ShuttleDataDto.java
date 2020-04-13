package com.rined.psr.portal.model.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rined.psr.portal.model.viewgroup.ViewGroup;
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
    @NotNull(message = "Id is mandatory!", groups = {ViewGroup.UseExisting.class})
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
