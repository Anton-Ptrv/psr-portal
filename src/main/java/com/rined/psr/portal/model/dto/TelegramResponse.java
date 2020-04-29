package com.rined.psr.portal.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelegramResponse {

    @JsonProperty("ok")
    private boolean ok;

    @JsonProperty("result")
    private Map<String, Object> result;

}
