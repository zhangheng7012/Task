package com.dxz.admin.dao;

import com.dxz.admin.pojo.Course;
import com.dxz.admin.pojo.CourseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    // 根据视频条件查询，无条件则查询列表
    List<Course> findCourseListSearch(Course course);
    // 根据视频条件，title、sort、status，查询
    List<Course> findCountVideo(Course course);

    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}