package com.jnshu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import com.jnshu.util.JedisUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    private static final Logger logger = Logger.getLogger("StudentController");

    @Autowired
    StudentService studentService;

    private JedisUtil jedisUtil = new JedisUtil();

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

    @RequestMapping(value = "/homeRedis",method = RequestMethod.GET )
    public String selectAllRedis(Model model){

        List<Student> ExcStudents =null;
        // 查看缓存是否有信息
        if(jedisUtil.exists("ExcStudents")){
            // 从缓存取出信息，转为list集合
            ExcStudents = JSON.parseArray(jedisUtil.get("ExcStudents"), Student.class);
            logger.info("=====从缓存取出信息");

        }else {
            // 缓存没有信息，则查询数据库
            ExcStudents = studentService.selectAll();
            // 转为json字符串
            String json = JSON.toJSONString(ExcStudents);
            // 将json字符串存入缓存
            jedisUtil.set("ExcStudents",json);
            logger.info("=====从数据库取出信息");

        }
        model.addAttribute("students",ExcStudents);
        return "homePage";
    }

    @RequestMapping(value = "/homeRedisJson",method = RequestMethod.GET )
    @ResponseBody
    public List<Student> selectAllRedisJson2(){

        List<Student> ExcStudents =null;
        // 查看缓存是否有信息
        if(jedisUtil.exists("ExcStudents")){
            // 从缓存取出信息，转为list集合
            ExcStudents = JSON.parseArray(jedisUtil.get("ExcStudents"), Student.class);
            logger.info("=====从缓存取出信息");
        }else {
            // 缓存没有信息，则查询数据库
            ExcStudents = studentService.selectAll();
            // 转为json字符串
            String json = JSON.toJSONString(ExcStudents);
            // 将json字符串存入缓存
            jedisUtil.set("ExcStudents",json);
            logger.info("=====从数据库取出信息");
        }
        return ExcStudents;
    }

    @RequestMapping(value = "/homeRedisJson2",method = RequestMethod.GET )
    @ResponseBody
    public JSONArray selectAllRedisJson(){
        List<Student> ExcStudents =null;
        JSONArray jsonArray;
        String json;
        // 查看缓存是否有信息
        if(jedisUtil.exists("ExcStudents")){
            // 从缓存取出信息，转为list集合
            json = jedisUtil.get("ExcStudents");
            jsonArray = JSON.parseArray(json);
            logger.info("=====从缓存取出信息");
        }else {
            // 缓存没有信息，则查询数据库
            ExcStudents = studentService.selectAll();
            // 转为json字符串
            json = JSON.toJSONString(ExcStudents);
            jsonArray = JSON.parseArray(json);
            // 将json字符串存入缓存
            jedisUtil.set("ExcStudents", json);
            logger.info("=====从数据库取出信息");
        }
        return jsonArray;
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
