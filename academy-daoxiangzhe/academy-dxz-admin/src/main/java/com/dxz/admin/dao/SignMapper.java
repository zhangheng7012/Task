package com.dxz.admin.dao;

import com.dxz.admin.pojo.Sign;
import com.dxz.admin.pojo.SignExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignMapper {
    long countByExample(SignExample example);

    int deleteByExample(SignExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Sign record);

    int insertSelective(Sign record);

    List<Sign> selectByExample(SignExample example);

    Sign selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sign record, @Param("example") SignExample example);

    int updateByExample(@Param("record") Sign record, @Param("example") SignExample example);

    int updateByPrimaryKeySelective(Sign record);

    int updateByPrimaryKey(Sign record);
}