package com.chuilun.service.impl;

import com.chuilun.dao.ArtWorkMapper;
import com.chuilun.pojo.ArtWork;
import com.chuilun.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    ArtWorkMapper workMapper;

    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        int i = workMapper.deleteByPrimaryKey(id);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean insert(ArtWork work) {
        int i = workMapper.insert(work);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<ArtWork> selectByWord(Map<String, Object> mapWord) {
        List<ArtWork> works = workMapper.selectByWord(mapWord);
        return works;
    }

    @Override
    public List<ArtWork> selectByWorksId(Map<String, Object> mapWorks) {
        List<ArtWork> works = workMapper.selectByWorksId(mapWorks);
        return works;
    }

    @Override
    public ArtWork selectByPrimaryKey(Integer id) {
        ArtWork work = workMapper.selectByPrimaryKey(id);
        return work;
    }

}
