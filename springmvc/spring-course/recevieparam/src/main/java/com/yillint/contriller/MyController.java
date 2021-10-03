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

/**
 *  @Controller:创建处理器对象，对象放在springmvc容器中。
 *  位置：在类的上面
 *  和Spring中讲的@Service，@Componet
 *
 *  能处理请求的都是控制器（处理器）：MyController能处理请求，
 *                              叫做后端处理器（back controller）
 */

/**
 * @RequestMapping
 *      value:所有请求地址的公共部分，叫做模块名称
 *      位置：放在类上面
 */
@Controller
public class MyController {

    /**
     *  逐个接收请求的参数：
     *      要求：处理器（控制器）方法的形参名和请求中的形参名要一致
     *          同名的请求参数赋值给同名的形参
     * 框架接收请求参数
     * 1.使用request接收参数
     *  String strname = request.getParameter("name");
     *  String strage = request.getParameter("age");
     * 2.springmvc框架通过DispatcherServlet调用MyController的doSome（）方法
     *  调用方法时，按名称对应，把接收的参数赋值给形参
     *  dosome（strname，Interger.valueOf（strage））
     *  框架会提供类型转换的功能，能把String转为int，long，float，doubled等类型。
     *
     *400状态码时客户端错误，表示提交请求参数过程中，发生了问题
     */
    @RequestMapping(value = "/receiveproperty.do")
    public ModelAndView doSome(String name,Integer age){
        System.out.println(name+"::"+age);
        //可以以直接在方法中使用name，age
        //处理soeme.do请求了。相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //shouw是视图文件的逻辑名称（文件名称）
        mv.setViewName("show");
        return mv;
    }

/*    public void doGet(HttpServletRequest request){
        //request.setCharacterEncoding("utf-8");
    }

    public void doPost(HttpServletRequest request){
        //request.setCharacterEncoding("utf-8");
    }*/


    /**
     * 请求中的参数名和处理器方法的形参名不一样
     * @RequestParam解决请求中参数形参名不一致问题
     *      属性：value请求中的参数名称
     *          required 是一个boolean，默认是true
     *             true：表示请求中必须包含此参数。
     *      位置：在处理器方法的形参定义的前面
     */
    @RequestMapping(value = "/receiveparam.do")
    public ModelAndView receiveparam(@RequestParam(value = "rname",required = false)String name,
                                     @RequestParam(value = "rage",required = false)Integer age){
        System.out.println(name+"::"+age);
        //可以以直接在方法中使用name，age
        //处理soeme.do请求了。相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //shouw是视图文件的逻辑名称（文件名称）
        mv.setViewName("show");
        return mv;
    }


    /**
     * 处理器方法形参是对象，这个对象的属性名和请求中参数名一样的
     * 框架会创建形参的java对象，给属性赋值。请求中的参数是name，框架会调用setName（）
     * @return
     */
    @RequestMapping(value = "/receiveobject.do")
    public ModelAndView receiveparam(Student mystudent){
        System.out.println("receiveparam" + mystudent.getName() + "::" + mystudent.getAge());
        //可以以直接在方法中使用name，age
        //处理soeme.do请求了。相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",mystudent.getName());
        mv.addObject("myage",mystudent.getAge());
        mv.addObject("mystudent",mystudent);
        //shouw是视图文件的逻辑名称（文件名称）
        mv.setViewName("show");
        return mv;
    }


}
