package com.rined.psr.portal.config;

import com.rined.psr.portal.filter.DisableBeforeRequestLoggingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

@Configuration
@Profile("!production")
public class WebConfiguration {

    @Bean
    public AbstractRequestLoggingFilter requestLoggingFilter() {
        AbstractRequestLoggingFilter filter = new DisableBeforeRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludeClientInfo(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(true);
        filter.setAfterMessagePrefix("REQUEST: ");
        return filter;
    }

    @Bean
    public CorsConfigurationSource corsConfiguration() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
