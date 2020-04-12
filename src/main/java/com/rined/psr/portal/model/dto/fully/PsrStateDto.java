package com.rined.psr.portal.model.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PsrStateDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    @NotNull(message = "PSR state name is mandatory!")
    @NotEmpty(message = "PSR state name is mandatory!")
    private String name;

}
