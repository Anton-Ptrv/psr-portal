package com.rined.psr.portal.dto.brief;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShuttleBrief {

    @JsonProperty("id")
    private Long id;

    @NotNull(message = "Psr is mandatory!")
    @NotBlank(message = "Psr is mandatory!")
    private PsrBrief registeredOnPsr;

    @NotNull(message = "Auto is mandatory!")
    @NotBlank(message = "Auto is mandatory!")
    private String auto;

}
