package com.rined.psr.portal.model.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class ClassificationDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

}
