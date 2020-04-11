package com.dxz.home.dao;

import com.dxz.home.pojo.Course;
import com.dxz.home.pojo.CourseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    // 根据视频条件查询，无条件则查询列表
    List<Course> findCourseListSearch(Course course);

    List<Course> findCourseList();

    List<Course> findCourseBanner(Course course);

    List<Course> courseCollectList(Course course);

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