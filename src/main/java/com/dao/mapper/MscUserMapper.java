package com.dao.mapper;

import com.dao.entity.MscUser;
import com.dao.entity.MscUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MscUserMapper {
    int countByExample(MscUserExample example);

    int deleteByExample(MscUserExample example);

    int insert(MscUser record);

    int insertSelective(MscUser record);

    List<MscUser> selectByExample(MscUserExample example);

    int updateByExampleSelective(@Param("record") MscUser record, @Param("example") MscUserExample example);

    int updateByExample(@Param("record") MscUser record, @Param("example") MscUserExample example);
}