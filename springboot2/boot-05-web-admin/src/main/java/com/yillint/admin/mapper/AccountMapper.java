package com.yillint.admin.mapper;

import com.yillint.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface AccountMapper {

    public Account getAcct(Long id);
}
