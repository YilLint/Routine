# web开发底层是servlet

SpringMVC：是基于Spring的一个框架，实际上就是Spring的一个模块，专门做web开发

​						理解是servlet的一个升级



​						web开发底层就是servlet，框架是在servlet基础上加入一些功能，让你做web开发方便。



SpringMVC就是一个Spring。Spring是容器，ioc能管理对象，使用<bean>，@Compont，@Repository，@Service，@Controller。SpringMVC就能够创建对象，放入到容器中（SpringMVC容器），springmvc容器中放的是控制器对象。



我们要做的是**使用@Controller创建控制对象，**把对象放入到springmvc容器中，把创建的对象作为控制器，使用这个控制器对象能接受用户的请求，显示处理结果，就是当作一个servlet使用。



**使用@Controller注解创建的是一个普通类的对象，**不是servlet。springmvc赋予了控制对象一些额外的功能。



web开发底层是servlet，springmvc中有一个对象是servlet：Dispatherservlet（中央调度器）

Dispatherservlet：负责接收用户的请求，用户把请求给了Dispatherservlet，之后Dispatherservlet把请求转发给我们的controller对象，最后是Controller对象处理。



# web开发步骤

index.jsp------Dispatherservlet(servlet)------转发，分配给---Contriller对象（@Controller注解创建的对象）



# springmvc的处理过程

1、发起some.do

2、tomcat（web.xml--url-pattern知道*.do的请求给DispatcherServlet）

3、DispatcherServlet（根据springmvc.xml配置知道some.do---dosome()）-----DispatcherServlet把some.do转发给MyContoller.dosome()方法

4、框架执行dosome（）把得到ModelAndView进行处理，转发到show.jsp



过程简化：

some.do---DispatcherServlet---MyController

![image-20210730101709516](D:\springboot_practice\springmvc\images\image-20210730101709516.png)





# springmvc执行过程源代码分析

1.tomcat启动，创建容器的过程

通过load-on-start标签指定的1，创建DisaptcherServlet对象，

DispatcherServlet它的父类是继承HttpServlet的，它是一个servlet，在被创建时，会执行init（）方法。

在init（）方法中

```java
//创建容器，读取配置文件
WebApplicationContext ctx = new ClassPathXmlApplicationContext("springmvc.xml");
//把容器对象放到ServletContext中
getServletContext().setAttribute(key,ctx);
```



上面创建容器作用：创建@controller注解所在的类的对象，创建MyController，

这个对象放入到springmvc的容器中，容器中map，类似map.put("myController",MyController对象)



2.请求的处理过程

1）执行servlet的service（）

​	protected void service(HttpServletRequest requrest,Htt[ServeltResponse response])



DispatcherServlet.doDispatch(reques,response){

​		调用MyController的.doSome（）方法

}





































