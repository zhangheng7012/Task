package com.jnshu.service.impl;

import com.jnshu.dao.DirectionMapper;
import com.jnshu.pojo.Direction;
import com.jnshu.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionServiceImpl implements DirectionService {

    @Autowired
    DirectionMapper directionMapper;

    @Override
    public boolean insert(Direction direction) {
        int i = directionMapper.insert(direction);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Direction> selectByDirection(String direction) {
        List<Direction> directions = directionMapper.selectByDirection(direction);
        return directions;
    }
}
