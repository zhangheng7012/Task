package com.dxz.admin.dao;

import com.dxz.admin.pojo.Connection;
import com.dxz.admin.pojo.ConnectionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConnectionMapper {
    long countByExample(ConnectionExample example);

    int deleteByExample(ConnectionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Connection record);

    int insertSelective(Connection record);

    List<Connection> selectByExample(ConnectionExample example);

    Connection selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Connection record, @Param("example") ConnectionExample example);

    int updateByExample(@Param("record") Connection record, @Param("example") ConnectionExample example);

    int updateByPrimaryKeySelective(Connection record);

    int updateByPrimaryKey(Connection record);
}