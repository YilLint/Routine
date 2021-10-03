package com.yillint.testdemo;

import com.yillint.Book;
import com.yillint.Orders;
import com.yillint.User;
import com.yillint.bean.Emp;
import com.yillint.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testBean {

    @Test
    public void testBean1(){
        //加载spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");
        //2获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);

        userService.add();
    }

    @Test
    public void testBean2(){
        //加载spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean3.xml");
        //2获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);
        emp.add();
    }

    @Test
    public void testBean3(){
        //加载spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean4.xml");
        //2获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);
        emp.add();
    }

}
