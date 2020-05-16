package com.rined.psr.portal.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {

    @JsonProperty("ids")
    @NotNull(message = "Volunteer id list is mandatory!")
    @NotEmpty(message = "Volunteer id list is mandatory!")
    private List<Long> ids;

    @JsonProperty("message")
    @NotNull(message = "Notification message is mandatory!")
    @NotEmpty(message = "Notification message id list is mandatory!")
    private String message;

    @JsonProperty("reply_markup")
    private List<ReplyMarkup> replyMarkup;

    public NotificationRequest(List<Long> ids, String message) {
        this.ids = ids;
        this.message = message;
    }
}
