package com.rined.psr.portal.model.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rined.psr.portal.model.viewgroup.ViewGroup;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class VolunteerDto {

    @JsonProperty("id")
    @NotNull(message = "Id is mandatory!", groups = {ViewGroup.UseExisting.class})
    private Long id;

    @JsonProperty("fio")
    private String fio;

    @JsonProperty("sex")
    private Boolean sex;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("login")
    private String login;

    @JsonProperty("classification")
    private ClassificationDto classification;

    @JsonProperty("equipment")
    private String equipment;

    @JsonProperty("psrListDesc")
    private String psrListDesc;

    @JsonProperty("comment")
    private String comment;

}
