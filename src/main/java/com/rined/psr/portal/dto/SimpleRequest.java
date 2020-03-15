package com.rined.psr.portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SimpleRequest<T> {

    @NotNull
    @JsonProperty("data")
    private T data;

}
