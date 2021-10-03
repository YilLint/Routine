package com.yillint.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addMoney(){
        String sql = "update t_account set money = money + 100 where username = ?";
        jdbcTemplate.update(sql,"mary");
    };

    //lucy转账100
    public void reduceMoney(){
        String sql = "update t_account set money = money - 100 where username = ?";
        jdbcTemplate.update(sql,"lucy");
    }

}
