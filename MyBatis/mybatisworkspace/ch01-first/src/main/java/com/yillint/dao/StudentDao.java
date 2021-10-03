package com.yillint.dao;

import com.yillint.domain.Student;

public interface StudentDao {

    //查询一个学生
    Student selectStudentById(Integer id);

    //int返回的值表示，影响数据库的行数
    int insertStudent(Student student);
}
