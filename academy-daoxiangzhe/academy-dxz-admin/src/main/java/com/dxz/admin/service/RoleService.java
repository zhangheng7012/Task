package com.dxz.admin.service;

import com.dxz.admin.pojo.Manager;
import com.dxz.admin.pojo.Role;
import java.util.List;
import java.util.Set;

public interface RoleService {
    // 根据账号名称，查询角色名称
    Set<String> findRoleNameByManagerName(String name);
    // 根据账号名称，查询角色
    List<Role> listRolesByName(String name);
    // 根据账号id，查询角色
    List<Role> listRolesById(Long managerId);
    // 角色列表
    List<Role> listRolesByNull();
    // 根据角色名称，准确查询角色
    Role findRoleByName(String name);
    // 添加角色
    Long addRole(Role role);
    // 添加角色-权限关系数据
    List<Long> addRolePer(Long roleId, Long createId,List<Long> perIdList);
    // 根据id，删除账号
    Boolean deleteRole(Long id);
    // 更新账号信息
    Boolean updateRole(Role role, List<Long> perIdList);

}
