package com.rined.psr.portal.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rined.psr.portal.model.PsrState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PsrDto {

    @JsonProperty("id")
    @NotNull(message = "Id is mandatory!")
    private Long id;

    @JsonProperty("name")
    @NotNull(message = "Name is mandatory!")
    @NotEmpty(message = "Name is mandatory!")
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
