package com.chuilun.service.impl;

import com.chuilun.dao.WorksMapper;
import com.chuilun.pojo.Works;
import com.chuilun.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WorksServiceImpl implements WorksService {

    @Autowired
    WorksMapper worksMapper;

    @Override
    public Boolean insert(Works works) {
        int i = worksMapper.insert(works);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Works> selectWorksByParentId(Map<String, Object> mapParentId) {
        List<Works> works = worksMapper.selectWorksByParentId(mapParentId);
        return works;
    }
}
