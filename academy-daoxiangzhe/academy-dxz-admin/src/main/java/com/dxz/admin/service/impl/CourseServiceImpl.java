package com.dxz.admin.service.impl;

import com.dxz.admin.dao.CourseMapper;
import com.dxz.admin.dao.UserMapper;
import com.dxz.admin.pojo.Course;
import com.dxz.admin.pojo.CourseExample;
import com.dxz.admin.pojo.User;
import com.dxz.admin.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    CourseMapper courseMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public List<Course> findCourseListSearch(Course course) {
        List<Course> courses = courseMapper.findCourseListSearch(course);
        log.info("查询的用户列表长度：{}",courses.size());
        return courses;
    }

    @Override
    public Long addCourse(Course course) {
        // 视频状态，1为上架，2为下架，默认为2
        course.setStatus(2);
        course.setCollectSum(0L);
        course.setLoveSum(0L);

        course.setUpdateId(course.getCreateId());
        course.setCreateAt(System.currentTimeMillis());
        course.setUpdateAt(System.currentTimeMillis());
        int aa = courseMapper.insertSelective(course);
        log.info("插入视频ID：{}",course.getId());

        return course.getId();
    }

    @Override
    public Boolean deleteCourse(Long id) {
        int row = courseMapper.deleteByPrimaryKey(id);
        if(row > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean updateCourse(Course course) {
        course.setUpdateAt(System.currentTimeMillis());
        int row = courseMapper.updateByPrimaryKeySelective(course);
//        log.info("编辑视频行数：{}",row);
        if(row > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Course> findCountVideo(Course course){
        // 根据视频条件，title、sort、status，查询
        List<Course> courses = courseMapper.findCountVideo(course);
        return courses;
    }
}
