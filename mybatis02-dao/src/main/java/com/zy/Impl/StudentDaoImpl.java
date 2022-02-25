package com.zy.Impl;

import com.zy.dao.StudentDao;
import com.zy.domain.Student;
import com.zy.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public Student selectById(Integer id) {
        SqlSession session = MyBatisUtils.getSqlSession();
        String sqlId = "com.zy.dao.StudentDao.selectById";
        Student student = session.selectOne(sqlId,id);
        return student;
    }

    @Override
    public List<Student> selectStudents() {
        //1.获取SQLSession
        SqlSession session = MyBatisUtils.getSqlSession();
        //2.指定sqlId
        String sqlId = "com.zy.dao.StudentDao.selectStudents";
        //3.执行SQLSession方法，并执行sql语句
        List<Student> students =session.selectList(sqlId);

        //4.关闭SqlSession对象
        session.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        //1.获取SQLSession
        SqlSession session = MyBatisUtils.getSqlSession();
        //2.指定sqlId
        String sqlId = "com.zy.dao.StudentDao.insertStudent";
        //3.执行SQLSession方法，并执行sql语句
        int rows =session.insert(sqlId,student);
        System.out.println("添加的行数rows为：" + rows);
        session.commit();
        //4.关闭SqlSession对象
        session.close();
        return rows;
    }
}
