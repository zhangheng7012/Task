package com.chuilun.controller;

import com.chuilun.pojo.Message;
import com.chuilun.service.MessageService;
import com.chuilun.util.MessageUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MessageController {

    private static final Logger logger = Logger.getLogger("MessageController");

    @Autowired
    private MessageService messageService;

    // 根据作品id查询对应的留言、回复，递归遍历，前端返回作品id
    @RequestMapping(value = "/work/message/{workId}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectMessageByWorkId(@PathVariable(value = "workId") Integer workId){
        Map<String,Object> map = new HashMap<>();
        map.put("workId",workId);
        map.put("parentMessageId",0);
        map.put("status",true);
        // 根据作品id、父留言id为0、上下架状态，查询父留言
        List<Message> messages = messageService.selectParentByWorkId(map);
        // 遍历所有父留言
        for (Message message : messages) {
            // 创建父留言的装载下级回复的集合
            List<Message> replies = new ArrayList<>();
            // 设置父留言装载下级回复的集合
            message.setReplies(replies);
            // 调用util类方法，根据父留言id查询对应的子回复集合，递归遍历
            MessageUtil.findReplyByMessageId(message,replies);
        }
        logger.info("留言为" + messages);

        Map<String,Object> map2 = new HashMap<>();
        // 判断list集合不为空，且集合内元素不为空
        if (messages != null && !messages.isEmpty()){
            map2.put("code","1");
            map2.put("message","查询成功");
            map2.put("data",messages);
        }else {
            map2.put("code", "0");
            map2.put("message", "查询失败");
            map2.put("data",null);
        }
        return map2;
    }

    // 在作品详情页面，插入留言，前端返回作品id、名称，父留言id(默认为0)，以及message对象
    @RequestMapping(value = "/work/message",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> insertMessage(@RequestBody Message message, String workId, String workName,
                                @RequestParam(value = "parentMessageId",required = false,defaultValue = "0")String parentMessageId) {
        // 前端返回作品id、名称
        message.setWorkId(Integer.parseInt(workId));
        message.setWorkName(workName);
        // 如果前端返回不为0，代表存在父留言，即该留言类型为回复，默认返回0
        message.setParentMessageId(Integer.parseInt(parentMessageId));

        // 入参里的message是添加的message，前台已填写留言内容，此处不需要再set
        message.setMessage(message.getMessage());
        message.setUpdateBy(message.getUpdateBy());

        // 调用工具类方法，昵称随机生成，但是这里只是留言者昵称
        // 被留言者昵称，需前端获取留言名称，在页面显示，没有则是评论作品
        message.setName(MessageUtil.buildName());
        // 留言默认是普通留言，即false
        message.setStatus(false);
        message.setCreateAt(System.currentTimeMillis());
        message.setUpdateAt(System.currentTimeMillis());

        // 添加留言/回复
        boolean flag = messageService.insert(message);
        Map<String,String> map =new HashMap<>();
        if(flag==true){
            map.put("code","1");
            map.put("message","保存信息成功");
        }else {
            map.put("code","0");
            map.put("message","保存信息失败");
        }
        return map;
    }
}
