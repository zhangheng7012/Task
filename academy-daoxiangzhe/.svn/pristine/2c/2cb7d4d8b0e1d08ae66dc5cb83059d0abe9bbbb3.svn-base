package com.dxz.admin.service.impl;

import com.dxz.admin.dao.UserMapper;
import com.dxz.admin.pojo.User;
import com.dxz.admin.pojo.UserExample;
import com.dxz.admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> findUserListSearch(User user) {
        List<User> users = userMapper.findUserListSearch(user);
        log.info("查询的用户列表长度：{}",users.size());
        return users;
    }

    @Override
    public Boolean updateUserStatus(User user) {
        user.setUpdateAt(System.currentTimeMillis());
        int row = userMapper.updateByPrimaryKeySelective(user);
        if(row > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<User> findTeacherByName(User user) {
        // 根据名称查询，这里不是模糊查询
        List<User> users = userMapper.findTeacherByName(user);
        log.info("根据名称查找老师列表长度：{}",users.size());
        return users;
    }

    @Override
    public Long addUser(User user) {

        user.setScore(0L);
        // 用户状态，1为解冻，0为冻结，默认为1
        user.setStatus(1);
        user.setSignSum(0L);
        user.setSignCon(0L);
        user.setSignNowCon(0L);

        user.setUpdateId(user.getCreateId());
        user.setCreateAt(System.currentTimeMillis());
        user.setUpdateAt(System.currentTimeMillis());
        int aa = userMapper.insertSelective(user);
        log.info("插入用户ID：{}",user.getId());

        return user.getId();
    }

    @Override
    public Boolean deleteUser(Long id) {
        int row = userMapper.deleteByPrimaryKey(id);
        if(row > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean deleteTeacher(Long id) {
        int row = userMapper.deleteByPrimaryKey(id);
        if(row > 0){
            return true;
        }else {
            return false;
        }
    }
}
