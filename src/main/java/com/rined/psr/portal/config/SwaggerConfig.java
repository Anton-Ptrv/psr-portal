package com.rined.psr.portal.config;

import com.rined.psr.portal.controller.ClassificationController;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Controller
@Configuration
@EnableSwagger2
@Profile("!production")
@RequiredArgsConstructor
public class SwaggerConfig implements WebMvcConfigurer {
    /**
     * /swagger/swagger-ui.html
     */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(ClassificationController.class.getPackage().getName()))
                .build();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/swagger", "/swagger/swagger-ui.html");
        registry.addRedirectViewController("/swagger/", "/swagger/swagger-ui.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger/**")
                .addResourceLocations("classpath:/META-INF/resources/");
    }

    @RequestMapping("/swagger/v2/api-docs")
    public String doc() {
        return "forward:/v2/api-docs";
    }

    @RequestMapping("/swagger/swagger-resources/configuration/ui")
    public String ui() {
        return "forward:/swagger-resources/configuration/ui";
    }

    @RequestMapping("/swagger/swagger-resources")
    public String resource() {
        return "forward:/swagger-resources";
    }

    @RequestMapping("/swagger/swagger-resources/configuration/security")
    public String security() {
        return "forward:/swagger-resources/configuration/security";
    }
}
