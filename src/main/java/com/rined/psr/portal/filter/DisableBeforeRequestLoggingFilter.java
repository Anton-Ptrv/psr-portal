package com.rined.psr.portal.filter;

import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

public class DisableBeforeRequestLoggingFilter extends CommonsRequestLoggingFilter {

    /**
     * disable before request logging
     */
    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        // stub
    }

}
