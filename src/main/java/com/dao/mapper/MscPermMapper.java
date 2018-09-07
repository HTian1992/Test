package com.dao.mapper;

import com.dao.entity.MscPerm;
import com.dao.entity.MscPermExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MscPermMapper {
    int countByExample(MscPermExample example);

    int deleteByExample(MscPermExample example);

    int insert(MscPerm record);

    int insertSelective(MscPerm record);

    List<MscPerm> selectByExample(MscPermExample example);

    int updateByExampleSelective(@Param("record") MscPerm record, @Param("example") MscPermExample example);

    int updateByExample(@Param("record") MscPerm record, @Param("example") MscPermExample example);
}