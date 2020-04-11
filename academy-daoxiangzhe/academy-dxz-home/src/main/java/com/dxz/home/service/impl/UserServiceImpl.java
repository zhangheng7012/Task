package com.dxz.home.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dxz.home.dao.SignMapper;
import com.dxz.home.dao.UserMapper;
import com.dxz.home.pojo.Sign;
import com.dxz.home.pojo.SignExample;
import com.dxz.home.pojo.User;
import com.dxz.home.pojo.UserExample;
import com.dxz.home.service.UserService;
import com.dxz.home.utils.TimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserMapper userMapper;
    @Resource
    SignMapper signMapper;
    @Autowired
    TimeUtil timeUtil;

//    @Transactional
    @Override
    public User addUser(JSONObject json) {
        String name = (String) json.get("nickName");
        String avatarUrl = (String) json.get("avatarUrl");
        String openId = (String) json.get("openId");
        if(StringUtils.isBlank(name) || StringUtils.isBlank(avatarUrl) || StringUtils.isBlank(openId)){
           return null;
        }
        // 若名称过长，限制截取7位，从0开始，但是不包括末尾字符
        // 也不需要判断字符串长度，位数不够也不会报错，只是不截取了
        String nameNow = StringUtils.substring(name, 0, 7);
        User user = new User();
        user.setName(name);
        user.setAvatarUrl(avatarUrl);
        user.setOpenid(openId);

        // 用户分类，1是学生，2是老师
        user.setSort(1);
        user.setScore(0L);
        // 用户状态，1为解冻，0为冻结，默认为1
        user.setStatus(1);
        user.setSignSum(0L);
        user.setSignCon(0L);
        user.setSignNowCon(0L);
        user.setCreateAt(System.currentTimeMillis());
        // 插入后，获取id再更新信息
        user.setCreateId(1L);
        user.setUpdateId(1L);
        user.setUpdateAt(1L);
        int aa = userMapper.insertSelective(user);
        log.info("插入用户ID：{}",user.getId());

//        user.setCreateId(user.getId());
//        user.setUpdateId(user.getId());
//        Boolean result = updateUser(user);

        if(aa > 0){
            return user;
        }else {
            return null;
        }
    }

    @Override
    public List<User> verifyOpenId(String openid) {
        User user = new User();
        user.setOpenid(openid);
        // 根据openid查询，这里不是模糊查询
        List<User> users = userMapper.findUserListSearch(user);
        log.info("根据openid查找用户列表长度：{}",users.size());
        return users;
    }

    @Override
    public Boolean updateUserScore(User user, Long updateScore) {
        Long score = userMapper.selectByPrimaryKey(user.getId()).getScore();
        // updateScore可为负数
        user.setScore(score + updateScore);
        user.setUpdateAt(System.currentTimeMillis());
        int row = userMapper.updateByPrimaryKeySelective(user);
        if(row > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean updateUser(User user) {
        user.setUpdateAt(System.currentTimeMillis());
        int row = userMapper.updateByPrimaryKeySelective(user);
        if(row > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean yesterdaySign(Long id) {

        Long todayTime = timeUtil.todayZeroTime();
        Long yesterdayTime = timeUtil.yesterdayZeroTime();

        Sign sign = new Sign();
        sign.setUserId(id);
        sign.setMinSignTime(yesterdayTime);
        sign.setMaxSignTime(todayTime -1);
        // 根据用户id、时间戳范围查询，左右全闭，yesterdayTime =< x =< todayTime -1
        List<Sign> signs = signMapper.findSignTimeList(sign);
        if(signs.size() > 0){
            // 查看用户当日是否签到，未签到为0，已签到为1
            log.info("昨天是否签到：{}",true);
            return true;
        }else {
            log.info("昨天是否签到：{}",false);
            return false;
        }
    }

    @Override
    public int todaySign(Long id) {

        Long todayTime = timeUtil.todayZeroTime();
        Long nowTime = System.currentTimeMillis();

        Sign sign = new Sign();
        sign.setUserId(id);
        sign.setMinSignTime(todayTime);
        sign.setMaxSignTime(nowTime);
        // 根据用户id、时间戳范围查询，左右全闭，todayTime =< x =< nowTime
        List<Sign> signs = signMapper.findSignTimeList(sign);
        if(signs.size() > 0){
            // 查看用户当日是否签到，未签到为0，已签到为1
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public List<Sign> monthSign(Long id) {

        Long nowMonthZeroTime = timeUtil.nowMonthZeroTime();
        Long nowTime = System.currentTimeMillis();

        Sign sign = new Sign();
        sign.setUserId(id);
        sign.setMinSignTime(nowMonthZeroTime);
        sign.setMaxSignTime(nowTime);
        // 根据用户id、时间戳范围查询，左右全闭，nowMonthZeroTime =< x =< nowTime
        List<Sign> signs = signMapper.findSignTimeList(sign);
        log.info("查询当月签到的信息行数：{}",signs.size());

        return signs;
    }

    @Override
    public Boolean updateSignUser(Long id) {
        // 插入用户签到信息
        Long addSignId = addSign(id);
        if(addSignId > 0) {
            // 查询用户个人信息
            User user = userMapper.selectByPrimaryKey(id);
            Long score = user.getScore();
            user.setId(id);
            // 签到成功，总签到天数加一
            user.setSignSum(user.getSignSum() + 1L);
            // 昨天签到，查看连续签到天数
            if (yesterdaySign(id)) {
                // 当前连续签到天数加一
                user.setSignNowCon(user.getSignNowCon() + 1L);
                // 若 当前连续签到天数 大于 历史连续签到天数，修改 历史连续签到天数
                if(user.getSignNowCon() > user.getSignCon()){
                    user.setSignCon(user.getSignNowCon());
                }
                // 连续签到天数 >= 5，积分加 5
                if (user.getSignNowCon() >= 5L) {
                    user.setScore(score + 5L);
                } else {
                    for (Long i = 2L; i < 5L; i++) {
                        if (user.getSignNowCon() == i) {
                            // 连续签到天数 < 5，积分加 连续天数的值
                            user.setScore(score + i);
                        }
                    }
                }
            } else {
                // 第一次签到，历史连续签到天数为 1
                if(user.getSignSum() == 1){
                    user.setSignCon( 1L );
                }
                // 昨天没签到，今天签到，当前连续签到天数为 1
                user.setSignNowCon( 1L );
                // 昨天没签到，积分加 1
                user.setScore(score + 1L);
            }
            user.setUpdateAt(System.currentTimeMillis());
            int row = userMapper.updateByPrimaryKeySelective(user);
            if (row > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Long addSign(Long id) {
        Sign sign = new Sign();
        sign.setUserId(id);
        sign.setSignTime(System.currentTimeMillis());
        sign.setCreateId(id);
        sign.setUpdateId(id);
        sign.setCreateAt(System.currentTimeMillis());
        sign.setUpdateAt(System.currentTimeMillis());
        int aa = signMapper.insertSelective(sign);
        log.info("插入用户签到时间戳的ID：{}",sign.getId());

        return sign.getId();
    }
}
