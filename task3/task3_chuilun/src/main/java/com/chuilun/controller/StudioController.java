package com.chuilun.controller;

import com.chuilun.pojo.Studio;
import com.chuilun.service.StudioService;
import com.chuilun.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Controller
public class StudioController {

    @Autowired
    private StudioService studioService;

    // 添加工作室简介，5个图片上传，因为multipartFile需要用form-data格式表单处理数据，这里studio就不需要用@RequestBody注解
    @RequestMapping(value = "/studio",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> insertStudio(Studio studio,
                           @RequestParam(value = "multipartFile")MultipartFile[] multipartFile) throws IOException {

        studio.setName(studio.getName());
        studio.setUpdateBy(studio.getUpdateBy());

        studio.setStatus(false);
        List<String> imagesPathList = new ArrayList<>();
        for (MultipartFile file : multipartFile) {
            // 调用 ImageUtil 类的图片上传方法，返回图片的上传路径
            String pictureName = ImageUtil.upload(file);
            // 将图片地址添加入list集合中，最多5个地址
            imagesPathList.add(pictureName);
        }
        // 将list集合转为String类型存储数据库
        String picture = String.join("," , imagesPathList);
        studio.setPicturePath(picture);

        // 将String类型转为list集合，输出查看
        List<String> listString = Arrays.asList(picture.split(","));
        for (String string : listString) {
            System.out.println(string);
         }

        studio.setCreateAt(System.currentTimeMillis());
        studio.setUpdateAt(System.currentTimeMillis());
        Boolean flag = studioService.insert(studio);

        Map<String,String> map = new HashMap<>();
        if (flag == true){
            map.put("code","1");
            map.put("message","添加成功");
        }else {
            map.put("code", "0");
            map.put("message", "添加失败");
        }
        return map;
    }

    // 根据上架状态，查看工作室简介
    @RequestMapping(value = "/studios",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectStudioByStatus(){
        List<Studio> studios = studioService.selectStudioByStatus(true);
        Map<String,Object> map = new HashMap<>();
        // 判断list集合不为空，且集合内元素不为空
        if (studios != null && !studios.isEmpty()){
            map.put("code","1");
            map.put("message","查询成功");
            map.put("data",studios);
        }else {
            map.put("code", "0");
            map.put("message", "查询失败");
            map.put("data",null);
        }
        return map;
    }
}
