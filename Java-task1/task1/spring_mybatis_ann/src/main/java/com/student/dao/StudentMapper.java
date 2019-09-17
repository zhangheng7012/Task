package com.student.dao;

import com.student.pojo.Students;

import java.util.List;

public interface StudentMapper {

    public Integer insertStudent(Students student);

    public Students selectStuById(int id);

    public List<Students> selectStuByName(String name);

    public boolean updateStudent(Students student);

    public boolean deleteStudent(int id);

}
