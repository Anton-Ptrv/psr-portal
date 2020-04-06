package com.rined.psr.portal.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.net.URI;

@Component
@Profile("dev")
public class ApplicationStartRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.setProperty("java.awt.headless", Boolean.toString(false));
        Desktop.getDesktop().browse(URI.create("http://localhost:8080/swagger-ui.html"));
    }
}
