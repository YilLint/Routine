package com.yillint;

import com.yillint.dao.StudentDao;
import com.yillint.dao.impl.StudentDaoImpl;
import com.yillint.domain.Student;
import org.junit.Test;

import java.util.List;

public class myTest2 {

    @Test
    public void testdao(){
        StudentDao dao = new StudentDaoImpl();
        Student student = dao.selectById(8);
        System.out.println(student);

        Student student1 = new Student(10, "条顿武士", "tiaodunwushi@qq.com", 27);
        dao.insertStudent(student1);

        List<Student> studentList = dao.selectAll();
        studentList.forEach(stu -> System.out.println(stu));
    }
}
