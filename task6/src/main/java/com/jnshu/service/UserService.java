package com.jnshu.service;

import com.jnshu.pojo.User;

public interface UserService {
    // 根据名称查询，为null则返回false，不存在该用户名称
    public boolean isUserExist(String name);
    // 根据名称查询密码
    public String getPasswordByName(String name);
    // 根据名称查询id
    public String findIdByName(String name);
    // 添加用户
    public int insertUser(User user);
}
