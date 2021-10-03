package com.yillint;

import com.yillint.dao.StudentDao;
import com.yillint.domain.Student;
import com.yillint.utils.MyBatisUtil;
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
    public void testOneParameter(){
        SqlSession session = MyBatisUtil.getSqlsession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        studentDao.selectByemail("zhugeliannu@qq.com");
        session.close();
    }

    @Test
    public void testTwoParameter(){
        SqlSession session = MyBatisUtil.getSqlsession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        List<Student> student = studentDao.selectByNameOrAge("youxia", 18);
        student.forEach(stu -> System.out.println(stu));
        session.close();
    }


    @Test
    public void testByObject(){
        SqlSession session = MyBatisUtil.getSqlsession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("游侠");
        student.setAge(18);
        List<Student> students = studentDao.selectByObject(student);
        students.forEach(stu -> System.out.println(stu));
        session.close();
    }

    @Test
    public void testByPosition(){
        SqlSession session = MyBatisUtil.getSqlsession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        List<Student> students = studentDao.selectByPosition("诸葛连弩",20);
        students.forEach(stu -> System.out.println(stu));
        session.close();
    }

    @Test
    public void testByMap(){
        SqlSession session = MyBatisUtil.getSqlsession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("myname","游侠");
        map.put("myage",28);
        List<Student> students = studentDao.selectStudentByMap(map);
        students.forEach(stu -> System.out.println(stu));
        session.close();
    }

    @Test
    public void testUpdateStudent(){
        SqlSession session = MyBatisUtil.getSqlsession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("东皇");
        student.setAge(88);
        student.setId(8);
        int i = studentDao.updateStudent(student);
        System.out.println(i);
        session.commit();
        session.close();
    }

    @Test
    public void testSelectByName(){
        SqlSession session = MyBatisUtil.getSqlsession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        //${}是字符串拼接，那么在传参数时，string类型就要自己添加引号
        List<Student> queryStudent = studentDao.queryStudent("'李四' or 1=1");
        queryStudent.forEach(stu -> System.out.println(stu));
        session.close();
    }

    @Test
    public void testQueryById(){
        SqlSession session = MyBatisUtil.getSqlsession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        //${}是字符串拼接，那么在传参数时，string类型就要自己添加引号
        List<Student> queryStudent = studentDao.queryStudentByColName("name");
        queryStudent.forEach(stu -> System.out.println(stu));
        session.close();
    }


}
