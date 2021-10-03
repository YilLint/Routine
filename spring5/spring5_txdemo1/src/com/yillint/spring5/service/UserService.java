package com.yillint.spring5.service;

import com.yillint.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional(timeout = -1,propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
public class UserService {

    //注入dao
    @Autowired
    private UserDao userDao;

    public void accountMoney(){
//        //开启事务
//        try{
//            //两个方法，进行业务
//            userDao.reduceMoney();
//            int i=0/0;
//            userDao.addMoney();
//        }catch (Exception e){//出现了异常，回滚
//
//        }
        //两个方法，进行业务
        userDao.reduceMoney();
        int i=0/0;
        userDao.addMoney();


    }
}
