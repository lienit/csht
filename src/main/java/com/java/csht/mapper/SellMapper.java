package com.java.csht.mapper;

import com.java.csht.model.Sell;

public interface SellMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Sell record);

    int insertSelective(Sell record);

    Sell selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Sell record);

    int updateByPrimaryKey(Sell record);
}