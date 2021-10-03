package com.yillint.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("user")

public class User {

    /*
    * 所有数据都应该出现在数据库中
    * */
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String passWord;


    //一下是数据库的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
