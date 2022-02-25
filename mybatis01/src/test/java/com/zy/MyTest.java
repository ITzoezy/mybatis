package com.zy;

import com.zy.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

public class MyTest {

    @Test
    public void TestSelectStudentById() throws IOException {
        //1.定义mybatis主配置文件的位置，从类路径开始的相对路径
        String config = "mybatis.xml";
        //2.读取主配置文件，使用mybatis框架的resource类
        InputStream inputStream = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder()类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //4.获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        //5.指定要执行的SQL语句
        String sqlId ="com.zy.dao.StudentDao.selectStudentById";

        //6.通过SqlSession的方法执行sql语句
        Student student = session.selectOne(sqlId,1001);

        System.out.println("使用mybatis查询的一个学生：" + student);

        //7.关闭session对象
        session.close();
    }


    @Test
    public void TestInsertStudent() throws IOException {
        //1.定义mybatis主配置文件的位置，从类路径开始的相对路径
        String config = "mybatis.xml";
        //2.读取主配置文件，使用mybatis框架的resource类
        InputStream inputStream = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder()类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //4.获取SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();

        //5.指定要执行的SQL语句
        String sqlId ="com.zy.dao.StudentDao.insertStudent";


        Student student = new Student();
        student.setId(1004);
        student.setName("王冰冰");
        student.setEmail("wbb@qq.com");
        student.setAge(18);
        //6.通过SqlSession的方法执行sql语句
        int rows = session.insert(sqlId,student);

        System.out.println("使用mybatis添加一个学生，rows为：" + rows);


        //mybatis默认执行sql语句是   手工提交事务  模式，在做insert，update，delete后需要提交事务
        session.commit();
        //7.关闭session对象
        session.close();
    }
}
