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


//@EnableWebMvc
//@Configuration
//@ComponentScan(basePackages = "com.lardi.phonebook.config")
//public class WebConfig extends WebMvcConfigurerAdapter {
//
//
//    @Bean
//    public TemplateResolver templateResolver(){
//        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
//        templateResolver.setPrefix("../../../resources/templates/site/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//        return templateResolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine()
//    {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        return templateEngine;
//    }
//
//    @Bean
//    public ViewResolver getViewResolver() {
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine());
//        resolver.setOrder(1);
//        return resolver;
//    }
//}



@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       registry.addRedirectViewController("/", "/site/index1");

        registry.addViewController("/site/notes")
                .setViewName("site/notes");
        registry.addViewController("/site/notedata")
                .setViewName("site/notedata");
        registry.addViewController("/site/index1")
                .setViewName("site/index1");
        registry.addViewController("/site/index")
                .setViewName("site/index");
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