package com.rined.psr.portal.model.notifications;

import lombok.Getter;

import java.util.Map;
import java.util.function.Consumer;

public class PreparedConsumeNotification {
    @Getter
    private final String url;
    private final Consumer<Object> consumer;
    private final Map<String, Object> parameters;

    public PreparedConsumeNotification(String url, Consumer<Object> consumer, Map<String, Object> parameters) {
        this.url = url;
        this.consumer = consumer;
        this.parameters = parameters;
    }

    public Map<String, ?> prepareAndBuild(Object value) {
        consumer.accept(value);
        return parameters;
    }
}
