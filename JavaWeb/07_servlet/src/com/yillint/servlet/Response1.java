package com.yillint.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("获得到不同的请求的request内容吗" + request.getAttribute("key"));
        System.out.println("转发成功了");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("response1到了");
    }
}
