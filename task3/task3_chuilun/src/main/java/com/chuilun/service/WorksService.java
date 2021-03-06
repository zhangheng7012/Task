package com.chuilun.service;

import com.chuilun.pojo.Works;

import java.util.List;
import java.util.Map;

public interface WorksService {
    // 插入作品集
    Boolean insert(Works works);
    // 根据父作品集id、作品集状态，查询一级、二级作品集
    List<Works> selectWorksByParentId(Map<String, Object> mapParentId);
}
