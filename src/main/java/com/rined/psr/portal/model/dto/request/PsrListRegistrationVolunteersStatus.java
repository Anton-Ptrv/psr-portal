package com.rined.psr.portal.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rined.psr.portal.model.dto.fully.VolunteerStatusDto;
import com.rined.psr.portal.model.viewgroup.ViewGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PsrListRegistrationVolunteersStatus {

    @JsonProperty("ids")
    @NotNull(message = "PsrListRegistration id list is mandatory!", groups = {ViewGroup.UseExisting.class})
    @NotEmpty(message = "PsrListRegistration id list is mandatory!", groups = {ViewGroup.UseExisting.class})
    private List<Long> ids;

    @JsonProperty("volunteerStatus")
    @NotNull(message = "VolunteerStatus is mandatory!")
    private VolunteerStatusDto volunteerStatus;

}
