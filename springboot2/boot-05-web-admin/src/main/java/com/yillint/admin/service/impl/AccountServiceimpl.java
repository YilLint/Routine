package com.yillint.admin.service.impl;

import com.yillint.admin.bean.Account;
import com.yillint.admin.mapper.AccountMapper;
import com.yillint.admin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceimpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAcctByid(Long id){
        return accountMapper.getAcct(id);
    }

}
