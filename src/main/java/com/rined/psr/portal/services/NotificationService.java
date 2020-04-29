package com.rined.psr.portal.services;

import com.rined.psr.portal.model.dto.TelegramResponse;
import com.rined.psr.portal.model.dto.request.NotificationRequest;

import java.util.List;

public interface NotificationService {

    List<TelegramResponse> notify(NotificationRequest notification);

}
