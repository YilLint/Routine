package com.yillint.contriller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *  @Controller:创建处理器对象，对象放在springmvc容器中。
 *  位置：在类的上面
 *  和Spring中讲的@Service，@Componet
 *
 *  能处理请求的都是控制器（处理器）：MyController能处理请求，
 *                              叫做后端处理器（back controller）
 */
@Controller
public class MyController {
    /**
     * 处理用户的请求，springmvc中是使用方法来处理的。
     * 方法是自定义的，可以有多种返回值，多种参数，方法名称自定义
     */

    /**
     * 准备使用dosome方法处理some.do请求。
     * @RequestMapping：请求映射，作用是把一个请求地址和一个方法绑定在一起
     *                  一个请求指定一个方法处理。
     *       属性：1.value 是一个string，标志请求的地址的。
     *              value的值必须是唯一的，不能重复。
     *
     * 说明：使用RequestMapping修饰的方法叫做处理器方法或控制器方法。
     * 使用@RequestMapping修饰方法可以处理请求的，类似Servlet中doGet，doPost
     *
     * 返回值：ModelAndView 表示本次请求的处理结果
     * Model：数据，请求处理完成后，要显示给用户的结果
     * View:视图，比如jsp等等
     */

    @RequestMapping(value = {"/some.do","/fist.do"})
    public ModelAndView doSome(){   //doGet（）--service请求处理
        //处理some.do请求。相当于调用处理完成了。
        ModelAndView mv = new ModelAndView();
        //添加数据，框架在请求的最后把数据放到request作用域中
        //request.setAttribute("msg",欢迎使用springmvc做web开发)；
        mv.addObject("msg","欢迎使用springmvc做web开发");
        mv.addObject("fun","执行dosome方法");

        //指定视图，指定视图的完整路径
        //框架对试图执行forward操作，request.getRequestDispatcher("/show.jsp").forward(...)
//        mv.setViewName("/show.jsp");
//        mv.setViewName("/WEB-INF/view/show.jsp");
//        mv.setViewName("/WEB-INF/view/others.jsp");

        //当配置了视图解析器后，可以使用逻辑名称（文件名），指定视图
        //框架会使用视图解析器的前缀 + 逻辑名称 +后缀 组成完成路径，这里就是字符的连接操作
        //WEB-INF/view/+ show + .jsp
        mv.setViewName("show");

        //返回mv
        return mv;
    }


    @RequestMapping(value = {"/other.do","/second.do"})
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc做web开发");
        mv.addObject("fun","执行的时doOther方法");
        mv.setViewName("other");
        return mv;
    }

}
