package com.zy.dao;

import com.zy.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    //查询学生信息
    Student selectById(Integer id);
    //查询多个学生信息
    List<Student> selectStudents();
    //添加学生信息
    int insertStudent(Student student);

    //简单类型参数
    Student selectEmail(String email);

    //多个简单类型参数
    List<Student> selectByNameOrAge(@Param("myName") String name,@Param("myAge") Integer age);
    //使用对象
    List<Student> selectByObject(Student student);

    //更新
    int updateStudent(Student student);

    //$符
    List<Student> QueryByNameAndId(@Param("myName") String name,@Param("colName") String colName);
}
