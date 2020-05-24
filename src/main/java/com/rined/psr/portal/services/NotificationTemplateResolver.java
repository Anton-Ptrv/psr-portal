package com.rined.psr.portal.services;

import com.rined.psr.portal.model.dto.request.NotificationRequest;
import com.rined.psr.portal.model.notifications.PreparedConsumeNotification;

public interface NotificationTemplateResolver {

    PreparedConsumeNotification resolve(NotificationRequest request);

}
