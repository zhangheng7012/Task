package com.dxz.home.service;

import com.alibaba.fastjson.JSONObject;
import com.dxz.home.pojo.Sign;
import com.dxz.home.pojo.User;

import java.util.List;

public interface UserService {

    // 根据openid查询用户是否存在
    List<User> verifyOpenId(String openid);
    // 添加用户信息
    User addUser(JSONObject user);
    // 更新用户信息
    Boolean updateUser(User user);
    // 更新用户积分
    Boolean updateUserScore(User user,Long updateScore);
    // 查看用户今日是否签到
    int todaySign(Long id);
    // 查看用户昨天是否签到
    Boolean yesterdaySign(Long id);
    // 查看用户当月签到时间戳
    List<Sign> monthSign(Long id);
    // 用户签到加分、修改签到信息
    Boolean updateSignUser(Long id);
    // 根据用户id，添加用户签到信息
    Long addSign(Long id);
}
