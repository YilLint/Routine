package com.yillint.contriller;


import com.yillint.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MyController {

    /**
     * 处理器方法返回String--表示逻辑视图名称，需要配置视图解析器
     */
    @RequestMapping(value = "/returnString-view.do")
    public String doRreturnView(HttpServletRequest httpServletRequest,String name,String age){
        System.out.println("doRreturnView" + name + "::" + age);
        //手工在request中添加数据
        httpServletRequest.setAttribute("myname",name);
        httpServletRequest.setAttribute("myage",age);
        //show是视图文件的逻辑名称（文件名称）,项目中配置了视图解析器
        //对视图执行forward操作
        return "show";
    }

    //完整视图路径
    @RequestMapping(value = "/returnString-view2.do")
    public String doRreturnView2(HttpServletRequest httpServletRequest,String name,String age){
        System.out.println("doRreturnView2" + name + "::" + age);
        //手工在request中添加数据
        httpServletRequest.setAttribute("myname",name);
        httpServletRequest.setAttribute("myage",age);
        //show是视图的完整路径,不能配置了视图解析器，否则路径就变成了/return/WEB-INF/view//WEB-INF/view/show/jsp.jsp
        //对视图执行forward操作
        return "/WEB-INF/view/show/jsp";
    }


}
