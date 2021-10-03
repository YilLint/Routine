package com.yillint.service;

import com.yillint.dao.UserDao;
import com.yillint.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//注解里value可以省略，默认为类名，将类名首字母小写
@Service   //<bean id="userService" class=".">
public class UserService {

    @Value("zhangsan")
    private String name;

    //定义dao类型对象,不需要添加set方法，添加注入属性注解
//    @Autowired//根据类型进行注入
//    @Qualifier(value = "userDaoImpl1")
//    private UserDao userDao;

    //@Resource   //根据类型注入
    @Resource(name = "userDaoImpl1") //根据名称注入
    private UserDao userDao;

    public void add(){
        System.out.println("UserService add.......");
        userDao.add();
        System.out.println(name);
    }
}
