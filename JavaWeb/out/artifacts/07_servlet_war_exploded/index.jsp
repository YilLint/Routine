<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/9/24
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  这是web下的index.html<br>
  <a href="a/b/c.html">a/b/c.html</a><br>
  <a href="http://localhost:8080/07/forwardC">请求转发a/b/c.html</a>
  <a href="/">斜杠</a>
  <%--<a href="forwardC">请求转发a/b/c.html</a>--%>
  <%--所有相对路径在工作时都会参照当前浏览器地址栏中的地址l来进行跳转--%>
  <%--
    相对路径：   .   表示当前目录
               ..   表示上一级目录
               资源名  表示当前目录资源名
    绝对路径：
            从http开始到资源路径


    在web中/的不同意义
    在web中是一个绝对路径得到的地址是http://ip:port/
    在服务器中解析的地址是http:ip:port/工程路径


  --%>
  </body>
</html>
