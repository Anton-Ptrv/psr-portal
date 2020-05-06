package com.rined.psr.portal.model.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rined.psr.portal.model.viewgroup.ViewGroup;
import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class ClassificationDto {

    @JsonProperty("id")
    @NotNull(message = "Id is mandatory!", groups = {ViewGroup.UseExisting.class})
    private Long id;

    @JsonProperty("name")
    private String name;

}
