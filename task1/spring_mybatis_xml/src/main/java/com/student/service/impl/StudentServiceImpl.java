package com.student.service.impl;

import com.student.pojo.Students;
import com.student.service.StudentService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    // 也可用 @Autowired
    @Resource
    private SqlSessionTemplate sqlSession;

    @Override
    public Integer addStudent(Students student) {
        sqlSession.insert("com.student.dao.StudentMapper.insertStudent", student);
        return student.getId();
    }

    @Override
    public Students findStuById(int id) {
        Students student = sqlSession.selectOne("com.student.dao.StudentMapper.selectStuById", id);
        Date date = new Date(student.getCreateAt());
        Date date1 = new Date(student.getUpdateAt());
        Date date2 = new Date(student.getDate());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        student.setCreateAtStr(sdf.format(date));
        student.setUpdateAtStr(sdf.format(date1));
        student.setDateStr(sdf.format(date2));
        return student;
    }

    @Override
    public List<Students> findStuByName(String name) {
        List<Students> student = sqlSession.selectList("com.student.dao.StudentMapper.selectStuByName", name);
        return student;
    }

    @Override
    public boolean updateStudent(Students student) {
        int i = sqlSession.update("com.student.dao.StudentMapper.updateStudent", student);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        int i = sqlSession.delete("com.student.dao.StudentMapper.deleteStudent", id);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }
}