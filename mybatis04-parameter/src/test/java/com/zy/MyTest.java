package com.zy;

import com.zy.dao.StudentDao;
import com.zy.domain.Student;
import com.zy.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.swing.plaf.DimensionUIResource;
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
    public void testOne(){
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = dao.selectEmail("dh@qq.com");
        System.out.println("信息为：" + student);
        session.close();
    }


    @Test
    public void testSelectByNameOrAge(){
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> student = dao.selectByNameOrAge("小乔", 18);
        student.forEach(student1 -> System.out.println("stu====" + student1) );

        session.close();

    }

    @Test
    public void testSelectByObject(){
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("小乔");
        student.setAge(20);
        List<Student> students = dao.selectByObject(student);
        students.forEach(student1 -> System.out.println("stu===" + student1));

        session.close();
    }

    @Test
    public void testUpdateStudent(){
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1001);
        student.setName("周五");
        student.setEmail("zw@qq.com");
        student.setAge(30);

        int rows = dao.updateStudent(student);

        session.commit();
        System.out.println("更新学生的行数,rows" + rows);
        session.close();
    }

    @Test
    public void testQueryByNameAndId(){
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> students = dao.QueryByNameAndId("王冰冰", "id");

        students.forEach(student -> System.out.println("stu===" + student));
        session.close();
    }
}
