package com.chuilun.controller;

import com.chuilun.pojo.Banner;
import com.chuilun.service.BannerService;
import com.chuilun.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BannerController {

    @Autowired
    BannerService bannerService;

    // 添加banner接口，因为multipartFile需要用form-data格式表单处理数据，这里banner就不需要用@RequestBody注解
    @RequestMapping(value = "/banner",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> insertBanner(Banner banner, MultipartFile multipartFile) throws IOException {
        // 调用 ImageUtil 类的图片上传方法，返回图片的上传路径
        String coverName = ImageUtil.upload(multipartFile);

        banner.setCover(coverName);

        banner.setUrl(banner.getUrl());
        banner.setUpdateBy(banner.getUpdateBy());

        banner.setStatus(false);
        banner.setCreateAt(System.currentTimeMillis());
        banner.setUpdateAt(System.currentTimeMillis());
        Boolean flag = bannerService.insert(banner);

        Map<String,String> map = new HashMap<>();
        if(flag == true){
            map.put("code","1");
            map.put("message","添加成功");
        }else {
            map.put("code","0");
            map.put("message","添加失败");
        }
        return map;
    }

    // 将上架的banner展示，最多6个
    @RequestMapping(value = "/banners",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectBannerByStatus(){
        List<Banner> banners = bannerService.selectBannerByStatus(true);
        Map<String,Object> map = new HashMap<>();
        // 判断list集合不为空，且集合内元素不为空
        if (banners != null && !banners.isEmpty()){
            map.put("code","1");
            map.put("message","查询成功");
            map.put("data",banners);
        }else {
            map.put("code", "0");
            map.put("message", "查询失败");
            map.put("data",null);
        }
        return map;
    }

    // 根据banner的id，查询对应的作品url，进而查看作品
    @RequestMapping(value = "/banner/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectUrlById(@PathVariable Integer id){
        String bannerUrl = bannerService.selectUrlById(id);
        Map<String,Object> map = new HashMap<>();
        // 判断string不为空，且去除空格的string不是空字符串，trim方法是截取非空格的字符串
        if (bannerUrl != null && !"".equals(bannerUrl.trim())){
            map.put("code","1");
            map.put("message","查询成功");
            map.put("data",bannerUrl);
        }else {
            map.put("code", "0");
            map.put("message", "查询失败");
            map.put("data",null);
        }
        return map;
    }
}
