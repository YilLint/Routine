package com.yillint.dao.impl;

import com.yillint.dao.StudentDao;
import com.yillint.domain.Student;
import com.yillint.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public Student selectById(Integer id) {
        SqlSession sqlSession = MyBatisUtil.getSqlsession();
        String sqlId = "com.yillint.dao.StudentDao.selectById";
        Student student = sqlSession.selectOne(sqlId,id);
        System.out.println(student);
        sqlSession.close();
        return student;
    }

    @Override
    public List<Student> selectAll() {
        SqlSession session = MyBatisUtil.getSqlsession();

        String sqlId = "com.yillint.dao.StudentDao.selectAll";
        List<Student> listStu = session.selectList(sqlId);
        session.close();
        return listStu;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession session = MyBatisUtil.getSqlsession();

        String sqlId = "com.yillint.dao.StudentDao.insertStudent";
        int insert = session.insert(sqlId,student);
        session.commit();
        return insert;
    }
}
