package com.yillint.boot.controller;


import com.yillint.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller



//  JeRebel
@Slf4j
@RestController
public class HelloController {

    //自动注入
    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name){

        log.info("请求进来了。。。。");
        return "Hello, SpringBoot 2!"+"你好"+name;
    }
}
