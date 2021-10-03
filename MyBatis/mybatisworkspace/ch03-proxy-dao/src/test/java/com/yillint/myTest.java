package com.yillint;

import com.yillint.dao.StudentDao;
import com.yillint.domain.Student;
import com.yillint.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class myTest {

    @Test
    public void testSelectById(){
        SqlSession session = MyBatisUtil.getSqlsession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Student student = studentDao.selectById(9);
        System.out.println(student);
        session.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession session = MyBatisUtil.getSqlsession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        System.out.println("-------------------------" + studentDao.getClass());
        //class com.sun.proxy.$Proxy2
        List<Student> studentList = studentDao.selectAll();
        studentList.forEach(student -> System.out.println(student));
        session.close();
    }

    @Test
    public void testInsert(){
        SqlSession session = MyBatisUtil.getSqlsession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Student student = new Student(11, "诸葛连弩", "诸葛连弩@qq.com", 30);
        int insertStudent = studentDao.insertStudent(student);
        System.out.println("影响的行数" + insertStudent);
        session.commit();
        session.close();
    }

}
