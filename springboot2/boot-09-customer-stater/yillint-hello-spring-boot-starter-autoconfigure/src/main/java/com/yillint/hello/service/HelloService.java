package com.yillint.hello.service;

import com.yillint.hello.bean.HelloPeoperties;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 默认不要放在容器中
 */
public class HelloService {

    @Autowired
    HelloPeoperties helloPeoperties;

    public String sayHello(String userName){
        return helloPeoperties.getPrefix() + ":" + userName + "》" + helloPeoperties.getSuffix();
    }
}
