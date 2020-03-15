package com.rined.psr.portal.exception;

public class AlreadyExistsException extends BaseTemplateException {
    public AlreadyExistsException(String template, Object... args) {
        super(template, args);
    }
}
