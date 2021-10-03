package com.yillint;

import com.yillint.domain.Student;
import com.yillint.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class myTest {

    @Test
    public void testSelectById(){
        SqlSession session = MyBatisUtil.getSqlsession();

        String sqlId = "com.yillint.dao.StudentDao.selectById";
        Student student = session.selectOne(sqlId, 1);
        System.out.println(student);
        session.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession session = MyBatisUtil.getSqlsession();

        String sqlId = "com.yillint.dao.StudentDao.selectAll";
        List<Student> listStu = session.selectList(sqlId);
        for (Student stu:listStu){
            System.out.println(stu);
        }
        //System.out.println(listStu);
        session.close();
    }

    @Test
    public void testInsert(){
        SqlSession session = MyBatisUtil.getSqlsession();

        String sqlId = "com.yillint.dao.StudentDao.insertStudent";
        Student student = new Student(8, "东皇", "donghuang@qq.com", 30);
        int insert = session.insert(sqlId,student);
        //System.out.println(listStu);
        session.commit();
        session.close();
    }

}
