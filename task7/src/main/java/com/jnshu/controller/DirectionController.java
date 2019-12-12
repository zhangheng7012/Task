package com.jnshu.controller;

import com.alibaba.fastjson.JSON;
import com.jnshu.pojo.Direction;
import com.jnshu.service.DirectionService;
import com.jnshu.util.JedisUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DirectionController {

    private static final Logger logger = Logger.getLogger("DirectionController");

    @Autowired
    private DirectionService directionService;

    private JedisUtil jedisUtil = new JedisUtil();

    @RequestMapping(value = "/u/job",method = RequestMethod.GET )
    public String selectByDirection(Model model){

        List<Direction> javaList = directionService.selectByDirection("后端方向");
        for (Direction java : javaList) {
            System.out.println(java);
        }
        List<Direction> webList = directionService.selectByDirection("前端方向");
        for (Direction web : webList) {
            System.out.println(web);
        }
        List<Direction> iosList = directionService.selectByDirection("移动方向");
        for (Direction ios : iosList) {
            System.out.println(ios);
        }
        List<Direction> allList = directionService.selectByDirection("整站方向");
        for (Direction all : allList) {
            System.out.println(all);
        }
        List<Direction> opList = directionService.selectByDirection("运维方向");
        for (Direction op : opList) {
            System.out.println(op);
        }
        model.addAttribute("javaList",javaList);
        model.addAttribute("webList",webList);
        model.addAttribute("iosList",iosList);
        model.addAttribute("allList",allList);
        model.addAttribute("opList",opList);
        return "jobPage";
    }

    @RequestMapping(value = "/jobRedis",method = RequestMethod.GET )
    public String selectByDirection2(Model model){

        List<Direction> javaList = null;
        // 查看缓存是否有信息
        if(jedisUtil.exists("javaList")) {
            javaList = JSON.parseArray(jedisUtil.get("javaList"), Direction.class);
            logger.info("=====从缓存取出信息");
        }else {
            // 缓存没有信息，则查询数据库
            javaList = directionService.selectByDirection("后端方向");
            // 转为json字符串
            String json = JSON.toJSONString(javaList);
            // 将json字符串存入缓存
            jedisUtil.set("javaList",json);
            logger.info("=====从数据库取出信息");
        }

        List<Direction> webList = null;
        // 查看缓存是否有信息
        if(jedisUtil.exists("webList")) {
            webList = JSON.parseArray(jedisUtil.get("webList"), Direction.class);
            logger.info("=====从缓存取出信息");
        }else {
            // 缓存没有信息，则查询数据库
            webList = directionService.selectByDirection("前端方向");
            String json1 = JSON.toJSONString(webList);
            // 将json字符串存入缓存
            jedisUtil.set("webList",json1);
            logger.info("=====从数据库取出信息");
        }

        List<Direction> iosList = null;
        // 查看缓存是否有信息
        if(jedisUtil.exists("iosList")) {
            iosList = JSON.parseArray(jedisUtil.get("iosList"), Direction.class);
            logger.info("=====从缓存取出信息");
        }else {
            // 缓存没有信息，则查询数据库
            iosList = directionService.selectByDirection("移动方向");
            // 转为json字符串
            String json2 = JSON.toJSONString(iosList);
            // 将json字符串存入缓存
            jedisUtil.set("iosList",json2);
            logger.info("=====从数据库取出信息");
        }

        List<Direction> allList = null;
        // 查看缓存是否有信息
        if(jedisUtil.exists("allList")) {
            allList = JSON.parseArray(jedisUtil.get("allList"), Direction.class);
            logger.info("=====从缓存取出信息");
        }else {
            // 缓存没有信息，则查询数据库
            allList = directionService.selectByDirection("整站方向");
            // 转为json字符串
            String json3 = JSON.toJSONString(allList);
            // 将json字符串存入缓存
            jedisUtil.set("allList",json3);
            logger.info("=====从数据库取出信息");
        }

        List<Direction> opList = null;
        // 查看缓存是否有信息
        if(jedisUtil.exists("opList")) {
            opList = JSON.parseArray(jedisUtil.get("opList"), Direction.class);
            logger.info("=====从缓存取出信息");
        }else {
            // 缓存没有信息，则查询数据库
            opList = directionService.selectByDirection("运维方向");
            // 转为json字符串
            String json4 = JSON.toJSONString(opList);
            // 将json字符串存入缓存
            jedisUtil.set("opList",json4);
            logger.info("=====从数据库取出信息");
        }

        model.addAttribute("javaList",javaList);
        model.addAttribute("webList",webList);
        model.addAttribute("iosList",iosList);
        model.addAttribute("allList",allList);
        model.addAttribute("opList",opList);
        return "jobPage";
    }
}
