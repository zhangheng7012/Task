package com.jnshu.service;

import com.jnshu.pojo.Direction;

import java.util.List;

public interface DirectionService {
    // 插入
    boolean insert(Direction direction);
    // 按开发方向查询
    List<Direction> selectByDirection(String direction);
}
