package com.dao.mapper;

import com.dao.entity.MscUserRole;
import com.dao.entity.MscUserRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MscUserRoleMapper {
    int countByExample(MscUserRoleExample example);

    int deleteByExample(MscUserRoleExample example);

    int insert(MscUserRole record);

    int insertSelective(MscUserRole record);

    List<MscUserRole> selectByExample(MscUserRoleExample example);

    int updateByExampleSelective(@Param("record") MscUserRole record, @Param("example") MscUserRoleExample example);

    int updateByExample(@Param("record") MscUserRole record, @Param("example") MscUserRoleExample example);
}