package com.yillint.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(username);
        request.setAttribute("key","servlet1来的");
        /**
         * 请求转发必须以/打头，，，斜线/会被解析为 http://ip:port/工程名/，即项目的web目录
         */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/www.baidu.com");
        requestDispatcher.forward(request,response);

    }
}
