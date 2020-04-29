package com.rined.psr.portal.controller;

import com.rined.psr.portal.model.dto.request.NotificationRequest;
import com.rined.psr.portal.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/psr/api/notificaiton")
public class NotificationController {
    private final NotificationService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void notify(NotificationRequest notification) {
        service.notify(notification);
    }

}
