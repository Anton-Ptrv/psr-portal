package com.rined.psr.portal.model.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ShuttleDto {

    @JsonProperty("id")
    @NotNull(message = "Id is mandatory!")
    private Long id;

    @JsonProperty("psr")
    @NotNull(message = "Psr is mandatory!")
    private PsrDto registeredOnPsr;

    @JsonProperty("auto")
    @NotNull(message = "Auto is mandatory!")
    private String auto;

}
