package com.yillint.boot.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.env.ConfigurableEnvironment;

public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    private SpringApplication application;
    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
    }


    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("MyApplicationRunListener...starting....");
    }


    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("MyApplicationRunListener...environmentPrepared....");
    }


    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("MyApplicationRunListener...contextPrepared....");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("MyApplicationRunListener...contextLoaded....");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("MyApplicationRunListener...started....");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("MyApplicationRunListener...running....");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("MyApplicationRunListener...failed....");
    }
}
