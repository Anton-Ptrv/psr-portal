package com.rined.psr.portal.model.dto.brief;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClassificationBrief {

    @JsonProperty("name")
    @NotNull(message = "Name is mandatory!")
    @NotBlank(message = "Name is mandatory!")
    private String name;

}
