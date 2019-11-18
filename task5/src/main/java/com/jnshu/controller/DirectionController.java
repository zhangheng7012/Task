package com.jnshu.controller;

import com.jnshu.pojo.Direction;
import com.jnshu.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DirectionController {

    @Autowired
    private DirectionService directionService;

    @RequestMapping(value = "/u/job",method = RequestMethod.GET )
    public ModelAndView selectByDirection(ModelAndView mav){

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
        mav.addObject("javaList",javaList);
        mav.addObject("webList",webList);
        mav.addObject("iosList",iosList);
        mav.addObject("allList",allList);
        mav.addObject("opList",opList);
        mav.setViewName("jobPage");
        return mav;
    }
}
