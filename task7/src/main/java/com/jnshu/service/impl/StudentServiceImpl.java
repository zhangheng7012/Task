package com.jnshu.service.impl;

import com.jnshu.dao.StudentMapper;
import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public boolean insertStudent(Student student) {
        int i = studentMapper.insertStudent(student);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Student> selectAll() {
        List<Student> students = studentMapper.selectAll();
        return students;
    }

}
