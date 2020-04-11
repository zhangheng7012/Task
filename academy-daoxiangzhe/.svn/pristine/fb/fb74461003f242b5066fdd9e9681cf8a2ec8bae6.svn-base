package com.dxz.admin.service.impl;

import com.dxz.admin.dao.ManagerMapper;
import com.dxz.admin.dao.ManagerRoleMapper;
import com.dxz.admin.dao.RoleMapper;
import com.dxz.admin.dao.RolePermissionMapper;
import com.dxz.admin.pojo.*;
import com.dxz.admin.service.ManagerService;
import com.dxz.admin.service.RoleService;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    RoleMapper roleMapper;
    @Resource
    ManagerMapper managerMapper;
    @Autowired
    ManagerService managerService;
    @Resource
    ManagerRoleMapper managerRoleMapper;
    @Resource
    RolePermissionMapper rolePerMapper;

    @Override
    public List<Role> listRolesByNull() {
        List<Role> roles = roleMapper.listRolesByNull();
        return roles;
    }

    @Override
    public Set<String> findRoleNameByManagerName(String name) {
        Set<String> result = new HashSet<>();
        List<Role> roles = listRolesByName(name);
        for (Role role : roles) {
            result.add(role.getName());
//            log.info("拥有角色名称：{}",role.getName());
        }
        return result;
    }

    @Transactional
    @Override
    public List<Role> listRolesByName(String name) {
        List<Role> roles = new ArrayList<>();
        Manager manager = managerService.findManagerByName(name);
        if(null == manager)
            return roles;
        roles = listRolesById(manager.getId());
        return roles;
    }

    @Override
    public List<Role> listRolesById(Long managerId) {
        List<Role> roles = roleMapper.listRolesByManagerId(managerId);
        return roles;
    }

    @Override
    public Role findRoleByName(String name) {
        // 根据名称查询，这里不是模糊查询
        List<Role> role = roleMapper.findRoleByName(name);
        if(role.size() > 0)
            return role.get(0);
        return null;
    }

    @Override
    public Long addRole(Role role) {

        role.setUpdateId(role.getCreateId());
        role.setCreateAt(System.currentTimeMillis());
        role.setUpdateAt(System.currentTimeMillis());
        roleMapper.insertSelective(role);
        log.info("插入角色ID：{}",role.getId());

        return role.getId();
    }

    @Override
    public List<Long> addRolePer(Long roleId, Long createId, List<Long> perIdList) {
        List<Long> addRolePerId = new ArrayList<>();

        if(perIdList.size() == 0){
            log.info("未选择权限，没有插入角色-权限关系");
            return addRolePerId;
        }
        for (Long perId : perIdList) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRid(roleId);
            rolePermission.setPid(perId);

            rolePermission.setCreateId(createId);
            rolePermission.setUpdateId(createId);
            rolePermission.setCreateAt(System.currentTimeMillis());
            rolePermission.setUpdateAt(System.currentTimeMillis());
            rolePerMapper.insertSelective(rolePermission);
//            log.info("插入角色-权限关系ID：{}",rolePermission.getId());

            addRolePerId.add(rolePermission.getId());
        }
        return addRolePerId;
    }

    @Override
    public Boolean deleteRole(Long id) {
        // 联表删除角色、角色-权限关系
        int row = roleMapper.deleteByRoleId(id);
        log.info("删除数据行数：{}",row);
        if(row > 0){
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    @Override
    public Boolean updateRole(Role role, List<Long> perIdList) {
        role.setUpdateAt(System.currentTimeMillis());
        int row = roleMapper.updateByPrimaryKeySelective(role);
//        log.info("编辑角色行数：{}",row);

        RolePermissionExample example2 = new RolePermissionExample();
        example2.createCriteria().andRidEqualTo(role.getId());
        int row2 = rolePerMapper.deleteByExample(example2);
//        log.info("删除角色-权限关系行数：{}",row2);

        List<Long> ids = new ArrayList<>();

        for (Long perId : perIdList) {
            RolePermission rolePer = new RolePermission();
            rolePer.setRid(role.getId());
            rolePer.setPid(perId);

            rolePer.setCreateId(role.getUpdateId());
            rolePer.setUpdateId(role.getUpdateId());
            rolePer.setCreateAt(System.currentTimeMillis());
            rolePer.setUpdateAt(System.currentTimeMillis());
            rolePerMapper.insertSelective(rolePer);

            ids.add(rolePer.getId());
//            log.info("插入角色-权限关系ID：{}",rolePer.getId());
        }
        // 都成功，才是编辑成功
        if(row > 0 && row2 > 0 && ids.size() > 0){
            return true;
        }else {
            return false;
        }
    }
}
