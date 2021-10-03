package com.yillint.dao;

import com.yillint.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    //查询一个学生
    Student selectById(Integer id);
    
    Student selectByemail(String email);

    //多个简单类型参数,在形参前要使用命名参数@Param,相当于绑定的意思
    List<Student> selectByNameOrAge(@Param("myname") String name,
                                    @Param("myage") Integer age);

    //对象作为参数的话，使用要和对象属性一样的名字
    List<Student> selectByObject(Student student);

    //按位置
    List<Student> selectByPosition(String name,Integer age);

    //map
    List<Student> selectStudentByMap(Map<String,Object>map);

    int updateStudent(Student student);

    //${},要@param命名
    List<Student> queryStudent(@Param("myname") String name);


    List<Student> queryStudentByColName(@Param("cloName")String name);

}
