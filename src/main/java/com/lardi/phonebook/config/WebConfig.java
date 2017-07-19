package com.lardi.phonebook.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;





@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       registry.addRedirectViewController("/", "/site/index");

        registry.addViewController("/site/index");
//                .setViewName("site/index");
        registry.addViewController("/")
               .setViewName("site/index");
        registry.addViewController("site/notedata")
                .setViewName("notedata");
        registry.addViewController("site/notes")
                .setViewName("notes");
    }

}







//@Bean
//public ViewResolver viewResolver() {
//    UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
//    urlBasedViewResolver.setViewClass(JstlView.class);
//    urlBasedViewResolver.setPrefix("/WEB-INF/templates/");
//    urlBasedViewResolver.setSuffix(".jspx");
//
//    return urlBasedViewResolver;
//}