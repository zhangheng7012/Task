package com.student.service;

import com.student.pojo.Students;

import java.util.List;

public interface StudentService {

    public Integer addStudent(Students student);

    public Students findStuById(int id);

    public List<Students> findStuByName(String name);

    public boolean updateStudent(Students student);

    public boolean deleteStudent(int id);

}
