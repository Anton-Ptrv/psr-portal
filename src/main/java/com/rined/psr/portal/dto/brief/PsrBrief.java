package com.rined.psr.portal.dto.brief;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rined.psr.portal.dto.fully.PsrStateDto;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PsrBrief {

    @JsonProperty("name")
    @NotNull(message = "Psr name is mandatory!")
    @NotBlank(message = "Psr name is mandatory!")
    private String name;

    @JsonProperty("startDate")
    private LocalDate startDate;

    @JsonProperty("endDate")
    private LocalDate endDate;

    @JsonProperty("psrState")
    private PsrStateDto psrState;

    @JsonProperty("comment")
    private String comment;

}
