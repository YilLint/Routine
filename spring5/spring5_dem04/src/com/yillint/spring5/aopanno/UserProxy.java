package com.yillint.spring5.aopanno;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强类
@Component
@Aspect
@Order(2)
public class UserProxy {

    //相同切入点抽取
    @Pointcut(value = "execution(* com.yillint.spring5.aopanno.User.add(..))")
    public void pointdemo(){

    }

    //前置通知
    //@before注解表示前置作为前置通知
    @Before(value = "pointdemo()")
    public void before(){
        System.out.println("User Proxy before.......");
    }

    @After(value = "execution(* com.yillint.spring5.aopanno.User.add(..))")
    public void After(){
        System.out.println("after.......");
    }

    @AfterReturning(value = "execution(* com.yillint.spring5.aopanno.User.add(..))")
    public void afterReturning(){
        System.out.println("afterReturning.......");
    }

    //异常通知
    @AfterThrowing(value = "execution(* com.yillint.spring5.aopanno.User.add(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing.......");
    }

    //环绕通知
    @Around(value = "execution(* com.yillint.spring5.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前.......");

        //被增强方法执行
        proceedingJoinPoint.proceed();

        System.out.println("环绕之后.......");
    }
}
