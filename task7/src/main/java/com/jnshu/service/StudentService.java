package com.jnshu.service;

import com.jnshu.pojo.Student;

import java.util.List;

public interface StudentService {
    // 插入数据
    boolean insertStudent(Student student);
    // 整体查询，工资前八
    List<Student> selectAll();
}
