package com.zy.dao;

import com.zy.domain.Student;

public interface StudentDao {
    //查询学生信息
    Student selectStudentById(Integer id);

    //添加学生信息
    int insertStudent(Student student);
}
