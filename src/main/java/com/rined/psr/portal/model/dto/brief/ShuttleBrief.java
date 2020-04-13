package com.rined.psr.portal.model.dto.brief;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.rined.psr.portal.model.dto.fully.PsrDto;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShuttleBrief {

    @JsonProperty("registeredOnPsr")
    @NotNull(message = "Psr is mandatory!")
    @NotBlank(message = "Psr is mandatory!")
    private PsrDto registeredOnPsr;

    @JsonProperty("auto")
    @NotNull(message = "Auto is mandatory!")
    @NotBlank(message = "Auto is mandatory!")
    private String auto;

}
