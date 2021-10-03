# 1、简介

JDBC->Dbutils(QueryRunner)->JdbcTemplate: 工具		框架：整体解决方案

![image-20210803203631169](D:\springboot_practice\MyBatis\images\image-20210803203631169.png)

1、功能简单;sql语句编写在java代码里面；硬编码高耦合的方式



Hibernate：全自动全映射ORM（Object Relation Mapping）框架；旨在消除sql，HQL

![image-20210803203815445](D:\springboot_practice\MyBatis\images\image-20210803203815445.png)



希望：sql语句交给我们开发人员编写，希望sql不失去灵活性；



![image-20210803204220953](D:\springboot_practice\MyBatis\images\image-20210803204220953.png)

Sql与java分离；sql是开发人员控制

只需掌握好sql