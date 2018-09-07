package com.dao.mapper;

import com.dao.entity.MscRole;
import com.dao.entity.MscRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MscRoleMapper {
    int countByExample(MscRoleExample example);

    int deleteByExample(MscRoleExample example);

    int insert(MscRole record);

    int insertSelective(MscRole record);

    List<MscRole> selectByExample(MscRoleExample example);

    int updateByExampleSelective(@Param("record") MscRole record, @Param("example") MscRoleExample example);

    int updateByExample(@Param("record") MscRole record, @Param("example") MscRoleExample example);
}