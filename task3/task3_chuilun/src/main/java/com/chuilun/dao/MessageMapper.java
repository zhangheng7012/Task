package com.chuilun.dao;

import com.chuilun.pojo.Message;

import java.util.List;
import java.util.Map;

public interface MessageMapper {
    // 插入留言
    int insert(Message message);
    // 根据作品id、留言状态，查询父留言
    public List<Message> selectParentByWorkId(Map<String,Object> mapWorkId);
    // 根据父留言id，查询子留言
    public List<Message> selectReplyByParentId(Integer parentMessageId);
}