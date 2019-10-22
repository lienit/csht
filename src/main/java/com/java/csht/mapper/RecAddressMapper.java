package com.java.csht.mapper;

import com.java.csht.model.RecAddress;

public interface RecAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecAddress record);

    int insertSelective(RecAddress record);

    RecAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecAddress record);

    int updateByPrimaryKey(RecAddress record);
}