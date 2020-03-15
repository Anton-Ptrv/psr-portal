package com.rined.psr.portal.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PsrStateDto {

    @JsonProperty("id")
    @NotNull(message = "Id is mandatory!")
    private long id;

    @JsonProperty("name")
    @NotNull(message = "PSR state name is mandatory!")
    @NotEmpty(message = "PSR state name is mandatory!")
    private String name;

}
