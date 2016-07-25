package com.odde.bbuddy;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/add_budget_for_month").setViewName("add_budget_for_month");


        // add AccountStatus viewController
        registry.addViewController("/get_accountStatus").setViewName("AccountStatus");
        registry.addViewController("/create_accountStatus").setViewName("save_accountStatus");



    }

}