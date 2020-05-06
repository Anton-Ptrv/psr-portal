package com.rined.psr.portal.model.dto.fully;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rined.psr.portal.model.viewgroup.ViewGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserDto {

    @JsonProperty("id")
    @NotNull(message = "Id is mandatory!", groups = {ViewGroup.UseExisting.class})
    private Long id;

    @Column(name = "login")
    @NotNull(message = "Login is mandatory!")
    @NotEmpty(message = "Login is mandatory!")
    private String login;

    @Column(name = "fio")
    @NotNull(message = "FIO is mandatory!")
    @NotEmpty(message = "FIO is mandatory!")
    private String fio;

}
