package com.rined.psr.portal.model.dto.brief;


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

    @NotNull(message = "Psr is mandatory!")
    @NotBlank(message = "Psr is mandatory!")
    private PsrDto registeredOnPsr;

    @NotNull(message = "Auto is mandatory!")
    @NotBlank(message = "Auto is mandatory!")
    private String auto;

}
