package com.jnshu.service.impl;

import com.jnshu.dao.UserMapper;
import com.jnshu.pojo.User;
import com.jnshu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    // 根据名称查询，为null则返回false，不存在该用户名称
    @Override
    public boolean isUserExist(String name) {
        if(userMapper.findUsersByName(name)==null){
            return false;
        }
        return true;
    }
    // 根据名称查询密码
    @Override
    public String getPasswordByName(String name) {
        return userMapper.findUsersByName(name).getPassword();
    }

    @Override
    public String findIdByName(String name) {
        String userId = "" + userMapper.findIdByName(name);
        return userId;
    }

    // 添加用户
    @Override
    public int insertUser(User user) {
        int i = userMapper.insertUser(user);
        return i;
    }
}
