package com.rined.psr.portal.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerStatusDto {

    @NotNull
    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

}
