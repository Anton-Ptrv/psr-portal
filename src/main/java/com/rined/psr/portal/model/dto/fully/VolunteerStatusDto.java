package com.rined.psr.portal.model.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class VolunteerStatusDto {

    @JsonProperty("id")
    @NotNull(message = "Id is mandatory!")
    private Long id;

    @JsonProperty("name")
    @NotNull(message = "Volunteer status name is mandatory!")
    @NotEmpty(message = "Volunteer status name is mandatory!")
    private String name;

}
