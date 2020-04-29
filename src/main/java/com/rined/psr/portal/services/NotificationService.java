package com.rined.psr.portal.services;

import com.rined.psr.portal.model.dto.request.NotificationRequest;

public interface NotificationService {

    void notify(NotificationRequest notification);

}
