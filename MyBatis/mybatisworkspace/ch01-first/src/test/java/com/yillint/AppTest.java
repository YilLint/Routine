package com.yillint;

import static org.junit.Assert.assertTrue;

import com.yillint.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    /**
     *  1.写好对应的实体，和数据库操作层
     *  2.写好配置文件，其中有与数据库的连接，数据源，mappers的位置等等
     *  3.根据数据库操作层写好mappers，命名空间和对应语句
     *  4.测试就是先获取整个配置文件，然后将其通过资源类写成流，然后通过这个配置创建工厂
     *  然后通过通常创建session，写好sql拼接的语句，然后通过session去执行数据库
     */
    @Test
    public void testSelectStudentById() throws IOException {

        //定义mybatis主配置文件的位置，
        String config = "mybatis.xml";
        //读取主配值文件。使用mybatis框架中的Resources类
        InputStream inputStream = Resources.getResourceAsStream(config);
        //创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder().build()方法
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = factory.openSession();
        String sqlId = "com.yillint.dao.StudentDao" + "." +"selectStudentById";
        Student student = session.selectOne(sqlId,1);
        Student student2 = session.selectOne(sqlId,2);
        Student student3 = session.selectOne(sqlId,3);
        System.out.println(student);
        System.out.println(student2);
        System.out.println(student3);
        session.close();

    }


    @Test
    public void testInsertStudent() throws IOException {

        //定义mybatis主配置文件的位置，
        String config = "mybatis.xml";
        //读取主配值文件。使用mybatis框架中的Resources类
        InputStream inputStream = Resources.getResourceAsStream(config);
        //创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder().build()方法
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = factory.openSession();

        Student student = new Student();
        student.setAge(18);
        student.setEmail("lisisi@qq.com");
        student.setId(4);
        student.setName("李思思");

        String sqlId = "com.yillint.dao.StudentDao" + "." +"insertStudent";
        int effect = session.insert(sqlId,student);
        System.out.println(effect);
        //需要手动提交事务，在关闭之前提交
        session.commit();
        session.close();
    }

    @Test
    public void testAutoCommitInsertStudent() throws IOException {

        //定义mybatis主配置文件的位置，
        String config = "mybatis.xml";
        //读取主配值文件。使用mybatis框架中的Resources类
        InputStream inputStream = Resources.getResourceAsStream(config);
        //创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder().build()方法
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = factory.openSession(true);

        /*sqlSession是不安全的，需要从工厂获取，然后执行sql语句，根据其提供的不同方法可以有不同，最后要关闭session
           不关掉会占内存，且在此线程专有，安全一点，方法的局部变量
        */
        Student student = new Student();
        student.setAge(18);
        student.setEmail("sunshangxiang@qq.com");
        student.setId(7);
        student.setName("孙尚香");

        String sqlId = "com.yillint.dao.StudentDao" + "." +"insertStudent";
        int effect = session.insert(sqlId,student);
        System.out.println(effect);
        session.close();
    }

}
