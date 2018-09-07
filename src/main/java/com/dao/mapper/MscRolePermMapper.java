package com.dao.mapper;

import com.dao.entity.MscRolePerm;
import com.dao.entity.MscRolePermExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MscRolePermMapper {
    int countByExample(MscRolePermExample example);

    int deleteByExample(MscRolePermExample example);

    int insert(MscRolePerm record);

    int insertSelective(MscRolePerm record);

    List<MscRolePerm> selectByExample(MscRolePermExample example);

    int updateByExampleSelective(@Param("record") MscRolePerm record, @Param("example") MscRolePermExample example);

    int updateByExample(@Param("record") MscRolePerm record, @Param("example") MscRolePermExample example);
}