package com.java.csht.mapper;

import com.java.csht.model.Cog;

public interface CogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cog record);

    int insertSelective(Cog record);

    Cog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cog record);

    int updateByPrimaryKey(Cog record);
}