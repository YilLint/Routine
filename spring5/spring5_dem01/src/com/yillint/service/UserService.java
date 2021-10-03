package com.yillint.service;

import com.yillint.User;
import com.yillint.dao.UserDao;

public class UserService extends User
{

    //创建UserDao类型属性，生成set方法
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service add........");
        userDao.updata();

        //创建UserDao对象
        /*UserDao userDao = new UserDao();
        userDao.updata();*/
    }
}
