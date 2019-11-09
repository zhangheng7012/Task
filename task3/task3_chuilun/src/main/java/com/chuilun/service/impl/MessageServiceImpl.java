package com.chuilun.service.impl;

import com.chuilun.dao.MessageMapper;
import com.chuilun.pojo.Message;
import com.chuilun.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public boolean insert(Message message) {
        int i = messageMapper.insert(message);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Message> selectParentByWorkId(Map<String,Object> mapWorkId) {
        List<Message> messages = messageMapper.selectParentByWorkId(mapWorkId);
        return messages;
    }

    @Override
    public List<Message> selectReplyByParentId(Integer parentMessageId) {
        List<Message> messages = messageMapper.selectReplyByParentId(parentMessageId);
        return messages;
    }

}
