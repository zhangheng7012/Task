package com.chuilun.service;

import com.chuilun.pojo.Studio;

import java.util.List;

public interface StudioService {
    // 插入工作室简介
    boolean insert(Studio studio);
    // 根据工作室简介状态，是否上架，查询
    List<Studio> selectStudioByStatus(Boolean status);
}
