package com.dxz.admin.service;

import com.dxz.admin.pojo.Manager;

import java.util.List;

public interface ManagerService {
    // 根据账号名称，准确查询账号
    Manager findManagerByName(String name);
    // 根据账号条件查询，无条件则查询列表
    List<Manager> findManagerListSearch(Manager manager);
    // 添加账号
    Long addManager(Manager manager);
    // 添加账号-角色关系数据
    Long addManagerRole(Long managerId, Long createId,Long roleId);
    // 根据id，删除账号
    Boolean deleteManager(Long id);
    // 更新账号信息
    Boolean updateManager(Manager manager, Long roleId);

}
