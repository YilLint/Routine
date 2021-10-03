package com.yillint.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {


    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户信息");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(@PathVariable("id")Integer id){
        System.out.println("根据id查询用户信息,id:" + id);
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insertUser(String username,String password){
        System.out.println("添加用户信息："+ username + "," + password);
        return "success";
    }

    /**
     * 注意表单那边是不支持put和delete的请求的，到控制器这边来了之后对应的就是查询所有用户信息了。
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(String username,String password){
        System.out.println("修改用户信息为："+ username + "," + password);
        return "success";
    }


}
