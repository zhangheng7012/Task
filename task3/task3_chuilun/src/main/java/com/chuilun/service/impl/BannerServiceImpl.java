package com.chuilun.service.impl;

import com.chuilun.dao.BannerMapper;
import com.chuilun.pojo.Banner;
import com.chuilun.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public boolean insert(Banner banner) {
        int i = bannerMapper.insert(banner);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Banner> selectBannerByStatus(Boolean status) {
        List<Banner> banners = bannerMapper.selectBannerByStatus(status);
        return banners;
    }

    @Override
    public String selectUrlById(Integer id) {
        String url = bannerMapper.selectUrlById(id);
        return url;
    }
}
