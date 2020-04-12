package com.rined.psr.portal.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleResponse<T> {

    @JsonProperty("result")
    private final T result;

    public static <T> SimpleResponse<T> of(T data){
        return new SimpleResponse<>(data);
    }
}
