package com.rined.psr.portal.exception;

public class BaseTemplateException extends RuntimeException {
    public BaseTemplateException(String template, Object... args) {
        super(String.format(template, args));
    }
}
