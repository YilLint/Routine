return：处理器方法的返回值表示请求的处理结果
1.ModelAndView：有数据和视图，对视图执行forward。
2.String：表示视图，可以逻辑名称，也可以是完整视图路径
3.void:不能表示视图也不能表示视图。
    在处理ajax的时候可以使用void返回值。用过HttpServletRespond输出数据。响应ajax请求。
    ajax请求服务端返回的就是数据，和视图无关。
4.Object：例如String，Integer，Map，List，Student等等都是对象，
    对象有属性，属性就是数据，所以返回object表示数据，和视图无关。
    可以使用对象表示的数据，响应ajax请求

    现在做ajax，主要使用json的数据可是。实现步骤：
        1.加入处理json的工具库依赖，springmvc默认使用的jackson。
        2.在springmvc配置文件之间加入<mvc:annotation-driven>注解驱动
            jason = om.writeValueAsString(student)
        3.在处理器方法的上面加入@ResponseBody注解



实现步骤：
1.新建web maven工程
2.加入依赖
    spring-webmvc依赖，间接把springd的依赖加入项目
    jsp，servlet依赖

3.重点：在web.xml中注册springmvc框架核心DispatcherServlet
    1）DispatcherServlet叫做中央调度器，是一个servlet，它的父类是继承HttpServlet
    2）DispatcherServlet也叫做前端控制器（front controller）
    3）DispatcherServlet负责接收用户提交的请求，调用其他的控制器对象，
    并把请求的处理结果显示给用户

4.创建一个发起请求的页面 index.jsp

5.创建控制类
    1）在类的上面加入@Controller注解，创建对象，并放到springmvc中
    2）在类中的方法上面加入@RequestMapping注解。

6.创建一个作为结果的jsp，显示请求的处理结果。

7.创建springmvc的配置文件（spring的配置文件一样）
    1）声明组件扫描器，指定@Controller注解所在的报名
    2）声明试图解析器。帮助处理试图的。

