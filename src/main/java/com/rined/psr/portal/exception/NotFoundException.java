package com.rined.psr.portal.exception;

public class NotFoundException extends BaseTemplateException {
    public NotFoundException(String template, Object... args) {
        super(template, args);
    }
}
