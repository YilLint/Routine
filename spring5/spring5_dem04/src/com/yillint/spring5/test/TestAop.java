package com.yillint.spring5.test;

import com.yillint.spring5.aopanno.User;
import com.yillint.spring5.aopxml.Book;
import com.yillint.spring5.config.ConfigAop;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void testAopAnno1(){

        //加载配置文件
        ApplicationContext context= new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);

        user.add();
    }

    @Test
    public void testAopAnno2(){

        //加载配置类
        ApplicationContext context= new AnnotationConfigApplicationContext(ConfigAop.class);

        User user = context.getBean("user", User.class);

        user.add();
    }


    @Test
    public void testAopXml(){

        //加载配置文件
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean2.xml");

        Book book = context.getBean("book", Book.class);

        book.buy();
    }

}
