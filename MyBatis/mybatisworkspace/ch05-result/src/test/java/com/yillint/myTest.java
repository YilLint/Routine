package com.yillint;

import com.yillint.dao.StudentDao;
import com.yillint.domain.Student;
import com.yillint.utils.MyBatisUtil;
import com.yillint.vo.CustomObject;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void testSelectById2(){
        SqlSession session = MyBatisUtil.getSqlsession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        CustomObject customObject = studentDao.selectById2(9);
        System.out.println(customObject);
        session.close();
    }

    @Test
    public void testSelectById3(){
        SqlSession session = MyBatisUtil.getSqlsession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        CustomObject customObject = studentDao.selectById3(6);
        System.out.println(customObject);
        session.close();
    }

    @Test
    public void testCountStudent(){
        SqlSession session = MyBatisUtil.getSqlsession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        long countStudent = studentDao.countStudent();
        System.out.println(countStudent);
        session.close();
    }

    @Test
    public void testMap(){
        SqlSession session = MyBatisUtil.getSqlsession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Map<Object, Object> map = studentDao.selectMap(9);
        System.out.println(map);
        session.close();
    }

    @Test
    public void testLike(){
        SqlSession sqlsession = MyBatisUtil.getSqlsession();
        StudentDao studentDao = sqlsession.getMapper(StudentDao.class);
        List<Student> students = studentDao.selectLikeOne("%李%");
        students.forEach(stu -> System.out.println(stu));
        sqlsession.close();
    }

    @Test
    public void testLikeTwo(){
        SqlSession sqlsession = MyBatisUtil.getSqlsession();
        StudentDao studentDao = sqlsession.getMapper(StudentDao.class);
        List<Student> students = studentDao.selectLikeTwo("李");
        students.forEach(stu -> System.out.println(stu));
        sqlsession.close();
    }

}
