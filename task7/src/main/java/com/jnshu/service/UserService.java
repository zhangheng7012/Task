package com.jnshu.service;

import com.jnshu.pojo.User;

public interface UserService {
    // 根据名称、手机、邮箱查询，为null则返回false，不存在该用户名称
    public boolean isUserExist(User user);
    // 根据名称、手机、邮箱查询密码
    public String getPasswordBy(User user);
    // 根据名称查询id
    public String findIdBy(User user);
    // 添加用户
    public int insertUser(User user);
}
