package com.zy.dao;

import com.zy.domain.Student;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    //查询学生信息
    Student selectById(Integer id);


    //查询个数
    Long CountStudent();

    //Map
    Map<Object,Object> selectMap(@Param("studId") Integer id);

    //like
    List<Student> selectLikeOne(@Param("name") String name);
}
