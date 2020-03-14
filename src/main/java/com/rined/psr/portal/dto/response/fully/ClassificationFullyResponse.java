package com.rined.psr.portal.dto.response.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClassificationFullyResponse {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

}
