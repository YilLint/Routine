package com.yillint.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = 0 / 0;
        System.out.println(req.getMethod());
        //这里也可以使用servletConfig,但不同类中的servlet肯定是不同的，只能得到自己的servlet信息
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig.getInitParameter("param"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getMethod());
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("重写了init方法");
    }

}
