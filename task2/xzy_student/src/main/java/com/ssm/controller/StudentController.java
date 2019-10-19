package com.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.pojo.Student;
import com.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

/*    跳转到json.jsp页面，显示set的数据
    @RequestMapping(value = "/students/json",method = RequestMethod.GET)
    public ModelAndView json(ModelAndView mav){
        Student stu = new Student();
        stu.setId(33);
        stu.setName("转换json");
        mav.addObject("stu",stu);
        mav.setViewName("json");
        return mav;
    }*/

/*    通过addStudent.jsp页面，添加数据，跳到json.jsp页面，显示数据
    @RequestMapping(value = "/students/student",method = RequestMethod.GET)
    public ModelAndView jsongo(ModelAndView mav){
        mav.setViewName("addStudent");
        return mav;
    }

    @RequestMapping(value = "/students/json",method = RequestMethod.POST)
    public ModelAndView jsonadd(Student student,ModelAndView mav){
        Student stu = new Student();
        stu.setQq(student.getQq());
        stu.setName(student.getName());
        stu.setJob(student.getJob());
        mav.addObject("stu",stu);
        mav.setViewName("json");
        return mav;
    }*/

    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public ModelAndView list(
            @RequestParam(required = false,defaultValue = "1",value = "pn")Integer pageNum,ModelAndView mav){
        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pageNum,5);

        //startPage后紧跟的这个查询就是分页查询
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        List<Student> list = studentService.list();
        PageInfo pageInfo = new PageInfo<>(list);

/*
        ModelAndView mav = new ModelAndView();
*/
        // 放入转发参数
        mav.addObject("pageInfo", pageInfo);
        // 放入jsp路径
        mav.setViewName("listStudent");
        return mav;
    }
    @RequestMapping(value = "/students/student",method = RequestMethod.GET)
    public ModelAndView addGo(ModelAndView mav){
/*
        ModelAndView mav = new ModelAndView("addStudent");
*/
        mav.setViewName("addStudent");
        return mav;
    }
/*    @RequestMapping(value = "/students",method = RequestMethod.POST)
    public ModelAndView add(Student student,ModelAndView mav){
        studentService.insertStudent(student);
        mav.setViewName("redirect:/students");
        return mav;
    }*/

    //在需要校验的pojo前，添加@Validated，在需要校验的pojo后添加BindingResult bindingResult接收校验出错信息
    //注意！！@Validated和BindingResult bindingResult 是配对出现的，并且在形参里的顺序是固定的（一前一后）
    @RequestMapping(value = "/students",method = RequestMethod.POST)
    public ModelAndView add(@Validated @ModelAttribute("student") Student student,
                                    BindingResult bindingResult){

        ModelAndView mav = new ModelAndView();
        //获取校验的错误信息
        if(bindingResult.hasErrors()){
/*           // 输出错误信息，此处可用在有单独错误信息jsp的地方
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            System.out.println("你说"+allErrors);
            //将错误信息传至页面
            mav.addObject("allErrors",allErrors);*/
            mav.setViewName("addStudent");
            //出错则重新至添加页面
            return mav;
        }
        //调用service添加
        studentService.insertStudent(student);
        mav.setViewName("redirect:/students");
        return mav;
    }

    @RequestMapping(value = "/students/{id}",method = RequestMethod.DELETE)
    public ModelAndView delete(Student student,ModelAndView mav){
        studentService.deleteStudent(student);
        mav.setViewName("redirect:/students");
        return mav;
    }
    @RequestMapping(value = "/students/{id}",method = RequestMethod.GET)
    public ModelAndView updateGo(Student student,ModelAndView mav){
        Student stu= studentService.selectStuById(student.getId());
        mav.addObject("student", stu);
        mav.setViewName("updateStudent");
        return mav;
    }
    @RequestMapping(value = "/students/{id}",method = RequestMethod.PUT)
    public ModelAndView update(Student student,ModelAndView mav){
        studentService.updateStudent(student);
        mav.setViewName("redirect:/students");
        return mav;
    }

/*    @RequestMapping(value = "/students/{id}",method = RequestMethod.PUT)
    public ModelAndView update(@Validated @ModelAttribute("student") Student student,
                            BindingResult bindingResult){

        ModelAndView mav = new ModelAndView();
        //获取校验的错误信息
        if(bindingResult.hasErrors()){
            mav.setViewName("updateStudent");
            //出错则重新至更新页面
            return mav;
        }
        studentService.updateStudent(student);
        mav.setViewName("redirect:/students");
        return mav;
    }*/
}
