package com.ssm.service.impl;

import com.ssm.dao.StudentMapper;
import com.ssm.pojo.Student;
import com.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> list() {
/*        Student student = sqlSession.selectOne("com.student.dao.StudentMapper.selectStuById", id);
        Date date = new Date(student.getCreateAt());
        Date date1 = new Date(student.getUpdateAt());
        Date date2 = new Date(student.getDate());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        student.setCreateAtStr(sdf.format(date));
        student.setUpdateAtStr(sdf.format(date1));
        student.setDateStr(sdf.format(date2));*/
        return studentMapper.list();
    }

    @Override
    public void insertStudent(Student student) {
        studentMapper.insertStudent(student);
    }

    @Override
    public Student selectStuById(Integer id) {
        return studentMapper.selectStuById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentMapper.deleteStudent(student.getId());
    }
}
