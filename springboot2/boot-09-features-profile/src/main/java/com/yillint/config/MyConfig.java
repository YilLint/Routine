package com.yillint.config;

import com.yillint.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MyConfig {

    @Profile("prod")
    @Bean
    public Color red(){
        return  new Color();
    }

    @Profile("test")
    @Bean
    public Color green(){
        return  new Color();
    }

}
