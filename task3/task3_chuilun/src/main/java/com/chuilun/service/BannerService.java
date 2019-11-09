package com.chuilun.service;

import com.chuilun.pojo.Banner;

import java.util.List;

public interface BannerService {
    // 插入Banner
    boolean insert(Banner banner);
    // 根据Banner状态，是否上架，查询Banner原图
    List<Banner> selectBannerByStatus(Boolean status);
    // 根据Banner的id，查询对应作品url
    String selectUrlById(Integer id);
}
