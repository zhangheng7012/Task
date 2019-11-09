package com.chuilun.controller;

import com.chuilun.pojo.ArtWork;
import com.chuilun.service.WorkService;
import com.chuilun.util.ImageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WorkController {

    private static final Logger logger = Logger.getLogger("WorkController");

    @Autowired
    private WorkService workService;

    // 首页搜索，根据名称、内容的关键词、上下架状态查询作品
    @RequestMapping(value = "/works/word",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> listWork(
            @RequestParam(required = false,defaultValue = "1",value = "pn")Integer pageNum,String word){
        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pageNum,5);

        Map<String,Object> map = new HashMap<>();
        map.put("name",word);
        map.put("brief",word);
        map.put("status",true);
        List<ArtWork> list = workService.selectByWord(map);

        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(list);

        Map<String,Object> map2 = new HashMap<>();
        // 判断list集合不为空，且集合内元素不为空
        if (list != null && !list.isEmpty()){
            map2.put("code","1");
            map2.put("message","查询成功");
            map2.put("data",pageInfo);
        }else {
            map2.put("code", "0");
            map2.put("message", "查询失败");
            map2.put("data",null);
        }
        return map2;
    }

    // 首页根据标题名称、上下架状态查询作品
    @RequestMapping(value = "/works/{worksId}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> listWorkByWorksId(
            @RequestParam(required = false,defaultValue = "1",value = "pn")Integer pageNum,
            @PathVariable(value = "worksId") Integer worksId){

        PageHelper.startPage(pageNum,5);

        Map<String,Object> map = new HashMap<>();
        map.put("worksId",worksId);
        map.put("status",true);
        List<ArtWork> list = workService.selectByWorksId(map);

        PageInfo pageInfo = new PageInfo<>(list);

        Map<String,Object> map2 = new HashMap<>();
        // 判断list集合不为空，且集合内元素不为空
        if (list != null && !list.isEmpty()){
            map2.put("code","1");
            map2.put("message","查询成功");
            map2.put("data",pageInfo);
        }else {
            map2.put("code", "0");
            map2.put("message", "查询失败");
            map2.put("data",null);
        }
        return map2;
    }

    // 添加作品信息，上传图片，前端返回work信息，所属作品集id
    // 因为multipartFile需要用form-data格式表单处理数据，这里work就不需要用@RequestBody注解
    @RequestMapping(value = "/work",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> addWork(@Validated @ModelAttribute("work") ArtWork work,
                                      BindingResult bindingResult, MultipartFile multipartFile,
                                      @RequestParam(value = "worksId",required = false)Integer worksId) throws IOException {
        //获取校验的错误信息
        if(bindingResult.hasErrors()){
            // 输出错误信息，此处可直接返回jsp页面
//            List<ObjectError> allErrors = bindingResult.getAllErrors();
            Map<String,String> map = new HashMap<>();
            // 对错误集合进行遍历，获得错误变量名：getField()，获得错误信息：getDefaultMessage()
            // map集合中: 错误变量名，错误信息；例如 username -‘用户名不能为空’
            List<FieldError> allErrors = bindingResult.getFieldErrors();
            for (FieldError allError : allErrors) {
                // 获得错误变量名：getField()，获得错误信息：getDefaultMessage()
                map.put(allError.getField(),allError.getDefaultMessage());
            }
            // 出错则返回map集合
            return map;
        }

        // 调用 ImageUtil 类的图片上传方法，返回图片的上传路径
        String imageName = ImageUtil.upload(multipartFile);

        work.setName(work.getName());
        work.setBrief(work.getBrief());
        work.setThumbnail(work.getThumbnail());
        work.setVideo(work.getVideo());
        work.setUpdateBy(work.getUpdateBy());

        // 将图片的上传路径保存到数据库
        work.setOriginal(imageName);

        work.setWorksId(worksId);
        // 作品默认为下架状态，false
        work.setStatus(false);
        work.setCreateAt(System.currentTimeMillis());
        work.setUpdateAt(System.currentTimeMillis());

        Boolean flag = workService.insert(work);

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

    // 根据作品id查询作品信息
    @RequestMapping(value = "/work/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectWorkByWorkId(@PathVariable(value = "id") Integer id){

        ArtWork work = workService.selectByPrimaryKey(id);

        Map<String,Object> map = new HashMap<>();
        // 判断work不为空
        if (work != null){
            map.put("code","1");
            map.put("message","查询成功");
            map.put("data",work);
        }else {
            map.put("code", "0");
            map.put("message", "查询失败");
            map.put("data",null);
        }
        return map;
    }
}
