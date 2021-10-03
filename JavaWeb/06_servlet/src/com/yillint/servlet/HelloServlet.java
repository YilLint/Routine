package com.yillint.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {


    public HelloServlet() {
        System.out.println("1.构造器方法。。。。");
    }

    /**
     * ServletConfig的作用：
     * 1.可以获取Servlet程序的别名servlet-name的值
     * 2.获取初始化参数init-param
     * 3.获取ServletContext对象
     * 相当于就是去获取配置文件里面的标签的东西
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.初始化方法/////");
        System.out.println("1" + servletConfig.getServletName());
        System.out.println("2" + servletConfig.getInitParameter("param"));
        System.out.println("3" + servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //类型转换，为了得到getmethod方法
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String string = httpServletRequest.getMethod();
        if (string.equals("GET")){
            doGet();
        }else if (string.equals("POST")){
            doPost();
        }


        System.out.println("3.servlet方法，，，，Hello Servlet 被访问了。。。。。");
    }

    public void doGet(){
        System.out.println("进入doGet方法了");
    }

    public void doPost(){
        System.out.println("进入doPost方法了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.销毁方法???????");
    }
}
