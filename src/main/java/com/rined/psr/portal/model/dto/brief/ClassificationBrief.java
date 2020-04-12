package com.rined.psr.portal.model.dto.brief;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClassificationBrief {

    @NotNull(message = "Name is mandatory!")
    @NotBlank(message = "Name is mandatory!")
    private String name;

}
