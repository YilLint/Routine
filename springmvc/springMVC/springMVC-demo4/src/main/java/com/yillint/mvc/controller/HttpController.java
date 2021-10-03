package com.yillint.mvc.controller;

import com.yillint.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HttpController {


    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody:" + requestBody);
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        //requestEntity是整个请求的报文的信息
        System.out.println("请求头:" + requestEntity.getHeaders());
        System.out.println("请求体:" + requestEntity.getBody());
        return "success";
    }

    //springMVC响应浏览器数据，就可参数中添加response，在web有转发，重定向，response.getWriter().println()
    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello,response");
    }
    
    @RequestMapping("/testResponseBody")
    @ResponseBody       //那么原来的返回的值是作为视图，现在就变成了响应内容。
    public String testResponseBody(){
        return "success66";
    }

    /**
     * 浏览器是不认识java对象的，所以肯定会报错的（HttpMessageNotWritableException），要转为为json，这是
     * 一种交换格式。
     * @return
     */
    @RequestMapping("/testResponseUser")
    @ResponseBody       //那么原来的返回的值是作为视图，现在就变成了响应内容。
    /**
     * responseBody处理返回对象将会将对象转换为json对象，
     * 1.引入依赖
     * 2.开启mvc注解驱动
     * 3.标识注解
     * 4.将java对象作为返回值，将会返回json格式的的字符串
     */
    public User testResponseUser(){
        return new User(1001,"admin","123",18,"男");
    }


    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username, String password){
        System.out.println(username+","+password);
        return "hello,axios";
    }

}
