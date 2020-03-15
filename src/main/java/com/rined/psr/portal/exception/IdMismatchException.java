package com.rined.psr.portal.exception;

public class IdMismatchException extends BaseTemplateException {
    public IdMismatchException(String template, Object... args) {
        super(template, args);
    }
}
