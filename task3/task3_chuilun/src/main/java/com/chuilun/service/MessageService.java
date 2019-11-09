package com.chuilun.service;

import com.chuilun.pojo.Message;

import java.util.List;
import java.util.Map;

public interface MessageService {
    // 插入留言
    boolean insert(Message message);
    // 根据作品id，查询留言
    List<Message> selectParentByWorkId(Map<String, Object> mapWorkId);
    // 根据父留言id，查询子留言
    List<Message> selectReplyByParentId(Integer parentMessageId);
}
