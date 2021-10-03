package com.yillint.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  //作为配置类，替代配置文件
@ComponentScan(basePackages = {"com.yillint"})
public class SpringConfig {


}
