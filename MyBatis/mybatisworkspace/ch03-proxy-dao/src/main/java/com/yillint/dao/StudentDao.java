package com.yillint.dao;

import com.yillint.domain.Student;

import java.util.List;

public interface StudentDao {

    //查询一个学生
    Student selectById(Integer id);

    List<Student> selectAll();

    int insertStudent(Student student);

}
