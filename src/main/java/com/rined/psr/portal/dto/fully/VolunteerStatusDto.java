package com.rined.psr.portal.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerStatusDto {

    @JsonProperty("id")
    @NotNull(message = "Id is mandatory!")
    private long id;

    @JsonProperty("name")
    @NotNull(message = "Volunteer status name is mandatory!")
    @NotEmpty(message = "Volunteer status name is mandatory!")
    private String name;

}
