package com.dxz.admin.dao;

import com.dxz.admin.pojo.ManagerRole;
import com.dxz.admin.pojo.ManagerRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerRoleMapper {

    List<ManagerRole> selectManagerByRoleId(Long id);

    long countByExample(ManagerRoleExample example);

    long deleteByExample(ManagerRoleExample example);

    long deleteByPrimaryKey(Long id);

    long insert(ManagerRole record);

    long insertSelective(ManagerRole record);

    List<ManagerRole> selectByExample(ManagerRoleExample example);

    ManagerRole selectByPrimaryKey(Long id);

    long updateByExampleSelective(@Param("record") ManagerRole record, @Param("example") ManagerRoleExample example);

    long updateByExample(@Param("record") ManagerRole record, @Param("example") ManagerRoleExample example);

    long updateByPrimaryKeySelective(ManagerRole record);

    long updateByPrimaryKey(ManagerRole record);
}