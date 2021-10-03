package com.yillint.spring5.test;

import com.yillint.spring5.entity.Book;
import com.yillint.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestBook {

    @Test
    public  void testJdbcTemplate(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        Book book = new Book();
        book.setUserId("1");
        book.setUsername("java");
        book.setUstaus("a");
        //添加
        bookService.addBook(book);

        //批量添加
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"2","c++","a"};
        Object[] o2 = {"3","c","a"};
        Object[] o3 = {"4","golang","a"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchAdd(batchArgs);

        //修改
        book.setUstaus("b");
        bookService.updateBook(book);

        //批量修改
        List<Object[]> batchArgs2 = new ArrayList<>();
        Object[] o4 = {"c++","b","2"};
        Object[] o5 = {"c","b","3"};
        Object[] o6 = {"golang","b","4"};
        batchArgs2.add(o4);
        batchArgs2.add(o5);
        batchArgs2.add(o6);
        bookService.batchUpdate(batchArgs2);

        //查询记录数
        int count = bookService.findCount();
        System.out.println("记录数为：" + count);

        //查询某一个
        Book one = bookService.findOne("1");
        System.out.println(one.toString());

        //查询返回集合
        List<Book> bookList = bookService.findAll();
        System.out.println(bookList);

        //删除
        bookService.deleteBook("1");

        //批量删除
        List<Object[]> batchArgs3 = new ArrayList<>();
        Object[] o7 = {"2"};
        Object[] o8 = {"3"};
        Object[] o9 = {"4"};
        batchArgs3.add(o7);
        batchArgs3.add(o8);
        batchArgs3.add(o9);
        bookService.batchDelete(batchArgs3);

        //查询记录数量
        count = bookService.findCount();
        System.out.println("记录数为：" + count);
    }
}
