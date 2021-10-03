package com.yillint.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //字符流
        System.out.println(response.getCharacterEncoding());//ISO-8859-1
        //response.setCharacterEncoding("UTF-8");
        //此方法必须要在获取流之前设置
        response.setContentType("text/html;charset=UTF-8");//这一行会同时设置服务器和浏览器都设置字符集
        //浏览器也设置一下字符集
        //response.setHeader("Content-Type","text/html;charset=UTF-8");
        System.out.println(response.getCharacterEncoding());
        PrintWriter writer = response.getWriter();
        writer.write("response's content,中文字符");

        //字符流和字节流只能一次获取一个
        //response.getOutputStream();字节流
    }
}
