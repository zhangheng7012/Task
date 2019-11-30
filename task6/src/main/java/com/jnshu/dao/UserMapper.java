package com.jnshu.dao;

import com.jnshu.pojo.User;

public interface UserMapper {
    // 根据名称查询
    public User findUsersByName(String name);
    // 根据名称查询id
    public int findIdByName(String name);
//    public int insertUser(@Param("name")String name, @Param("password")String password);
    // 添加用户
    public int insertUser(User user);
    // 修改密码
//    public int updatePasswordById(User user);
}