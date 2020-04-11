package com.dxz.admin.service;

import com.dxz.admin.pojo.Course;

import java.util.List;

public interface CourseService {

    // 根据视频条件查询，无条件则查询列表
    List<Course> findCourseListSearch(Course course);
    // 添加视频
    Long addCourse(Course course);
    // 根据id，删除视频
    Boolean deleteCourse(Long id);
    // 更新视频信息
    Boolean updateCourse(Course course);
    // 查看banner视频上架数量
    // 根据视频条件，title、sort、status，查询
    List<Course> findCountVideo(Course course);

}
