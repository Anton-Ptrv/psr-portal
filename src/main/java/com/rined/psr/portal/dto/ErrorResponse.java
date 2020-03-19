package com.rined.psr.portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {

    @JsonProperty("reason")
    private String reason;

    @JsonProperty("description")
    private String description;

    public static ErrorResponse of(String text, Exception e) {
        return new ErrorResponse(text, e.getMessage());
    }
}
