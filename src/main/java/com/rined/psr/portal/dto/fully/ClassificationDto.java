package com.rined.psr.portal.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClassificationDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

}
