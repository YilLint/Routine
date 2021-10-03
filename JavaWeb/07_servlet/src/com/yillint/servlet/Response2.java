package com.yillint.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("key","key1");
        System.out.println("response2这里不服务了，跳转了啊");
        //设置状态码，表示重定向
        /*response.setStatus(302);
        response.setHeader("Location","http://localhost:8080/07/response1");*/
        response.sendRedirect("http://localhost:8080/07/response1");
        /*
        * 区别转发和请求重定向
        *
        * 转发可以访问WEB-INF里面的内容,是请求的getRequestDispatcher加内容然后forward转发
        * 请求重定向还是相当于重新发请求了，是访问不到WEB-INF的内容，这就是应答的内容了，设置状态码表明状态然后
        * 在头里设置location重定向的位置，
        * */
    }
}
