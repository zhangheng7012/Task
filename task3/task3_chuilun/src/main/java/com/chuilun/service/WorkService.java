package com.chuilun.service;

import com.chuilun.pojo.ArtWork;

import java.util.List;
import java.util.Map;

public interface WorkService {

    // 按主键删除
    boolean deleteByPrimaryKey(Integer id);
    // 插入数据
    boolean insert(ArtWork work);
    // 根据名称、内容的关键词、上下架状态查询作品
    List<ArtWork> selectByWord(Map<String,Object> mapWord);
    // 根据标题id、上下架状态查询作品
    List<ArtWork> selectByWorksId(Map<String,Object> mapWorks);
    // 按主键查询
    ArtWork selectByPrimaryKey(Integer id);

}
