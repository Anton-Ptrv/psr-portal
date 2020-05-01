package com.rined.psr.portal.controller;

import com.rined.psr.portal.model.dto.TelegramResponse;
import com.rined.psr.portal.model.dto.request.NotificationRequest;
import com.rined.psr.portal.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/psr/api/notification")
public class NotificationController {
    private final NotificationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TelegramResponse> notify(@Valid @RequestBody NotificationRequest notification) {
        return service.notify(notification);
    }

}
