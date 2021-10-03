package com.yillint.boot.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
* 宠物
*
* */
@ToString
@Data
@AllArgsConstructor//权参构造器
@NoArgsConstructor//无参构造器
public class Pet {

    private String name;

}
