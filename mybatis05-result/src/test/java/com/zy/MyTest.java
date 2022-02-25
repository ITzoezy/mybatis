package com.zy;

import com.sun.javafx.css.FontFace;
import com.zy.dao.StudentDao;
import com.zy.domain.Student;
import com.zy.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.swing.plaf.DimensionUIResource;
import java.util.List;
import java.util.Map;

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
    public void testCountStudent(){
        //1.获取SQLSession
        SqlSession session = MyBatisUtils.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Long nums = dao.CountStudent();
        System.out.println("nums = " + nums);
        //3.关闭SqlSession对象
        session.close();
    }
    @Test
    public void testSelectMap(){
        //1.获取SQLSession
        SqlSession session = MyBatisUtils.getSqlSession();
        //2.获取dao代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Map<Object, Object> map = dao.selectMap(1004);
        System.out.println("map==" + map);
        //3.关闭SqlSession对象
        session.close();
    }

    @Test
    public void testSelectLikeOne(){
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        String name = "%王%";
        List<Student> students = dao.selectLikeOne(name);
        students.forEach(student -> System.out.println("student===" + student));
        session.close();
    }


}
