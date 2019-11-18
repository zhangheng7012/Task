package com.jnshu.dao;

import com.jnshu.pojo.Student;

import java.util.List;

public interface StudentMapper {
    // 插入数据
    int insertStudent(Student student);
    // 整体查询，工资前八
    List<Student> selectAll();
}