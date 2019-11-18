package com.jnshu.controller;

import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/home",method = RequestMethod.GET )
    public ModelAndView selectAll(ModelAndView mav){

        List<Student> students = studentService.selectAll();
        for (Student student : students) {
            System.out.println(student);
        }
        mav.addObject("students",students);
        mav.setViewName("homePage");
        return mav;
    }

    @RequestMapping(value = "/u/partner",method = RequestMethod.GET )
    public ModelAndView select(ModelAndView mav){
        mav.setViewName("partner");
        return mav;
    }
    @RequestMapping(value = "/date")
    public ModelAndView date(ModelAndView mav){
        mav.setViewName("tagDate");
        return mav;
    }
}
