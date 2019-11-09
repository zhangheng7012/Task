package com.chuilun.dao;

import com.chuilun.pojo.Studio;

import java.util.List;

public interface StudioMapper {
    // 插入工作室简介
    int insert(Studio studio);
    // 根据工作室简介状态，是否上架，查询
    List<Studio> selectStudioByStatus(Boolean status);
}