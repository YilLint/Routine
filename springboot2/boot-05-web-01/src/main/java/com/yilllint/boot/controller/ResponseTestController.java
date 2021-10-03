package com.yilllint.boot.controller;


import com.yilllint.boot.bean.Person;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseTestController {


    @ResponseBody
    @GetMapping("/he11")
    public FileSystemResource file(){

        //文件以这样的方式返回是谁处理的（messageConvertor）
        return null;
    }

    /**
     * 1.浏览器直接发请求返回XMl  [application/xml]               jacksonXmlConverter
     * 2.如果是ajax请求 返回json [application/json]              jaksonJasnConverter
     * 3.如果是硅谷app发请求，返回自定义协议数据 [application/x-yillint] xxxConverter
     *      属性值1；属性值2；······
     * 步骤：
     * 1.添加自定义的MessageComverter进系统底层
     * 2.系统底层就会统计出所有MessageConverter能操作那些类型
     * 3.客户端内容协商[yillint--->guigu]
     *
     * 作业：如何以参数的方式进行内容协商
     * @return
     */
    @ResponseBody  //利用返回值处理器里面的消息转换器进行处理
    @GetMapping("/test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setAge(28);
        person.setBirth(new Date());
        person.setUserName("zhangsan");
        return person;
    }
}
