package com.chuilun.controller;

import com.chuilun.pojo.Works;
import com.chuilun.service.WorksService;
import com.chuilun.util.WorksUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WorksController {

    private static final Logger logger = Logger.getLogger("WorkController");

    @Autowired
    WorksService worksService;

    // 添加作品集，参数绑定父作品集id，没有就默认为0，即一级作品集
    @RequestMapping(value = "/works",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> add(@RequestBody Works works,
              @RequestParam(value = "parentWorksId",required = false,defaultValue = "0")Integer parentWorksId) {

        Map<String,String> map = new HashMap<>();
        works.setName(works.getName());
        works.setUpdateBy(works.getUpdateBy());

        // 父作品集id，默认为0，即一级作品集
        works.setParentWorksId(parentWorksId);
        works.setStatus(false);
        works.setCreateAt(System.currentTimeMillis());
        boolean flag = worksService.insert(works);
        if (flag == true) {
            map.put("code", "1");
            map.put("message", "保存信息成功");
        } else {
            map.put("code", "0");
            map.put("message", "保存信息失败");
        }
        return map;
    }

    // 根据父作品集id、上下架状态查询对应的一级、二级作品集
    @RequestMapping(value = "/works",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectWorksByParentId(){
        Map<String,Object> map = new HashMap<>();
        // 父作品集id为0，一级作品集
        map.put("parentWorksId",0);
        map.put("status",true);
        // 根据父作品集id0、上下架状态，查询一级作品集
        List<Works> list = worksService.selectWorksByParentId(map);
        // 遍历所有一级作品集
        for (Works works : list) {
            // 创建一级作品集的装载二级作品集的集合
            List<Works> secWorks = new ArrayList<>();
            // 设置一级作品集装载二级作品集的集合
            works.setSecWorks(secWorks);
            // 调用util类方法，根据父作品集id查询对应的二级作品集集合
            WorksUtil.findWorksByParentId(worksService,works,secWorks);
        }
        Map<String,Object> map2 = new HashMap<>();
        // 判断list集合不为空，且集合内元素不为空
        if (list != null && !list.isEmpty()){
            map2.put("code","1");
            map2.put("message","查询成功");
            map2.put("data",list);
        }else {
            map2.put("code", "0");
            map2.put("message", "查询失败");
            map2.put("data",null);
        }
        return map2;
    }

}
