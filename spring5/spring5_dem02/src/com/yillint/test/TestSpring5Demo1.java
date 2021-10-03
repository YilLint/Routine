package com.yillint.test;

import com.yillint.autowire.Emp;
import com.yillint.bean.Orders;
import com.yillint.colletiontype.Book;
import com.yillint.colletiontype.Course;
import com.yillint.colletiontype.Stu;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5Demo1 {

    @Test
    public void testColletion(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        Stu stu = context.getBean("stu", Stu.class);

        stu.test();
    }

    @Test
    public void testColletion2(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);
        System.out.println(book);
        System.out.println(book2);

    }

    @Test
    public void testColletion3(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean3.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);

    }

    @Test
    public void testBean3(){
/*        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean4.xml");*/
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean4.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步，获取创建bean实例对象");
        System.out.println(orders);

        //手动销毁
        context.close();

    }

    @Test
    public void test4(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);

    }

}
