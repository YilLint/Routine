package com.yillint.dao;

import com.yillint.domain.Student;
import com.yillint.vo.CustomObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    //查询一个学生
    Student selectById(Integer id);

    CustomObject selectById2(@Param("stuid") Integer id);

    CustomObject selectById3(@Param("stuid") Integer id);

    long countStudent();

    Map<Object,Object> selectMap(Integer id);

    //模糊查询
    List<Student> selectLikeOne(@Param("name")String name);

    List<Student> selectLikeTwo(@Param("name")String name);

}
