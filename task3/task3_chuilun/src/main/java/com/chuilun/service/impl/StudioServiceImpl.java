package com.chuilun.service.impl;

import com.chuilun.dao.StudioMapper;
import com.chuilun.pojo.Studio;
import com.chuilun.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioServiceImpl implements StudioService {

    @Autowired
    StudioMapper studioMapper;

    @Override
    public boolean insert(Studio studio) {
        int i = studioMapper.insert(studio);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Studio> selectStudioByStatus(Boolean status) {
        List<Studio> studios = studioMapper.selectStudioByStatus(status);
        return studios;
    }
}
