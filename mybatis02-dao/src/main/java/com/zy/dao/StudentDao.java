package com.zy.dao;

import com.zy.domain.Student;

import java.util.List;

public interface StudentDao {
    //查询学生信息
    Student selectById(Integer id);
    //查询多个学生信息
    List<Student> selectStudents();
    //添加学生信息
    int insertStudent(Student student);
}
