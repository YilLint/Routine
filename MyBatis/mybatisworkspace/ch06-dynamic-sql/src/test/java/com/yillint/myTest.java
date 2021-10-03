package com.yillint;

import com.google.protobuf.StringValue;
import com.yillint.dao.StudentDao;
import com.yillint.domain.Student;
import com.yillint.utils.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class myTest {


    @Test
    public void testForeachOne() {
        SqlSession sqlsession = MyBatisUtil.getSqlsession();
        StudentDao studentDao = sqlsession.getMapper(StudentDao.class);
        List<Integer> idlist = new ArrayList<>();
        idlist.add(1);
        idlist.add(2);
        idlist.add(3);
        idlist.add(4);
        idlist.add(5);
        idlist.add(6);
        //idlist = null;
        List<Student> students = studentDao.selectForeachOne(idlist);
        students.forEach(stu-> System.out.println(stu));
        sqlsession.close();
    }

    @Test
    public void testForeachTwo() {
        SqlSession sqlsession = MyBatisUtil.getSqlsession();
        StudentDao studentDao = sqlsession.getMapper(StudentDao.class);
        List<Student> stulist = new ArrayList<>();
        Student student1 = new Student();
        student1.setId(1);
        Student student2 = new Student();
        student2.setId(2);
        Student student3 = new Student();
        student3.setId(3);
        stulist.add(student1);
        stulist.add(student2);
        stulist.add(student3);
        //idlist = null;
        List<Student> students = studentDao.selectForeachTwo(stulist);
        students.forEach(stu-> System.out.println(stu));
        sqlsession.close();
    }


    @Test
    public void testFor() throws IOException {
        ArrayList<Integer> idlist = new ArrayList<>();
        idlist.add(1);
        idlist.add(2);
        idlist.add(3);
        idlist.add(4);
        idlist.add(5);
        idlist.add(6);

        StringBuffer sql = new StringBuffer("");
        sql.append("select * from student where id in ");

        sql.append("(");
        for (int i = 0; i < idlist.size(); i++) {
            Integer item = (Integer) idlist.get(i);
            sql.append(item);
            sql.append(",");
        }
        sql.deleteCharAt(sql.length()-1);
        sql.append(")");

        System.out.println(sql);

        String config = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        String sqlId = "com.yillint.dao.StudentDao.selectTest";
        List<Student> students = session.selectList(sqlId,sql);
        students.forEach(stu-> System.out.println(stu));


    }

    @Test
    public void testSelectIf() {
        SqlSession sqlsession = MyBatisUtil.getSqlsession();
        StudentDao studentDao = sqlsession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("游侠");
        student.setAge(19);
        List<Student> students = studentDao.selectStudentIf(student);
        students.forEach(stu-> System.out.println(stu));
        sqlsession.close();
    }

    @Test
    public void testSelectWhere() {
        SqlSession sqlsession = MyBatisUtil.getSqlsession();
        StudentDao studentDao = sqlsession.getMapper(StudentDao.class);
        Student student = new Student();
        //student.setName("游侠");
        //student.setAge(27);
        List<Student> students = studentDao.selectStudentWhere(student);
        students.forEach(stu-> System.out.println(stu));
        sqlsession.close();
    }

}
