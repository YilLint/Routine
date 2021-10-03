package com.yillint.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        servletContext作用：
        1.获取web.xml中配置的上下文参数context-param
        2.获取当前的工程路径，格式：/工程绝对路径
        3.获取工程部署后在服务器硬盘的绝对路径
        4.像map一样存储数据
        5.servletContext在web工程部署启动时创建，在web工程停止时销毁
        &不能得到servletConfig的内容
        & / 斜杠被服务器解析地址为：http://ip:8080/工程名/  映射idea代码的web目录
        这个地方就相当于项目的web目录，然后java代码就out那里去咯，
         */
        ServletContext servletContext = getServletContext();
        System.out.println(servletContext.getContextPath());
        System.out.println(servletContext.getInitParameter("username"));
        System.out.println(servletContext.getRealPath("/css"));
    }
}
