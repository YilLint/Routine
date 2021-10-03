package com.yillint.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//用注解的方式 使其由普通的类变为spring的Ioc的组件
public class TestController {

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }


    @RequestMapping("/test_view")
    public String testView(){
        return "test_view";
    }


    //webinf下面的资源具有安全性，隐藏性，只能通过服务器访问，不能通过浏览器访问
    //转发不能跨域，重定向可以
}
