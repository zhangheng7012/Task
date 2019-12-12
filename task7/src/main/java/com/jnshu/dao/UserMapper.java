package com.jnshu.dao;

import com.jnshu.pojo.User;

public interface UserMapper {
    // 根据名称、手机、邮箱查询
    public User findUsersBy(User user);
    // 根据名称查询id
    public int findIdBy(User user);
    //    public int insertUser(@Param("name")String name, @Param("password")String password);
    // 添加用户
    public int insertUser(User user);
    // 修改密码
//    public int updatePasswordById(User user);
}