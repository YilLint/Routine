package com.yillint.testdemo;

import com.yillint.Book;
import com.yillint.Orders;
import com.yillint.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring5 {

    @Test
    public void testAdd(){
        //加载spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        //2获取配置创建的对象
        User user = context.getBean("user", User.class);

        System.out.println(user);
        user.add();
    }

    @Test
    public void testBook(){
        //加载spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        //2获取配置创建的对象
        Book book = context.getBean("book", Book.class);

        System.out.println(book);
        book.testDemo();
    }

    @Test
    public void testOrders(){
        //加载spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        //2获取配置创建的对象
        Orders orders = context.getBean("orders", Orders.class);

        System.out.println(orders);
        orders.ordersTest();
    }

}
