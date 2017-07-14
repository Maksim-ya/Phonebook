package com.lardi.phonebook.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
//public class WebConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp("/WEB-INF/views/", ".jspx");
//    }
//}


@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/site/index");

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