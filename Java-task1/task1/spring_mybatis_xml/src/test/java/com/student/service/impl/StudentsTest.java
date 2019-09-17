package com.student.service.impl; 

import com.student.pojo.Students;
import com.student.service.StudentService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/** 
* @Author : zhangheng
* @Date : 09/15/2019
*/

public class StudentsTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    StudentService studentService = (StudentService) context.getBean("studentServiceImpl");

    /**
     *  插入数据
     */
    @Test
    public void testAddStudent() throws Exception {

        Students student = new Students();

        student.setCreateAt(System.currentTimeMillis());
        student.setUpdateAt(System.currentTimeMillis());

        student.setName("中国奥运会直通");
        student.setQq(121212121);
        student.setJob("JAVA工程师");
        /*
            将字符串日期，先转为Date类型，再转为Long类型，插入
            实体类类型为Long，表格字段类型为bigint
        */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse("2008-09-10 11:11:11");
            student.setDate(date.getTime());
        } catch (ParseException e) {
            System.out.println("有异常了！");
        } finally {
            System.out.println("必经之路");
        }
        student.setSchool("北京体育大学");
        student.setOnlineNum(666666);
        student.setDaily("www.jnshu.com");
        student.setDream("总冠军");
        student.setBrother("吉诺比利");
        student.setKnowHow("NBA职业学院");
        int i = studentService.addStudent(student);
        System.out.println("插入成功" + "\n" + "插入ID为：" + i);
    }

    /**
     *  查，根据ID，将时间戳转为日期格式
     */
    @Test
    public void testFindStuById() throws Exception {
        System.out.println(studentService.findStuById(66));
    }

    /**
     *  查，根据姓名
     */
    @Test
    public void testFindStuByName() throws Exception {
        List<Students> student = studentService.findStuByName("威少");
        for (Students a : student) {
            System.out.println(a);
        }
    }

    /**
     *  改
     */
    @Test
    public void testUpdateStudent() throws Exception {
        Students student = new Students();
        student.setName("中国队");
        student.setQq(111111);
        student.setId(7);
        boolean a = studentService.updateStudent(student);
        System.out.println("是否成功修改：" + a);
    }

    /**
     *  删
     */
    @Test
    public void testDeleteStudent() throws Exception {
        boolean a = studentService.deleteStudent(32);
        System.out.println("是否成功删除：" + a);
    }
} 
