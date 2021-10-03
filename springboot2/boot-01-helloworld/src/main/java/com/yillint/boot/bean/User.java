package com.yillint.boot.bean;

import lombok.*;

/*
* 用户
*
* */
@ToString
@Data
//@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    private  String name;
    private  Integer age;

    private Pet pet;

    public User(String name,Integer age){
        this.name = name;
        this.age = age;
    }

}
