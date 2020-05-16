package com.rined.psr.portal.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReplyMarkup {

    @JsonProperty("text")
    private String text;

    @JsonProperty("callback_data")
    private String callbackData;

}
