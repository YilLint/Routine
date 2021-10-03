package com.yillint.spring5.test;

import com.yillint.spring5.Config.TxConfig;
import com.yillint.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.lang.Nullable;

public class TestBook {

    @Nullable
    private String bookName;

    @Test
    public void testAccount(){
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void testAccount2(){
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void testAccount3(){
        ApplicationContext context=
                new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }


    //函数式风格创建对象，交给Spring进行管理
    @Test
    public void testGenericApplicationContext(){
        //创建对象
        GenericApplicationContext context = new GenericApplicationContext();
        //调用方法注册对象
        context.refresh();//内容清空
        context.registerBean("user1",User.class,() -> new User());
        context.registerBean(User.class,() -> new User());
        //获取创建的对象
        Object bean = context.getBean("com.yillint.spring5.test.User");
        Object bean2 = context.getBean("user1");
        System.out.println(bean);
        System.out.println(bean2);

    }

}
