package com.zy;

import com.zy.dao.StudentDao;
import com.zy.domain.Student;
import com.zy.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void testSelectById(){
        //1.获取SQLSession
        SqlSession session = MyBatisUtils.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = dao.selectById(1002);
        System.out.println("查询的一个学生信息为：" + student);
        //3.关闭SqlSession对象
        session.close();
    }
    @Test
    public void testSelectStudents(){
        //1.获取SQLSession
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudents();
        students.forEach(student -> System.out.println("student=" + students));
        session.close();
    }
    @Test
    public void testInsertStudent(){
        //1.获取SQLSession
        SqlSession session = MyBatisUtils.getSqlSession();
        //2.指定sqlId
        String sqlId = "com.zy.dao.StudentDao.insertStudent";
        //3.执行SQLSession方法，并执行sql语句
        Student student = new Student();
        student.setId(1005);
        student.setName("东皇");
        student.setEmail("dh@qq.com");
        student.setAge(23);
        int rows =session.insert(sqlId,student);
        System.out.println("添加的学生信息，rows为;" + rows);

        session.commit();
        //4.关闭SqlSession对象
        session.close();
    }
}
