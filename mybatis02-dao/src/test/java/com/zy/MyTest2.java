package com.zy;

import com.zy.Impl.StudentDaoImpl;
import com.zy.dao.StudentDao;
import com.zy.domain.Student;
import org.junit.Test;

import java.util.List;

public class MyTest2 {


    @Test
    public void testSelectById(){
        StudentDao dao = new StudentDaoImpl();
        Student student = dao.selectById(1001);
        System.out.println("通过dao执行的方法，得到的对象" + student);
    }

    @Test
    public void testSelectStudents(){
        StudentDao dao = new StudentDaoImpl();
        List<Student> students = dao.selectStudents();
        students.forEach(student -> System.out.println("student=" + student));
    }


    @Test
    public void testInsertStudent(){
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student();
        student.setId(1006);
        student.setName("小乔");
        student.setEmail("xq@qq.com");
        student.setAge(16);
        dao.insertStudent(student);
    }
}
