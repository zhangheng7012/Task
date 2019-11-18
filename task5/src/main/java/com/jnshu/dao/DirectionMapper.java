package com.jnshu.dao;

import com.jnshu.pojo.Direction;

import java.util.List;

public interface DirectionMapper {
    // 插入
    int insert(Direction direction);
    // 按开发方向查询
    List<Direction> selectByDirection(String direction);

}