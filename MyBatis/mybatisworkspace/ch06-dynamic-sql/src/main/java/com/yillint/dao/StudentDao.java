package com.yillint.dao;

import com.yillint.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    List<Student> selectStudentIf(Student student);

    List<Student> selectStudentWhere(Student student);

    List<Student> selectTest(@Param("sql") StringBuffer sql);

    //foreach-1
    List<Student> selectForeachOne(List<Integer> idlist);

    //foreach-1
    List<Student> selectForeachTwo(List<Student> stulist);

    List<Student> selectAllStudents();

}
