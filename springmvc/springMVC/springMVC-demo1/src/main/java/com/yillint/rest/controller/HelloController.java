package com.yillint.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//注解了还没有完成，要扫描加载到这个类
public class HelloController {


    @RequestMapping("/")
    public String index(){

        return "index";
    }


    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }
}
