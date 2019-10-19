package com.ssm.service;

import com.ssm.pojo.Student;

import java.util.List;

public interface StudentService {

    public void insertStudent(Student student);

    public Student selectStuById(Integer id);

    public List<Student> list();

    public void updateStudent(Student student);

    public void deleteStudent(Student student);
}
